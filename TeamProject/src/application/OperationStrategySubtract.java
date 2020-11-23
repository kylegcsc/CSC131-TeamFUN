package application;

public class OperationStrategySubtract implements OperationStrategy {

	@Override
	public double doOperation(double leftOperand, double rightOperand) {		
		return leftOperand - rightOperand;
	}

}
