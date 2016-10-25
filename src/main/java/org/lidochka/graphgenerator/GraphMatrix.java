package org.lidochka.graphgenerator;

import org.lidochka.branchandbound.BABGate;

import java.util.Random;

/**
 * Created by kotomord on 10/24/2016.
 */
public class GraphMatrix {
    private static int[][] hashMultipliers;

    static {
        hashMultipliers = new int[11][11];
        Random rnd = new Random(1442);
        for (int i = 0; i < 11; ++i)
            for (int j = 0; j < 11; ++j)
                hashMultipliers[i][j] = rnd.nextInt(666);

    }

    private int[][] matrix;
    private int hash;


    public boolean weakMovableFilter() {
        return !BABGate.hasOneAuthomorphism(matrix);
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GraphMatrix)) return false;
        GraphMatrix m = (GraphMatrix) o;
        if (m.hash != hash) return false;
        if (m.matrix.length != matrix.length) return false;
        for (int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix.length; ++j)
                if (matrix[i][j] != m.matrix[i][j])
                    return false;
        return true;
    }

    public GraphMatrix(ParentPermutation first, ParentPermutation second) {
        int n = first.size();
        if (n != second.size())
            throw new IllegalArgumentException("inconsistent permutations");
        matrix = new int[n][n];
        int next = 0;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0)
                    recInit(i, j, ++next, first, second);
                hash += matrix[i][j] * hashMultipliers[i][j];
            }

    }

    private void recInit(final int x, final int y, final int value, final ParentPermutation first, final ParentPermutation second) {
        if (matrix[x][y] > 0) return;
        matrix[x][y] = value;
        recInit(y, x, value, first, second);
        recInit(first.apply(x), first.apply(y), value, first, second);
        recInit(second.apply(x), second.apply(y), value, first, second);
    }

    public void put() {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                if (matrix[i][j] < 10) System.out.print(" ");
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }


    }
}
