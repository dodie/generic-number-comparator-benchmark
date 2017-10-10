package hu.awm.test.comparison;

public class LongValueBasedComparison {
	
	public static int compareAsNumbers(Object a, Object b) {
		return Long.compare(((Number)a).longValue(), ((Number)b).longValue());
	}
	
}
