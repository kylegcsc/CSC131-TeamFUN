package application;

public class OperationStrategyDivide extends OperationStrategy {

	@Override
	public double doOperation(double leftOperand, double rightOperand) {		
		return leftOperand / rightOperand;
	}

	@Override
	public char getChar() {
		return '÷';
	}

}
