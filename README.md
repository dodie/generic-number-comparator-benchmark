# Generic Number Comparator Benchmark

Testing the performance of ```Collections.max(list)``` with various comparators.

## Run

```
mvn clean install;java -jar target/benchmarks.jar
```

## Results


| Benchmark                          | Score (ops/s) - Integers only    | Score (ops/s) - Integers and Doubles |
| ---------------------------------- | -------------------------------- | ------------------------------------ |
| Original comparator                | 3172804.081                      | X                                    |
| Long.compare                       | 3480229.820                      | X                                    |
| Double.compare                     | 2756652.584                      | 2340389.827                          |
| Double.compare / Long.compare      | 2881121.264                      | 1899611.262                          |
| BigDecimal.compare + Inf/NaN check |  104337.061                      |   74441.372                          |


Original results:
```
Benchmark                                                                          Mode  Cnt        Score       Error  Units
GenericNumberComparatorBenchmark.bigdecimal_based_comparison                      thrpt   10    74441.372 ±   398.476  ops/s
GenericNumberComparatorBenchmark.bigdecimal_based_comparison_integers             thrpt   10   104337.061 ±   592.500  ops/s
GenericNumberComparatorBenchmark.double_value_based_comparison                    thrpt   10  2340389.827 ±  8402.134  ops/s
GenericNumberComparatorBenchmark.double_value_based_comparison_integers           thrpt   10  2756652.584 ± 24658.785  ops/s
GenericNumberComparatorBenchmark.long_and_double_value_based_comparison           thrpt   10  1899611.262 ± 12042.066  ops/s
GenericNumberComparatorBenchmark.long_and_double_value_based_comparison_integers  thrpt   10  2881121.264 ± 41496.741  ops/s
GenericNumberComparatorBenchmark.long_value_based_comparison_integers             thrpt   10  3480229.820 ± 26832.117  ops/s
GenericNumberComparatorBenchmark.original_comparison_integers                     thrpt   10  3172804.081 ± 18868.971  ops/s
```
