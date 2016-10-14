package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEmptyString() {
		assertEquals(0,Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1,Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3,Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

   	@Test
   	public void testMultipleLines(){
    	assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testNegativeNumbers(){

		try {
			assertEquals(-4, Calculator.add("2,-4,3,-5"));
		}
		catch (IllegalArgumentException aMessage) {
			assertEquals("Negatives not allowed: [-4, -5]", aMessage.getMessage());
		}
	}

	@Test
	public void testBigNumber(){
		assertEquals(2, Calculator.add("1001,2"));
		assertEquals(0,Calculator.add("1001"));
	}

	@Test
	public void testAnotherSeperator(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	
}