package edu.neumont.csc250.test;

import org.junit.Assert;
import org.junit.Test;

import edu.neumont.csc250.GroceryStore;
import edu.neumont.util.Client;

public class GroceryStoreTest {

	private GroceryStore store = new GroceryStore(3);
	
	@Test
	public void test() {
		
		Client client1 = new Client(5);
		Client client2 = new Client(6);
		Client client3 = new Client(3);
		Client client4 = new Client(10);
		Client client5 = new Client(1);

		store.addClient(client1);
		store.addClient(client2);
		store.addClient(client3);
		store.addClient(client4);
		store.addClient(client5);

		store.printLines();

		Assert.assertEquals((Double)0d, (Double)store.getClientWaitTime(client1));
		Assert.assertEquals((Double)0d, (Double)store.getClientWaitTime(client2));
		Assert.assertEquals((Double)0d, (Double)store.getClientWaitTime(client3));
		Assert.assertEquals((Double)3d, (Double)store.getClientWaitTime(client4));
		Assert.assertEquals((Double)5d, (Double)store.getClientWaitTime(client5));

		store.advanceMinute();		
		
		Assert.assertEquals((Double)0d, (Double)store.getClientWaitTime(client1));
		Assert.assertEquals((Double)0d, (Double)store.getClientWaitTime(client2));
		Assert.assertEquals((Double)0d, (Double)store.getClientWaitTime(client3));
		Assert.assertEquals((Double)2d, (Double)store.getClientWaitTime(client4));
		Assert.assertEquals((Double)4d, (Double)store.getClientWaitTime(client5));
	}

}
