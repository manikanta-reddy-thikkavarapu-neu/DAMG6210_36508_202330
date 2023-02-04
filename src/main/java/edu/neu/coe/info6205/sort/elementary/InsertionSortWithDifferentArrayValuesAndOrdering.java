package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.HelperFactory;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Config;

import java.util.Random;

public class InsertionSortWithDifferentArrayValuesAndOrdering {

    public static void arraySort(int n, Integer[] a) {
        final Config config = Config.setupConfig("true", "0", "1", "", "");
        Helper<Integer> helper = HelperFactory.create("InsertionSort", n, config);
        SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
        Integer[] ys = sorter.sort(a);
    }

    public static void main(String[] args) {
        int n = 200;
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
        for(int i=0;i<arr.length;i++) {
            Random rand = new Random();
            arr[i] = rand.nextInt(50);
        }
        arraySort(arr.length, arr);
    }

    public static void orderedArray(Integer[] arr) {
        for(int i=0;i<arr.length;i++) {
            arr[i] = i;
        }
        arraySort(arr.length, arr);
    }

    public static void reverseOrderedArray(Integer[] arr) {
        for(int i=arr.length-1;i>=0;i--) {
            arr[arr.length -1 - i] = i;
        }
        arraySort(arr.length, arr);
    }

    public static void partiallyOrderedArray(Integer[] arr) {

        // Ordered
        for(int i=0;i<arr.length/2;i++) {
            arr[i] = i;
        }

        //Random
        for(int i=arr.length/2;i<arr.length;i++) {
            Random rand = new Random();
            arr[i] = rand.nextInt(50);
        }

        arraySort(arr.length, arr);
    }
}
