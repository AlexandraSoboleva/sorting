package ru.mail.polis.bench;

import java.util.Random;
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
import ru.mail.polis.sort.KthElement;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)

public class KthElementBench {
    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {

        // a = Helper.gen(1000); //n-случайная перестановка
        //a=Helper.sortArray(100000); //отсортированный массив для лучшего случая
        a=Helper.partitionArray(1000); // массив у которого при разбиениии массива остается один и все для худшего случая

    }

    @Benchmark
    public void measureKthElement(Blackhole bh) {
        Random rand=new Random();
        int k=rand.nextInt(1000);
        bh.consume(KthElement.sort(a,k));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(KthElementBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
