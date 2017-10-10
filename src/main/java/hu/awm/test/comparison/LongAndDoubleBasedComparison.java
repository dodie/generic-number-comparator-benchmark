package hu.awm.test.comparison;

public class LongAndDoubleBasedComparison {
	
	public static int compareAsNumbers(Object a, Object b) {
		if (isFloatingPointNumber(a) && isFloatingPointNumber(b)) {
			return Double.compare(((Number)a).doubleValue(), ((Number)b).doubleValue());
		} else {
			return Long.compare(((Number)a).longValue(), ((Number)b).longValue());
		}
	}
	
	private static boolean isFloatingPointNumber(Object o) {
		return o instanceof Double || o instanceof Float;
	}
	
}
