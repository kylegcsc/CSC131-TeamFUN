package application;

import java.util.ArrayList;
import java.util.Iterator;

public class Operations {
	
	private static ArrayList<OperationStrategy> operations = new ArrayList<OperationStrategy>() {
		{
			add(new OperationStrategyAdd());
			add(new OperationStrategySubtract());
			add(new OperationStrategyMultiply());
			add(new OperationStrategyDivide());
			add(new OperationStrategyNegate());
		}
	};
		
	public static Iterator<OperationStrategy> iterator() {		
		return operations.iterator();
	}
	
}

