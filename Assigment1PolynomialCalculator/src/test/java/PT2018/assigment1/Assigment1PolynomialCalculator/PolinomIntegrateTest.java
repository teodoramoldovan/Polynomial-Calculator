package PT2018.assigment1.Assigment1PolynomialCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolinomIntegrateTest {

	@Test
	public void testIntegrate() {
		String[] mon1= {"6x^2","-4x^3","-1"};
		Polinom p1=new Polinom(mon1);
		String result=(p1.integrate()).toString();
		assertEquals("-1.0x^4+2.0x^3-1.0x^1",result);
	}

}
