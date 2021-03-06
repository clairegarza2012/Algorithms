package edu.neumont.csc250;

import java.util.ArrayDeque;
import java.util.HashMap;

import edu.neumont.util.Client;
import edu.neumont.util.QueueableService;
import edu.neumont.util.Server;

public class Bank implements QueueableService{

	private ArrayDeque<Client> clientsWaitingForTeller = new ArrayDeque<Client>();
	private ArrayList<Server> tellers = new ArrayList<Server>();

	public Bank(int numberOfTellers){

		for (int i = 0; i < numberOfTellers; i++){
			Server s = new Server();
			tellers.add(s);
		}

	}

	@Override
	public double getAverageClientWaitTime() {

		// get the average wait time for everyone in line
			// add up all the averages and divide by the clients waiting in line
		double sum = 0;

		for (Client c: clientsWaitingForTeller){
			sum += this.getClientWaitTime(c);
		}

		return sum / clientsWaitingForTeller.size();
	}

//	private double getClientWaitNumber(Client client){
//		
//		double waitNumber = 0;
//		double waitTime = 0;
//
//		HashMap<Server, Double> lineTime = new HashMap<Server, Double>();
//		HashMap<Server, Double> lineNumber = new HashMap<Server, Double>();
//
//		for (Server s: tellers){
//			if (s.getCurrentlyServing() == client){
//				return 0;
//			}
//			lineTime.put(s, (double)s.getCurrentlyServing().getExpectedServiceTime());
//			lineNumber.put(s, 1d);
//		}
//
//		for (Client c : clientsWaitingForTeller){
//			Server s = findShortestLine(lineTime);
//			waitTime = lineTime.get(s);
//			waitNumber = lineNumber.get(s);
//			if (c == client){
//				return waitNumber;
//			}
//			lineNumber.put(s, lineNumber.get(s) + 1);
//			lineTime.remove(s);
//			lineTime.put(s, (double)(waitTime + c.getExpectedServiceTime()));
//		}
//
//		return waitNumber;
//	}
	
	@Override
	public double getClientWaitTime(Client client) {

		double waitTime = 0;

		HashMap<Server, Double> lineTime = new HashMap<Server, Double>();

		for (Server s: tellers){
			if (s.getCurrentlyServing() == client){
				return 0;
			}
			lineTime.put(s, (double)s.getCurrentlyServing().getExpectedServiceTime());
		}

		for (Client c : clientsWaitingForTeller){
			Server s = findShortestLine(lineTime);
			waitTime = lineTime.get(s);
			if (c == client){
				return waitTime;
			}
			lineTime.remove(s);
			lineTime.put(s, (double)(waitTime + c.getExpectedServiceTime()));
		}

		return waitTime;
	}

	private Server findShortestLine(HashMap<Server, Double> list){

		Server shortestLine = null;
		for (Server s: list.keySet()){
			if (shortestLine == null){
				shortestLine = new Server();
				shortestLine = s;
			}else if (list.get(shortestLine) > list.get(s)){
				shortestLine = s;
			}
		}

		return shortestLine;
	}

	@Override
	public boolean addClient(Client client) {

		if (client == null)
			return false;

		Server availableTeller = null;

		for (Server s: tellers){
			if (s.getCurrentlyServing() == null){
				availableTeller = new Server();
				availableTeller = s;
			}
		}

		if (availableTeller != null){
			availableTeller.setCurrentlyServing(client);
		}else{
			clientsWaitingForTeller.add(client);
		}

		return true;
	}

	@Override
	public void advanceMinute() {

		for (Server s: tellers){
			int remainingTime = s.getCurrentlyServing().servedMinute();

			if (remainingTime <= 0){
				Client c = clientsWaitingForTeller.pollFirst();
				s.setCurrentlyServing(c);
			}
		}

	}

	public void printLines(){

		for (Server s: tellers){
			System.out.println("Server: " + s);
			System.out.println("\tClient: " + s.getCurrentlyServing() + " " + s.getCurrentlyServing().getExpectedServiceTime());
		}
		System.out.println("\nWaiting:");
		for (Client c: clientsWaitingForTeller){
			System.out.println("\t" + c + " " + c.getExpectedServiceTime());
		}
	}

}
