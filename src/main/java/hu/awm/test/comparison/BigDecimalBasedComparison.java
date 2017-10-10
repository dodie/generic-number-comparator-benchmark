package hu.awm.test.comparison;

import java.math.BigDecimal;

public class BigDecimalBasedComparison {
	
	public static int compareAsNumbers(Object a, Object b) {
		if (isNaN(a) && isNaN(b)) {
			return 0;
		}
		if (isNaN(a)) {
			return 1;
		}
		if (isNaN(b)) {
			return -1;
		}

		if (isPositiveInfinity(a) && isPositiveInfinity(b)) {
			return 0;
		}
		if (isPositiveInfinity(a)) {
			return 1;
		}
		if (isPositiveInfinity(b)) {
			return -1;
		}

		if (isNegativeInfinity(a) && isNegativeInfinity(b)) {
			return 0;
		}
		if (isNegativeInfinity(a)) {
			return -1;
		}
		if (isNegativeInfinity(b)) {
			return 1;
		}

		return (new BigDecimal((a.toString())).compareTo(new BigDecimal(b.toString())));
	}

	private static boolean isPositiveInfinity(Object number) {
		return (number instanceof Double && Double.isInfinite((Double) number) && 0 < (Double) number)
				|| (number instanceof Float && Float.isInfinite((Float) number) && 0 < (Float) number);
	}

	private static boolean isNaN(Object number) {
		return (number instanceof Double && Double.isNaN((Double) number))
				|| (number instanceof Float && Float.isNaN((Float) number));
	}

	private static boolean isNegativeInfinity(Object number) {
		return (number instanceof Double && Double.isInfinite((Double) number) && (Double) number < 0)
				|| (number instanceof Float && Float.isInfinite((Float) number) && (Float) number < 0);
	}
	
}
