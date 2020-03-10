package sort;

public class SelectionSort implements Sort {
  @SuppressWarnings("unchecked")
  @Override
  public <T> void sort(Comparable<T>[] unsorted) {
    for (int i = 0; i < unsorted.length - 1; i++) {
      int minIdx = i;
      Comparable<T> minVal = unsorted[i];
      for (int j = i + 1; j < unsorted.length; j++) {
        if (Sort.isGreater(minVal, (T) unsorted[j])) {
          minIdx = j;
          minVal = unsorted[j];
        }
      }
      Sort.swap(unsorted, i, minIdx);
    }
  }
}