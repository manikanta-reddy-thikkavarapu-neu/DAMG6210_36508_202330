package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.InstrumentedHelper;
import edu.neu.coe.info6205.sort.elementary.HeapSort;
import edu.neu.coe.info6205.sort.linearithmic.MergeSortBasic;
import edu.neu.coe.info6205.sort.linearithmic.QuickSort;
import edu.neu.coe.info6205.sort.linearithmic.QuickSort_DualPivot;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.util.PrivateMethodTester;
import edu.neu.coe.info6205.util.StatPack;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class NewSortBenchmark {

    public static void main(String[] args) {

        int n = 10000;

        final Config config = Config.setupConfig("true", "0", "1", "1", "");

        // Merge Sort
        BaseHelper<Integer> h1 = new InstrumentedHelper<>("test", config);

        MergeSortBasic<Integer> merge = new MergeSortBasic<>(h1);

        Consumer<Integer[]> rF1 = rA1 -> merge.sort(rA1);
        Benchmark_Timer<Integer[]> rT1 = new Benchmark_Timer<>("Sorts array of " + n + " elements", rF1);
        Supplier<Integer[]> r1 = () -> {
            Random randI = new Random();
            Integer[] rA1 = new Integer[n];
            for(int i=0; i<n; i++) {
                int randInt = randI.nextInt(n);
                rA1[i] = randInt+1;
            }
            return rA1;
        };
        rF1.accept(r1.get());
        double randTime1 = rT1.run(r1.get(), 1);
        System.out.println("Time taken for " + n + " elements of array using Merge Sort is : " + randTime1);

        h1.postProcess(merge.sort(r1.get()));

        PrivateMethodTester privateMethodTester1 = new PrivateMethodTester(h1);
        StatPack statPack1 = (StatPack) privateMethodTester1.invokePrivate("getStatPack");

        int compares_merge = (int) statPack1.getStatistics(InstrumentedHelper.COMPARES).mean();
        int hits_merge = (int) statPack1.getStatistics(InstrumentedHelper.HITS).mean();
        int swaps_merge = (int) statPack1.getStatistics(InstrumentedHelper.SWAPS).mean();

        System.out.println("No of compares taken using Merge Sort : " + compares_merge);
        System.out.println("No of hits taken using Merge Sort : " + hits_merge);
        System.out.println("No of swaps taken using Merge Sort : " + swaps_merge);

        // Quick Sort
        BaseHelper<Integer> h2 = new InstrumentedHelper<>("test", config);

        QuickSort<Integer> quick = new QuickSort_DualPivot<>(h2);

        Consumer<Integer[]> rF2 = rA2 -> quick.sort(rA2);
        Benchmark_Timer<Integer[]> rT2 = new Benchmark_Timer<>("Sorts array of " + n + " elements", rF2);
        Supplier<Integer[]> r2 = () -> {
            Random randI = new Random();
            Integer[] rA2 = new Integer[n];
            for(int i=0; i<n; i++) {
                int randInt = randI.nextInt(n);
                rA2[i] = randInt+1;
            }
            return rA2;
        };
        rF2.accept(r2.get());
        double randTime2 = rT2.run(r2.get(), 1);
        System.out.println("Time taken for " + n + " elements of array using Quick Sort is : " + randTime2);

        h2.postProcess(quick.sort(r2.get()));

        PrivateMethodTester privateMethodTester = new PrivateMethodTester(h2);
        StatPack statPack2 = (StatPack) privateMethodTester.invokePrivate("getStatPack");

        int compares_quick = (int) statPack2.getStatistics(InstrumentedHelper.COMPARES).mean();
        int hits_quick = (int) statPack2.getStatistics(InstrumentedHelper.HITS).mean();
        int swaps_quick = (int) statPack2.getStatistics(InstrumentedHelper.SWAPS).mean();

        System.out.println("No of compares taken using Quick Sort : " + compares_quick);
        System.out.println("No of hits taken using Quick Sort : " + hits_quick);
        System.out.println("No of swaps taken using Quick Sort : " + swaps_quick);

        // Heap Sort
        BaseHelper<Integer> h3 = new InstrumentedHelper<>("test", config);

        HeapSort<Integer> heap = new HeapSort<>(h3);

        Consumer<Integer[]> rF3 = rA3 -> merge.sort(rA3);
        Benchmark_Timer<Integer[]> rT3 = new Benchmark_Timer<>("Sorts array of " + n + " elements", rF3);
        Supplier<Integer[]> r3 = () -> {
            Random randI = new Random();
            Integer[] rA3 = new Integer[n];
            for(int i=0; i<n; i++) {
                int randInt = randI.nextInt(n);
                rA3[i] = randInt+1;
            }
            return rA3;
        };
        rF3.accept(r3.get());
        double randTime3 = rT3.run(r3.get(), 1);
        System.out.println("Time taken for " + n + " elements of array using Heap Sort is : " + randTime3);

        h3.postProcess(heap.sort(r3.get()));

        PrivateMethodTester privateMethodTester2 = new PrivateMethodTester(h3);
        StatPack statPack3 = (StatPack) privateMethodTester2.invokePrivate("getStatPack");

        int compares_heap = (int) statPack3.getStatistics(InstrumentedHelper.COMPARES).mean();
        int hits_heap = (int) statPack3.getStatistics(InstrumentedHelper.HITS).mean();
        int swaps_heap = (int) statPack3.getStatistics(InstrumentedHelper.SWAPS).mean();

        System.out.println("No of compares taken using Heap Sort : " + compares_heap);
        System.out.println("No of hits taken using Heap Sort : " + hits_heap);
        System.out.println("No of swaps taken using Heap Sort : " + swaps_heap);
    }

}