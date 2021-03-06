package edu.neumont.csc250.test;

import org.junit.Assert;
import org.junit.Test;
import edu.neumont.csc250.Hospital;
import edu.neumont.csc250.MyClient;

public class HospitalTest {

	private Hospital store = new Hospital(3);

	@Test
	public void test() {

		MyClient client1 = new MyClient(5, 5);
		MyClient client2 = new MyClient(6, 4);
		MyClient client3 = new MyClient(3, 3);
		MyClient client4 = new MyClient(10, 2);
		MyClient client5 = new MyClient(1, 10);
		MyClient client11 = new MyClient(5, 5);
		MyClient client12 = new MyClient(6, 3);
		MyClient client13 = new MyClient(3, 2);
		MyClient client14 = new MyClient(10, 20);
		MyClient client15 = new MyClient(1, 4);

		store.addClient(client1);
		store.addClient(client2);
		store.addClient(client3);
		store.addClient(client4);
		store.addClient(client5);
		store.addClient(client11);
		store.addClient(client12);
		store.addClient(client13);
		store.addClient(client14);
		store.addClient(client15);

		Assert.assertEquals((Double)0d, (Double)store.getClientWaitTime(client1));

		Assert.assertEquals((Double)3d, (Double)store.getClientWaitTime(client4));

		Assert.assertEquals((Double)8d, (Double)store.getClientWaitTime(client15));
		
		store.advanceMinute();

		Assert.assertEquals((Double)8d, (Double)store.getClientWaitTime(client1));

		Assert.assertEquals((Double)0d, (Double)store.getClientWaitTime(client4));

		Assert.assertEquals((Double)0d, (Double)store.getClientWaitTime(client13));
		
		Assert.assertEquals((Double)8d, (Double)store.getClientWaitTime(client15));

		System.out.println(store.getAverageClientWaitTime());
	}

}
