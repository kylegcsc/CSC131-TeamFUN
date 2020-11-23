package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	Calculator calc = Calculator.get();

	@Test
	void testAdd() {
		calc.setOperation(new OperationStrategyAdd()).evaluate(5);
		assertEquals(5, Calculator.get().getValue());
		calc.reset();
	}
	
	@Test
	void testSubtract() {
		calc.setOperation(new OperationStrategySubtract()).evaluate(5.0);
		assertEquals(-5.0, Calculator.get().getValue());
		calc.reset();
	}
	
	@Test
	void testDivide() {
		calc.setOperation(new OperationStrategyAdd()).evaluate(5);
		calc.setOperation(new OperationStrategyDivide()).evaluate(2);
		assertEquals(2.5, Calculator.get().getValue());
		calc.reset();
	}
	
	@Test
	void testMultiply() {
		calc.setOperation(new OperationStrategyAdd()).evaluate(5);
		calc.setOperation(new OperationStrategyMultiply()).evaluate(2);
		assertEquals(10, Calculator.get().getValue());
		calc.reset();
	}

}
