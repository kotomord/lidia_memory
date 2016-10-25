package org.lidochka.graphgenerator;


import java.util.List;

/**
 * Created by kotomord on 10/24/2016.
 */
public class ParentPermutation {
    private int[] permutationArray;
    private int affected;
    private int firstFixed;
    private int lastFixed;

    private void initParameters() {
        affected = 0;
        firstFixed = permutationArray.length;
        lastFixed = permutationArray.length;
        for (int i = 0; i < permutationArray.length; ++i) {
            if (permutationArray[i] != i) ++affected;
            else {
                lastFixed = i;
                if (firstFixed > i) firstFixed = i;
            }
        }
    }

    public int size() {
        return permutationArray.length;
    }

    public int apply(int k) {
        return permutationArray[k];
    }

    public ParentPermutation(List<Integer> permutation) {
        permutationArray = new int[permutation.size()];
        for (int i = 0; i < permutationArray.length; ++i) permutationArray[i] = permutation.get(i);
        initParameters();
    }

    public ParentPermutation(List<Integer> partition, int size) {
        permutationArray = new int[size];
        for (int i = 0; i < size; ++i)
            permutationArray[i] = i;
        int start = 0;
        for (int i : partition) {
            move(start, i);
            start += i;
        }
        initParameters();
    }

    private void move(int start, int count) {
        for (int i = 1; i < count; ++i)
            permutationArray[start + i] = start + i - 1;
        permutationArray[start] = start + count - 1;
    }

    public boolean isPossibleFirstInPair(ParentPermutation first) {
        return affected <= first.affected && first.firstFixed > lastFixed;
    }

}
