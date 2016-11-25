package ru.mail.polis.bench;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.QuickSort;
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class QuickSortBench {
    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
       //a = Helper.gen(100000); //n-случайная перестановка
      //  a=Helper.sortArray(100000); //отсортированный массив для лучшего случая
        a=Helper.partitionArray(100000); // массив у которого при разбиениии массива остается один и все для худшего случая
    }

    @Benchmark
    public void measureQuickSort(Blackhole bh) {
        bh.consume(QuickSort.sort(a));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QuickSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
