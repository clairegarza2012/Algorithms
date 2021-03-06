package edu.neumont.csc250;

import java.util.ArrayDeque;
import java.util.HashMap;
import edu.neumont.util.Client;
import edu.neumont.util.QueueableService;
import edu.neumont.util.Server;

public class GroceryStore implements QueueableService{

	private HashMap<Server, ArrayDeque<Client>> lines = new HashMap<Server, ArrayDeque<Client>>();

	public GroceryStore(int numberOfCashiers){
		for (int i = 0; i < numberOfCashiers; i++){
			Server s = new Server();
			lines.put(s, new ArrayDeque<Client>());
		}
	}

	@Override
	public double getAverageClientWaitTime() {

		ArrayList<Double> averages = new ArrayList<Double>();

		for (Server s : lines.keySet()){
			ArrayDeque<Client> line = lines.get(s);
			double sum = 0;
			for (Client c: line){
				sum += c.getExpectedServiceTime();
			}
			double length = line.size();
			averages.add(sum/length);
		}

		double sum = 0;
		for (Double b : averages){
			sum += b;
		}
		int length = averages.size();
		double waitTime = sum / length;

		return waitTime;
	}

	@Override
	public double getClientWaitTime(Client client) {

		double waitTime = 0;
		
		for (Server s : lines.keySet()){
			ArrayDeque<Client> line = lines.get(s);
			if (line.contains(client)){
				for (Client c: line){
					if (c == client){
						return waitTime;
					}
					waitTime += c.getExpectedServiceTime();
				}
			}
		}

		return waitTime;
	}

	@Override
	public boolean addClient(Client client) {

		if (client == null)
			return false;

		Server minServerLine = null;
		for (Server s: lines.keySet()){

			if (minServerLine == null){
				minServerLine = new Server();
				minServerLine = s;
			}
			else{
				int minTime = 0;
				ArrayDeque<Client> minLineClients = lines.get(minServerLine);
				for (Client c: minLineClients){
					minTime += c.getExpectedServiceTime();
				}
				int sTime = 0;
				ArrayDeque<Client> sLineClients = lines.get(s);
				for (Client c: sLineClients){
					sTime += c.getExpectedServiceTime();
				}
				if (sTime < minTime)
					minServerLine = s;
			}
		}

		ArrayDeque<Client> minLineClients = lines.get(minServerLine);
		minLineClients.add(client);
		lines.remove(minServerLine);

		if (minLineClients.size() == 1){
			minServerLine.setCurrentlyServing(minLineClients.getFirst());
		}

		lines.put(minServerLine, minLineClients);

		return true;
	}

	@Override
	public void advanceMinute() {

		HashMap<Server, ArrayDeque<Client>> temp = new HashMap<Server, ArrayDeque<Client>>();
		temp.putAll(lines);
		for (Server s : lines.keySet()){

			if (lines.get(s).size() > 0){
				int remainingTime = s.getCurrentlyServing().servedMinute();

				if (remainingTime <= 0){
					ArrayDeque<Client> sClients = new ArrayDeque<>();
					sClients.addAll(temp.get(s));
					sClients.pollFirst();
					if (sClients != null || sClients.size() > 0){
						s.setCurrentlyServing(sClients.getFirst());
						temp.remove(s);
						temp.put(s, sClients);
					}
				}
			}

		}

		lines.clear();
		lines.putAll(temp);
	}

	public void printLines(){

		for (Server s : lines.keySet()){
			System.out.println("Server: " + s);
			for (Client c : lines.get(s)){
				System.out.println("\t" + c + ": " + c.getExpectedServiceTime() + ", ");
			}
		}
	}

}
