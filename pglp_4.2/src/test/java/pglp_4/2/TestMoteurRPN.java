package uvsq.RPN;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uvsq.exception.MaxValueException;
import uvsq.exception.OperandeInsuffisanteException;

public class TestMoteurRPN {
	public MoteurRPN m;

	@Before
	public void stetUp() {
		m = new MoteurRPN();
	}

	@Test
	public void calculPlusTest() throws MaxValueException, OperandeInsuffisanteException {

		m.addOperande(2.5);
		m.addOperande(6.3);

		assertEquals(8.8, m.calcul(Operation.PLUS), 0);
	}

	@Test
	public void calculMoinsTest() throws MaxValueException, OperandeInsuffisanteException {

		m.addOperande(2);
		m.addOperande(6);

		assertEquals(4, m.calcul(Operation.MOINS), 0);
	}

	@Test
	public void calculMultTest() throws MaxValueException, OperandeInsuffisanteException {

		m.addOperande(2);
		m.addOperande(6);

		assertEquals(12, m.calcul(Operation.MULT), 0);
	}

	@Test
	public void calculDivTest() throws MaxValueException, OperandeInsuffisanteException {

		m.addOperande(2);
		m.addOperande(6);

		assertEquals(3, m.calcul(Operation.DIV), 0);
	}

	@Test(expected = MaxValueException.class)
	public void MaxValueExceptionTest() throws MaxValueException {
		m.addOperande(100000000000000000d);
	}

	@Test(expected = OperandeInsuffisanteException.class)
	public void OperandeInsuffisanteTest() throws MaxValueException, OperandeInsuffisanteException {
		m.addOperande(2);
		m.calcul(Operation.PLUS);
	}
}
