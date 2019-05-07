package PT2018.assigment1.Assigment1PolynomialCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolinomSubTest {

	@Test
	public void testSub() {
		String[] mon1= {"2x^2","4x^3","-1"};
		String[] mon2= {"3x^2","5x","6"};
		Polinom p1=new Polinom(mon1);
		Polinom p2=new Polinom(mon2);
		String result=(p1.subtract(p2)).toString();
		assertEquals("4.0x^3-1.0x^2-5.0x^1-7.0",result);
	}

}