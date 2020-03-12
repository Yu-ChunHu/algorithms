package sort;

public class InsertionSort implements Sort {
  
  @Override
  public <T> void sortAlg(Comparable<T>[] unsorted) {
    sortAlg(unsorted, 0, unsorted.length);
  }
  
  @SuppressWarnings("unchecked")
  public <T> void sortAlg(Comparable<T>[] unsorted, int startIdx, int endIdx) {
    for (int i = startIdx + 1; i < endIdx; i++) {
      int targetIdx = i;
      for (int j = i - 1; j >= 0; j--) {
        if (Sort.isGreater(unsorted[j], (T) unsorted[targetIdx])) {
          Sort.swap(unsorted, targetIdx, j);
          targetIdx = j;
        } else {
          break;
        }
      }
    }
  }
}