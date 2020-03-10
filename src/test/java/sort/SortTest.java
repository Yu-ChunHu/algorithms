package sort;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortTest {
  private static Stream<Sort> provideAlgorithm() {
    return Stream.of(
      new SelectionSort(),
      new InsertionSort()
    );
  }

  @ParameterizedTest
  @MethodSource("provideAlgorithm")
  void sortSameItems(Sort sortAlg) {
    Integer[] unsorted = new Integer[] {1, 1, 1};
    sortAlg.sort(unsorted);
    assertEquals("[1, 1, 1]", Arrays.toString(unsorted));
  }
  
  @ParameterizedTest
  @MethodSource("provideAlgorithm")
  void sortAscArray(Sort sortAlg) {
    Integer[] unsorted = new Integer[] {1, 2, 3};
    sortAlg.sort(unsorted);
    assertEquals("[1, 2, 3]", Arrays.toString(unsorted));
  }

  @ParameterizedTest
  @MethodSource("provideAlgorithm")
  void sortDescArray(Sort sortAlg) {
    Integer[] unsorted = new Integer[] {3, 2, 1};
    sortAlg.sort(unsorted);
    assertEquals("[1, 2, 3]", Arrays.toString(unsorted));
  }

  @ParameterizedTest
  @MethodSource("provideAlgorithm")
  void integration(Sort sortAlg) {
    Integer[] unsorted = new Integer[] {3, 3, 3, 5, 3, 3, 6, 8, 8, 2, 1};
    sortAlg.sort(unsorted);
    assertEquals("[1, 2, 3, 3, 3, 3, 3, 5, 6, 8, 8]", Arrays.toString(unsorted));
  }
}