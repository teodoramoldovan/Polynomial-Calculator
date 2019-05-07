package PT2018.assigment1.Assigment1PolynomialCalculator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PolinomSortareSiEliminareDuplicateTest {

	@Test
	public void testSortSiEliminDup() {
		//cream o lista de monoame corespunzatoare polinomului: 1.0x^2+4.0x^3+6.0x^5+3.0x^2+3.0x^1
		ArrayList<Monom> monom = new ArrayList<Monom>();
		monom.add(new Monom(2,1.0));//exponent coeficient
		monom.add(new Monom(3,4.0));//exponent coeficient
		monom.add(new Monom(5,6.0));
		monom.add(new Monom(2,3.0));
		monom.add(new Monom(1,3.0));
		Polinom p1=new Polinom(monom);
		p1.sortareSiEliminareDuplicate();
		String result=p1.toString();
		assertEquals("6.0x^5+4.0x^3+4.0x^2+3.0x^1",result);
	}

}
