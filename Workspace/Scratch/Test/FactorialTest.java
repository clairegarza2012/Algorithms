import junit.framework.Assert;

import org.junit.Test;

import edu.neumont.csc250.Factorial;


public class FactorialTest {

	private Factorial fact = new Factorial();
	
	@Test
	public void test() {

		Assert.assertEquals(1, fact.findFactorialRecursive(0));
		Assert.assertEquals(1, fact.findFactorialRecursive(1));
		Assert.assertEquals(5040, fact.findFactorialRecursive(7));
		
		Assert.assertEquals(1, fact.findFactorialIterative(0));
		Assert.assertEquals(1, fact.findFactorialIterative(1));
		Assert.assertEquals(5040, fact.findFactorialIterative(7));
	}

}
