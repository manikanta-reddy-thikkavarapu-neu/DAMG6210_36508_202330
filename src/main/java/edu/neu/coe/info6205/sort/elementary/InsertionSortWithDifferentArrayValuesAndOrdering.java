package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.HelperFactory;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class InsertionSortWithDifferentArrayValuesAndOrdering {

    public static void arraySort(int n, Integer[] a) {
        final Config config = Config.setupConfig("true", "0", "1", "", "");
        Helper<Integer> helper = HelperFactory.create("InsertionSort", n, config);
        SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
        Integer[] ys = sorter.sort(a);
    }

    public static void main(String[] args) {
        int n = 3200;
        Integer[] arr = new Integer[n];

        // Random array
        randomArray(arr);

        // Ordered array
        orderedArray(arr);

        // Reverse ordered array
        reverseOrderedArray(arr);

        // Partially ordered array
        partiallyOrderedArray(arr);

    }

    public static void randomArray(Integer[] arr) {
        Consumer<Integer[]> randomFunc = randomOrderedArr -> arraySort(arr.length, randomOrderedArr);
        Benchmark_Timer<Integer[]> randomOrderTimer = new Benchmark_Timer<>("Sort random ordered array of " + arr.length + " elements", randomFunc);
        Supplier<Integer[]> random = () -> {
            Integer[] randomArr = new Integer[arr.length];
            for(int i=0;i<arr.length;i++) {
                Random rand = new Random();
                randomArr[i] = rand.nextInt(arr.length);
            }
            return randomArr;
        };
        randomFunc.accept(random.get());
        double randomTime = randomOrderTimer.run(random.get(), 100);
        System.out.println("Time to run random array of " + arr.length + " elements is " + randomTime);
    }

    public static void orderedArray(Integer[] arr) {
        Consumer<Integer[]> orderedFunc = orderedArr -> arraySort(arr.length, orderedArr);
        Benchmark_Timer<Integer[]> orderedTimer = new Benchmark_Timer<>("Sort ordered array of " + arr.length + " elements", orderedFunc);
        Supplier<Integer[]> ordered = () -> {
            Integer[] orderedArr = new Integer[arr.length];
            for(int i=0;i<arr.length;i++) {
                orderedArr[i] = i;
            }
            return orderedArr;
        };
        orderedFunc.accept(ordered.get());
        double orderedTime = orderedTimer.run(ordered.get(), 100);
        System.out.println("Time to run ordered array of " + arr.length + " elements is " + orderedTime);
    }

    public static void reverseOrderedArray(Integer[] arr) {
        Consumer<Integer[]> reverseFunc = reverseArr -> arraySort(arr.length, reverseArr);
        Benchmark_Timer<Integer[]> reverseTimer = new Benchmark_Timer<>("Sort reverse array of " + arr.length + " elements", reverseFunc);
        Supplier<Integer[]> reverse = () -> {
            Integer[] reverseArr = new Integer[arr.length];
            for(int i=arr.length-1;i>=0;i--) {
                reverseArr[arr.length -1 - i] = i;
            }
            return reverseArr;
        };
        reverseFunc.accept(reverse.get());
        double reverseTime = reverseTimer.run(reverse.get(), 100);
        System.out.println("Time to run reverse array of " + arr.length + " elements is " + reverseTime);
    }

    public static void partiallyOrderedArray(Integer[] arr) {
        Consumer<Integer[]> partialOrderedFunc = partialOrderedArr -> arraySort(arr.length, partialOrderedArr);
        Benchmark_Timer<Integer[]> partialOrderedTimer = new Benchmark_Timer<>("Sort partial ordered array of " + arr.length + " elements", partialOrderedFunc);
        Supplier<Integer[]> partialOrdered = () -> {
            Integer[] partialOrderedArr = new Integer[arr.length];
            // Ordered
            for(int i=0;i<arr.length/2;i++) {
                partialOrderedArr[i] = i;
            }

            //Random
            for(int i=arr.length/2;i<arr.length;i++) {
                Random rand = new Random();
                partialOrderedArr[i] = rand.nextInt(arr.length/2) + arr.length/2;
            }
            return partialOrderedArr;
        };
        partialOrderedFunc.accept(partialOrdered.get());
        double partialOrderedTime = partialOrderedTimer.run(partialOrdered.get(), 100);
        System.out.println("Time to run partial ordered array of " + arr.length + " elements is " + partialOrderedTime);
    }
}
