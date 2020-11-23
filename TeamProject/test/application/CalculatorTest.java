package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testAdd() {
		Calculator calc = Calculator.get();
		calc.setOperand(5);
		calc.evaluate();
		assertEquals(5, calc.getValue());
	}

}
