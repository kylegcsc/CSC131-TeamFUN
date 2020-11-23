package application;

public class Calculator {
	
	// Singleton pattern
	private static Calculator instance;	
	
	public static Calculator get() {
		if(instance == null)
			instance = new Calculator();
		return instance;		
	}
	
	private Calculator() {
		operation = new OperationStrategyAdd();
		value = 0;
		operand = 0;
	}
	
	OperationStrategy operation;
	private long value;
	private long operand;	
	
	public void evaluate() {
		value = operation.doOperation(value, operand);
	}
	
	public long getValue() {
		return value;
	}
	
	public long getOperand() {
		return operand;
	}
	
	public void setOperand(long operand) {
		this.operand = operand;
	}
}
