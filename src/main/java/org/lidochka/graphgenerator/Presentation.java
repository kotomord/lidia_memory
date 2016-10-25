package org.lidochka.graphgenerator;

import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by kotomord on 10/24/2016.
 */
public class Presentation {
    public static void main(String[] args) {
        System.getProperty("java.util.concurrent.ForkJoinPool.common‌​.parallelism", "1");
        ArrayList<Integer> elems = new ArrayList<>();
        for (int j = 0; j < 3; ++j) elems.add(j);
        for (int i = 4; i < 12; ++i) {
            elems.add(i - 1);
            System.out.print("vertices: " + i);
            final FirstCollection firsts = new FirstCollection(i);
            System.out.print(", int firsts: " + firsts.size());
            long time = new Date().getTime();
            final Set<GraphMatrix> set = Generator.permutation(elems)
                    .simple()
                    .stream()
                    .parallel()
                    .filter(permutation -> CycleFilter.filterPermutation(permutation))
                    .map(permutation -> new ParentPermutation(permutation))
                    .flatMap(parentPermutation -> firsts.getMinimalMatrixes(parentPermutation))
                    .collect(Collectors.toSet());
            time = new Date().getTime() - time;
            System.out.print(", distinct matrixes: " + set.size() + ", work time: " + time);

            time = new Date().getTime();
            final List<GraphMatrix> weakMovable = set
                    .parallelStream()
                    .filter(matrix -> matrix.weakMovableFilter())
                    .collect(Collectors.toList());
            time = new Date().getTime() - time;
            System.out.print(", found matrixes: " + weakMovable.size() + ", work time: " + time);
            System.out.println();

            if (!weakMovable.isEmpty())
                weakMovable.get(0).put();
        }
    }
}

/*
Run results
vertices: 4, int firsts: 1, distinct matrixes: 1, work time: 29, found matrixes: 0, work time: 18
vertices: 5, int firsts: 2, distinct matrixes: 6, work time: 4, found matrixes: 0, work time: 0
vertices: 6, int firsts: 3, distinct matrixes: 15, work time: 13, found matrixes: 0, work time: 0
vertices: 7, int firsts: 6, distinct matrixes: 51, work time: 33, found matrixes: 0, work time: 2
vertices: 8, int firsts: 8, distinct matrixes: 206, work time: 165, found matrixes: 0, work time: 5
vertices: 9, int firsts: 12, distinct matrixes: 885, work time: 879, found matrixes: 0, work time: 6
vertices: 10, int firsts: 15, distinct matrixes: 2879, work time: 7719, found matrixes: 12, work time: 12
 1  2  3  4  5  6  7  8  9 10
 2  1  4  3  6  5  8  7  9 10
 3  4  1  2  6  5  7  8 10  9
 4  3  2  1  5  6  8  7 10  9
 5  6  6  5 11 12 13 13 14 14
 6  5  5  6 12 11 13 13 14 14
 7  8  7  8 13 13 15 16 17 17
 8  7  8  7 13 13 16 15 17 17
 9  9 10 10 14 14 17 17 18 19
10 10  9  9 14 14 17 17 19 18
vertices: 11, int firsts: 23, distinct matrixes: 12769, work time: 167891, found matrixes: 160, work time: 91
 1  2  3  4  5  6  3  7  8  9 10
 2  1  4  3  6  5  7  3  9  8 10
 3  4  1  7  5  6  3  2 10  8  9
 4  3  7  1  6  5  2  3  8 10  9
 5  6  5  6 11 12  5  6 13 13 13
 6  5  6  5 12 11  6  5 13 13 13
 3  7  3  2  5  6  1  4  9 10  8
 7  3  2  3  6  5  4  1 10  9  8
 8  9 10  8 13 13  9 10 14 15 15
 9  8  8 10 13 13 10  9 15 14 15
10 10  9  9 13 13  8  8 15 15 14

* */