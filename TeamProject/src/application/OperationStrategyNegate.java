package application;

public class OperationStrategyNegate implements OperationStrategy
{

	@Override
	public double doOperation(double leftOperand, double rightOperand)
	{
		// TODO Auto-generated method stub
		return -leftOperand;
	}

	@Override
	public char getChar()
	{
		// TODO Auto-generated method stub
		return '±';
	}

}
