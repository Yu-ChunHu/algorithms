package sort;

public class InsertionSort implements Sort {
  @SuppressWarnings("unchecked")
  @Override
  public <T> void sortAlg(Comparable<T>[] unsorted) {
    for (int i = 1; i < unsorted.length; i++) {
      int targetIdx = i;
      for (int j = i - 1; j >= 0; j--) {
        if (Sort.isGreater(unsorted[j], (T) unsorted[targetIdx])) {
          Sort.swap(unsorted, targetIdx, j);
          targetIdx = j;
        }
      }
    }
  }
}