package edu.neumont.csc250;

import java.util.HashMap;

public class Hospital {

	private ArrayList<MyClient> waitingRoom = new ArrayList<MyClient>();
	private ArrayList<MyServer> nurses = new ArrayList<MyServer>();

	public Hospital(int numberOfNurses){

		for (int i = 0; i < numberOfNurses; i++){
			MyServer s = new MyServer();
			nurses.add(s);
		}

	}

	//
	public double getAverageClientWaitTime() {

		double sum = 0;

		for (MyClient c: waitingRoom){
			sum += this.getClientWaitTime(c);
		}

		return sum / waitingRoom.size();
	}

//	private double getClientWaitNumber(MyClient client){
//
//		double waitNumber = 0;
//		double waitTime = 0;
//
//		HashMap<MyServer, Double> lineTime = new HashMap<MyServer, Double>();
//		HashMap<MyServer, Double> lineNumber = new HashMap<MyServer, Double>();
//
//		for (MyServer s: nurses){
//			if (s.getCurrentlyServing() == client){
//				return 0;
//			}
//			lineTime.put(s, (double)s.getCurrentlyServing().getExpectedServiceTime());
//			lineNumber.put(s, 1d);
//		}
//
//		for (MyClient c : waitingRoom){
//			MyServer s = findShortestLine(lineTime);
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

	//
	public double getClientWaitTime(MyClient client) {

		ArrayList<MyClient> temp = new ArrayList<MyClient>();
		temp.addAll(sort(waitingRoom));

		double waitTime = 0;

		HashMap<MyServer, Double> lineTime = new HashMap<MyServer, Double>();

		for (MyServer s: nurses){
			if (s.getCurrentlyServing() == client){
				return 0;
			}
			lineTime.put(s, (double)s.getCurrentlyServing().getExpectedServiceTime());
		}

		for (MyClient c : temp){
			MyServer s = findShortestLine(lineTime);
			waitTime = lineTime.get(s);
			if (c == client){
				return waitTime;
			}
			lineTime.remove(s);
			lineTime.put(s, (double)(waitTime + c.getExpectedServiceTime()));
		}

		return waitTime;
	}

	public ArrayList<MyClient> sort(ArrayList<MyClient> list) {

		MyClient[] temp = new MyClient[list.size()];

		for (int i = 0; i < list.size(); i++){
			temp[i] = list.get(i);
		}

		for (int i = 0; i < temp.length - 1; i++){

			int smallestIndex = i;
			for (int j = i + 1; j < temp.length; j++){

				if (temp[smallestIndex].getAttritionTime() > temp[j].getAttritionTime()){
					smallestIndex = j;
				}
			}

			MyClient tempClient = temp[i];
			temp[i] = temp[smallestIndex];
			temp[smallestIndex] = tempClient;
		}

		ArrayList<MyClient> sortedList = new ArrayList<MyClient>();

		for (MyClient c : temp){
			sortedList.add(c);
		}

		return sortedList;
	}

	private MyServer findShortestLine(HashMap<MyServer, Double> list){

		MyServer shortestLine = null;
		for (MyServer s: list.keySet()){
			if (shortestLine == null){
				shortestLine = new MyServer();
				shortestLine = s;
			}else if (list.get(shortestLine) > list.get(s)){
				shortestLine = s;
			}
		}

		return shortestLine;
	}

	//
	public boolean addClient(MyClient client) {

		if (client == null)
			return false;

		MyServer availableTeller = null;

		for (MyServer s: nurses){
			if (s.getCurrentlyServing() == null){
				availableTeller = new MyServer();
				availableTeller = s;
			}
		}

		if (availableTeller != null){
			availableTeller.setCurrentlyServing(client);
		}else{
			waitingRoom.add(client);
		}

		return true;
	}

	//
	public void advanceMinute() {

		// If service time runs out
		for (MyServer s: nurses){
			int remainingTime = s.getCurrentlyServing().servedMinute();

			if (remainingTime <= 0){
				MyClient c = findLowest(waitingRoom); // finds client with lowest attrition time
				s.setCurrentlyServing(c);
			}
		}

		// If attrition time is 1
		for (MyClient c : waitingRoom){
			int remainingTime = c.waitedMinute();

			if (remainingTime == 1){ // replace with highest attrition time
				MyServer highest = findHighest(nurses);
				MyClient cl = highest.getCurrentlyServing();
				waitingRoom.add(cl);
				highest.setCurrentlyServing(c);
				waitingRoom.remove(c);
			}
			else if (remainingTime == 0){ // If client was placed too late remove
				waitingRoom.remove(c);
			}
		}
	}

	private MyServer findHighest(ArrayList<MyServer> nurses2){
		
		MyServer highest = null;
		
		for (MyServer s : nurses2){
			if (highest == null){
				highest = new MyServer();
				highest = s;
			}else if (highest.getCurrentlyServing().getAttritionTime() < s.getCurrentlyServing().getAttritionTime()){
				highest = s;
			}
		}
		
		return highest;
	}
	
	private MyClient findLowest(ArrayList<MyClient> waitingRoom2) {

		MyClient lowest = null;

		for (MyClient c : waitingRoom2){
			if (lowest == null){
				lowest = new MyClient(c.getExpectedServiceTime(), c.getAttritionTime());
			}
			else if (lowest.getAttritionTime() > c.getAttritionTime()){
				lowest = c;
			}
		}

		return lowest;
	}

	public void printLines(){

		for (MyServer s: nurses){
			System.out.println("MyServer: " + s);
			System.out.println("\tClient: " + s.getCurrentlyServing() + " " + s.getCurrentlyServing().getExpectedServiceTime() + " " + s.getCurrentlyServing().getAttritionTime());
		}
		System.out.println("\nWaiting:");
		for (MyClient c: waitingRoom){
			System.out.println("\tClient: " + c + " " + c.getExpectedServiceTime() + " " + c.getAttritionTime());
		}
	}

}
