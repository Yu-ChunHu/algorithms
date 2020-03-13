package sort;

public class QuickSort implements Sort {
  
  @Override
  public <T> void sortAlg(Comparable<T>[] unsorted) {
    sort(unsorted, 0, unsorted.length - 1);
  }

  private <T> void sort(Comparable<T>[] unsorted, int low, int high) {
    if (high <= low)
        return;

    int p = partition(unsorted, low, high);
    sort(unsorted, low, p - 1);
    sort(unsorted, p + 1, high);
  }
  
  @SuppressWarnings("unchecked")
  private <T> int partition(Comparable<T>[] unsorted, int low, int high) {
    int i = low;
    int j = high + 1;

    while (true) {
      while (Sort.isGreater(unsorted[low], (T) unsorted[++i]))
        if (i == high)
          break;

      while (Sort.isGreater(unsorted[--j], (T) unsorted[low]))
        if (j == low)
          break;
      
      if (j <= i)
        break;
      
      Sort.swap(unsorted, i, j);
    }

    Sort.swap(unsorted, low, j);
    return j;
  }
}