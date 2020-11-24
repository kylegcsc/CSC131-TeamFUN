package application;

public class OperationStrategyAdd implements OperationStrategy {

	@Override
	public double doOperation(double leftOperand, double rightOperand) {
		return leftOperand + rightOperand;
	}

	@Override
	public char getChar() {
		return '+';
	}

}
