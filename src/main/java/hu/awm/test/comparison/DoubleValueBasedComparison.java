package hu.awm.test.comparison;

public class DoubleValueBasedComparison {
	
	public static int compareAsNumbers(Object a, Object b) {
		return Double.compare(((Number)a).doubleValue(), ((Number)b).doubleValue());
	}
	
}
