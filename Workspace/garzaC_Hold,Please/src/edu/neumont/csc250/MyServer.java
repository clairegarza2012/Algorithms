package edu.neumont.csc250;

public class MyServer {

	private MyClient currentlyServing;

	/**
	 * Returns whether or not this server is currently serving a client
	 * @return
	 */
	public boolean hasCustomer() {
		return currentlyServing != null;
	}

	/**
	 * Returns the client that the server is currently serving
	 * @return
	 */
	public MyClient getCurrentlyServing() {
		return currentlyServing;
	}


	/**
	 * Gives the server a client
	 * 
	 * @param currentlyServing
	 */
	public void setCurrentlyServing(MyClient currentlyServing) {
		this.currentlyServing = currentlyServing;
	}

	/**
	 * Serve client for one minute
	 */
	public void serveMinute() {
		if ( currentlyServing != null && currentlyServing.servedMinute() <= 0 ) {
			currentlyServing = null;
		}
	}
}
