package PT2018.assigment1.Assigment1PolynomialCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolinomMultiplyTest {

	@Test
	public void testMultiply() {
		String[] mon1= {"2x^2","4x^3","-1"};
		String[] mon2= {"3x^2","5x","6"};
		Polinom p1=new Polinom(mon1);
		Polinom p2=new Polinom(mon2);
		String result=(p1.multiply(p2)).toString();
		assertEquals("12.0x^5+26.0x^4+34.0x^3+9.0x^2-5.0x^1-6.0",result);
	}

}
