package org.lidochka.graphgenerator;

import java.util.List;

/**
 * Created by kotomord on 10/21/2016.
 */
public class CycleFilter {
    private static final int[] primes = {2, 3, 5, 7};
    private boolean[] existsAsDiv = new boolean[primes.length];
    private boolean[] existsAsIs = new boolean[primes.length];

    private CycleFilter() {

    }

    private void addNumber(int n) {
        if (n == 1) return;
        for (int i = 0; i < primes.length; ++i)
            if (n % primes[i] == 0) {
                existsAsDiv[i] = true;
                if (n == primes[i]) existsAsIs[i] = true;
            }
    }

    private boolean accept() {
        for (int i = 0; i < primes.length; ++i)
            if (existsAsDiv[i] != existsAsIs[i])
                return false;
        return true;
    }

    public static boolean filterPartition(final List<Integer> partition) {
        if (partition.get(partition.size() - 1).equals(1)) return false;
        CycleFilter filter = new CycleFilter();
        partition.stream().forEach(i -> filter.addNumber(i));
        return filter.accept();
    }

    public static boolean filterPermutation(final List<Integer> permutation) {
        int n = permutation.size();
        boolean[] exists = new boolean[n];
        CycleFilter filter = new CycleFilter();
        for (int i = 0; i < n; ++i)
            if (!exists[i]) {
                int start = i;
                int len = 0;
                while (!exists[start]) {
                    exists[start] = true;
                    ++len;
                    start = permutation.get(start);
                }
                filter.addNumber(len);
            }
        return filter.accept();
    }
}
