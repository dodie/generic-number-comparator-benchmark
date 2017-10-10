package hu.awm.test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import hu.awm.test.comparison.BigDecimalBasedComparison;
import hu.awm.test.comparison.DoubleValueBasedComparison;
import hu.awm.test.comparison.LongAndDoubleBasedComparison;
import hu.awm.test.comparison.LongValueBasedComparison;

@SuppressWarnings({"unchecked", "rawtypes"})
public class GenericNumberComparatorBenchmark {
	
	public static final int WARMUP_ITERATIONS = 10;
	public static final int ITERATIONS = 10;

	@State(Scope.Thread)
	public static class BenchmarkState {
		volatile public Comparable valueSink; // just store the result somewhere, to avoid dead code removal optimization
	}

	@Fork(1)
	@Warmup(iterations = WARMUP_ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Measurement(iterations = ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Benchmark
	public void original_comparison_integers(BenchmarkState s) {
		s.valueSink = Collections.max(TestData.integers());
	}
	
	@Fork(1)
	@Warmup(iterations = WARMUP_ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Measurement(iterations = ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Benchmark
	public void bigdecimal_based_comparison_integers(BenchmarkState s) {
		s.valueSink = (Comparable) Collections.max(TestData.integers(), BigDecimalBasedComparison::compareAsNumbers);
	}
	
	@Fork(1)
	@Warmup(iterations = WARMUP_ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Measurement(iterations = ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Benchmark
	public void bigdecimal_based_comparison(BenchmarkState s) {
		s.valueSink = (Comparable) Collections.max(TestData.mixed(), BigDecimalBasedComparison::compareAsNumbers);
	}
	
	@Fork(1)
	@Warmup(iterations = WARMUP_ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Measurement(iterations = ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Benchmark
	public void double_value_based_comparison_integers(BenchmarkState s) {
		s.valueSink = (Comparable) Collections.max(TestData.integers(), DoubleValueBasedComparison::compareAsNumbers);
	}
	
	@Fork(1)
	@Warmup(iterations = WARMUP_ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Measurement(iterations = ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Benchmark
	public void double_value_based_comparison(BenchmarkState s) {
		s.valueSink = (Comparable) Collections.max(TestData.mixed(), DoubleValueBasedComparison::compareAsNumbers);
	}
	
	@Fork(1)
	@Warmup(iterations = WARMUP_ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Measurement(iterations = ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Benchmark
	public void long_value_based_comparison_integers(BenchmarkState s) {
		s.valueSink = (Comparable) Collections.max(TestData.integers(), LongValueBasedComparison::compareAsNumbers);
	}
	
	@Fork(1)
	@Warmup(iterations = WARMUP_ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Measurement(iterations = ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Benchmark
	public void long_and_double_value_based_comparison(BenchmarkState s) {
		s.valueSink = (Comparable) Collections.max(TestData.mixed(), LongAndDoubleBasedComparison::compareAsNumbers);
	}
	
	@Fork(1)
	@Warmup(iterations = WARMUP_ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Measurement(iterations = ITERATIONS, time = 1, timeUnit = TimeUnit.SECONDS)
	@Benchmark
	public void long_and_double_value_based_comparison_integers(BenchmarkState s) {
		s.valueSink = (Comparable) Collections.max(TestData.integers(), LongAndDoubleBasedComparison::compareAsNumbers);
	}
}
