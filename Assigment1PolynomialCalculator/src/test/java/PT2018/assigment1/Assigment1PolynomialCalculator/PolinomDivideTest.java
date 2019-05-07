package PT2018.assigment1.Assigment1PolynomialCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolinomDivideTest {

	@Test
	public void testDivide() {
		String[] mon1= {"2x^2","4x","3"};
		String[] mon2= {"x","1"};
		Polinom p1=new Polinom(mon1);
		Polinom p2=new Polinom(mon2);
		String result=(p1.divide(p2)).toString();
		assertEquals("2.0x^1+2.0",result);//restul
		assertEquals("1.0",p1.toString());//catul
	}

}
