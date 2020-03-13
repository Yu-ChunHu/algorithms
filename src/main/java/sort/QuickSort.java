package sort;

public class QuickSort implements Sort {
  
  @Override
  public <T> void sortAlg(Comparable<T>[] unsorted) {
    sort(unsorted, 0, unsorted.length - 1);
  }

  private <T> void sort(Comparable<T>[] unsorted, int low, int high) {
    if (high <= low)
        return;

    int[] lteq = partition(unsorted, low, high);
    sort(unsorted, low, lteq[0] - 1);
    sort(unsorted, lteq[1], high);
  }
  
  @SuppressWarnings("unchecked")
  private <T> int[] partition(Comparable<T>[] unsorted, int low, int high) {
    // lt eq gt
    int lt = low;
    int gt = high;
    int eq = lt + 1;
    Comparable<T> pivot = unsorted[low];

    while (eq <= gt) {
      int compare = unsorted[eq].compareTo((T) pivot);

      if (compare < 0)
        Sort.swap(unsorted, lt++, eq++);
      else if (compare > 0)
        Sort.swap(unsorted, eq, gt--);
      else
        eq++;
    }
    return new int[] {lt, eq};
  }
}