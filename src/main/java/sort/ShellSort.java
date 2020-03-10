package sort;

public class ShellSort implements Sort {

  @SuppressWarnings("unchecked")
  @Override
  public <T> void sortAlg(Comparable<T>[] unsorted) {
    int size = unsorted.length;
    int h = 1;
    while (3 * h < size)
      h = 3 * h + 1;
    while (h >= 1) {
      for (int i = h; i < size; i++) {
        for (int j = i; j >= h; j -= h) {
          if (Sort.isGreater(unsorted[j-h], (T) unsorted[j]))
            Sort.swap(unsorted, j, j - h);
          else
            break;
        }
      }
      h /= 3;
    }
    
  }
}