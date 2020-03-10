package sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortTest {
  private Sort sortAlg;

  @BeforeEach
  void setUpAlgorithm() {
    sortAlg = new SelectionSort();
  }

  @Test
  void sortSameItems() {
    Integer[] unsorted = new Integer[] {1, 1, 1};
    sortAlg.sort(unsorted);
    assertEquals("[1, 1, 1]", Arrays.toString(unsorted));
  }
  
  @Test
  void sortAscArray() {
    Integer[] unsorted = new Integer[] {1, 2, 3};
    sortAlg.sort(unsorted);
    assertEquals("[1, 2, 3]", Arrays.toString(unsorted));
  }

  @Test
  void sortDescArray() {
    Integer[] unsorted = new Integer[] {3, 2, 1};
    sortAlg.sort(unsorted);
    assertEquals("[1, 2, 3]", Arrays.toString(unsorted));
  }
}