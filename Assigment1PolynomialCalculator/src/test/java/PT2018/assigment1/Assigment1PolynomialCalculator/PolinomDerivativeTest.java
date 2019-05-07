package PT2018.assigment1.Assigment1PolynomialCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolinomDerivativeTest {

	@Test
	public void testDerivative() {
		String[] mon1= {"2x^2","-4x^3","-1"};
		Polinom p1=new Polinom(mon1);
		String result=(p1.derivative()).toString();
		assertEquals("-12.0x^2+4.0x^1",result);
	}

}
