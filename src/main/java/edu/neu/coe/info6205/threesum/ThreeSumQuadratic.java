package edu.neu.coe.info6205.threesum;

import edu.neu.coe.info6205.util.Stopwatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

/**
 * Implementation of ThreeSum which follows the approach of dividing the solution-space into
 * N sub-spaces where each sub-space corresponds to a fixed value for the middle index of the three values.
 * Each sub-space is then solved by expanding the scope of the other two indices outwards from the starting point.
 * Since each sub-space can be solved in O(N) time, the overall complexity is O(N^2).
 * <p>
 * NOTE: The array provided in the constructor MUST be ordered.
 */
public class ThreeSumQuadratic implements ThreeSum {
    /**
     * Construct a ThreeSumQuadratic on a.
     * @param a a sorted array.
     */
    public ThreeSumQuadratic(int[] a) {
        this.a = a;
        length = a.length;
    }

    public Triple[] getTriples() {
        List<Triple> triples = new ArrayList<>();
        for (int i = 0; i < length; i++) triples.addAll(getTriples(i));
        Collections.sort(triples);
        return triples.stream().distinct().toArray(Triple[]::new);
    }

    /**
     * Get a list of Triples such that the middle index is the given value j.
     *
     * @param j the index of the middle value.
     * @return a Triple such that
     */
    public List<Triple> getTriples(int mid) {
        List<Triple> triples = new ArrayList<>();
        // FIXME : for each candidate, test if a[i] + a[j] + a[k] = 0.
        // END
        int low = mid-1, high = mid+1;
        while(low >= 0 && high < length) {
            int sum = a[low] + a[mid] + a[high];
            if (sum == 0) {
                triples.add(new Triple(a[low], a[mid], a[high]));
                low--; high++;
            }
            else if (sum < 0) {
                high++;
            }
            else if(sum > 0) {
                low--;
            }
        }
        return triples;
    }

    private final int[] a;
    private final int length;

    public static void main(String[] args) {
        int n = 1450;
        int[] array = new int[n];
        for (int j = 0; j < n; j++) {
            int rnd = -50;
            array[j] = rnd;
            rnd += 6;
        }
        ThreeSumQuadratic threeSumQuadratic = new ThreeSumQuadratic(array);
        Stopwatch stopwatch = new Stopwatch();
        threeSumQuadratic.getTriples();
        System.out.println(stopwatch.lap());
    }

}
