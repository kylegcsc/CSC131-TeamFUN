package application;

public class Calculator {

	OperationStrategy operation;
	private long value = 0;
	private long operand = 0;
	
	public Calculator() {		
		operation = new OperationStrategyAdd();
	}
	
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
