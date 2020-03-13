package sort;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SortTest {
  private static Stream<Sort> provideAlgorithm() {
    return Stream.of(
      new SelectionSort(),
      new InsertionSort(),
      new ShellSort(),
      new MergeSort(),
      new QuickSort()
    );
  }

  @ParameterizedTest
  @MethodSource("provideAlgorithm")
  void sortEmptyArray(Sort sortAlg) {
    Integer[] n = null;
    sortAlg.sort(n);
    assertNull(n);
    assertSort(sortAlg, new Integer[] {}, "[]");
  }

  @ParameterizedTest
  @MethodSource("provideAlgorithm")
  void sortSameItems(Sort sortAlg) {
    assertSort(sortAlg, new Integer[] {1, 1, 1}, "[1, 1, 1]");
  }
  
  @ParameterizedTest
  @MethodSource("provideAlgorithm")
  void sortAscArray(Sort sortAlg) {
    assertSort(sortAlg, new Integer[] {1, 2, 3}, "[1, 2, 3]");
  }

  @ParameterizedTest
  @MethodSource("provideAlgorithm")
  void sortDescArray(Sort sortAlg) {
    assertSort(sortAlg, new Integer[] {3, 2, 1}, "[1, 2, 3]");
  }

  @ParameterizedTest
  @MethodSource("provideAlgorithm")
  void integration(Sort sortAlg) {
    assertSort(sortAlg,
              new Integer[] {3, 3, 3, 5, 3, 3, 6, 8, 8, 2, 1}, 
              "[1, 2, 3, 3, 3, 3, 3, 5, 6, 8, 8]");
  }

  private void assertSort(Sort sortAlg, Integer[] unsorted, String expected) {
    sortAlg.sort(unsorted);
    assertEquals(expected, Arrays.toString(unsorted));
  }
}