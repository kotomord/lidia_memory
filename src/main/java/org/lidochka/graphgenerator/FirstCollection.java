package org.lidochka.graphgenerator;

import org.paukov.combinatorics3.Generator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by kotomord on 10/24/2016.
 */
public class FirstCollection {
    final List<ParentPermutation> firstParents;

    public FirstCollection(final int size) {
        firstParents =
                IntStream.range(size / 2 + 1, size)
                        .mapToObj(i -> i)
                        .flatMap(i -> Generator.partition(i).stream())
                        .filter(partition -> CycleFilter.filterPartition(partition))
                        .map(partition -> new ParentPermutation(partition, size))
                        .collect(Collectors.toList());
    }

    public int size() {
        return firstParents.size();
    }

    public Stream<GraphMatrix> getMinimalMatrixes(final ParentPermutation second) {
        return firstParents.stream()
                .filter(first -> second.isPossibleFirstInPair(first))
                .map(first -> new GraphMatrix(first, second));
    }

}
