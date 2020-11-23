package application;

public class OperationStrategyAdd implements OperationStrategy {

	@Override
	public long doOperation(long leftOperand, long rightOperand) {
		long result = leftOperand + rightOperand;
		return result;
	}

}
