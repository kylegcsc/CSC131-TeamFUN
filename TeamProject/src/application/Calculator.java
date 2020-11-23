package application;

public class Calculator {
	
	// Singleton design pattern
	private static Calculator instance;	
	
	public static Calculator get() {
		if(instance == null)
			instance = new Calculator();
		return instance;		
	}
	
	private Calculator() {
		operation = null;
		value = 0.0;
	}
	
	// Strategy design pattern
	private OperationStrategy operation;
	private double value;
	
	public Calculator setOperation(OperationStrategy operationStrategy) {
		operation = operationStrategy;
		return this;
	}
	
	public Calculator evaluate(double operand) {
		value = operation.doOperation(value, operand);
		return this;
	}
	
	public double getValue() {
		return value;
	}
	
	public void reset() {
		value = 0.0;
	}
}
