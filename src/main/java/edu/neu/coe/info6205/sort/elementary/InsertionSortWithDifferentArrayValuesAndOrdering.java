package edu.neu.coe.info6205.sort.elementary;

import java.util.Random;

public class InsertionSortWithDifferentArrayValuesAndOrdering {
    public static void main(String[] args) {
        int n = 200;
        Integer[] arr = new Integer[n];

        // Random array values
        randomArray(arr);

        // 

    }

    public static void randomArray(Integer[] arr) {
        for(int i=0;i<arr.length;i++) {
            Random rand = new Random();
            arr[i] = rand.nextInt(50);
        }
    }
}
