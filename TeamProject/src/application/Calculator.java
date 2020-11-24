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
		leftOperand = 0.0;
	}
	
	// Strategy design pattern
	private OperationStrategy operation;
	
	private double leftOperand;
	
	public Calculator setOperation(OperationStrategy operationStrategy) {
		operation = operationStrategy;
		return this;
	}
	
	public double evaluate(double rightOperand) {
		leftOperand = operation.doOperation(leftOperand, rightOperand);
		return leftOperand;
	}
	
	public double evaluate(double leftOperand, double rightOperand) {
		this.leftOperand = operation.doOperation(leftOperand, rightOperand);
		return leftOperand;
	}
	
	public double getValue() {
		return leftOperand;
	}
	
	public void setValue(double value) {
		this.leftOperand = value;
	}
	
	public void reset() {
		leftOperand = 0.0;
	}
}
