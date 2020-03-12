package sort;

public class MergeSort implements Sort {
  private static final int CUTOFF = 10;

  @Override
  public void sortAlg(Comparable[] unsorted) {
    int size = unsorted.length;
    Comparable[] aux = new Comparable[size];
    sort(unsorted, aux, 0, size - 1);
  }

  @SuppressWarnings("unchecked")
  private void sort(Comparable[] org, Comparable[] aux, int low, int high) {
    if (low >= high)
      return;

    if (high <= low + CUTOFF - 1) {
      new InsertionSort().sortAlg(org, low, high + 1);
      return;
    }

    int mid = low + (high - low) / 2;
    sort(org, aux, low, mid);
    sort(org, aux, mid + 1, high);
    merge(org, aux, low, mid, high);
  }

  @SuppressWarnings("unchecked")
  private void merge(Comparable[] org, Comparable[] aux, int low, int mid, int high) {
    if (isLowerPartAllSmaller(org, mid))
      return;
    
    copyArray(org, aux, low, high);
    
    int i = low;
    int j = mid + 1;
    for(int k = low; k <= high; k++) {
      if (i > mid)
        org[k] = aux[j++];
      else if (j > high)
        org[k] = aux[i++];
      else if (Sort.isGreater(aux[i], aux[j]))
        org[k] = aux[j++];
      else
        org[k] = aux[i++];
    }
  }

  @SuppressWarnings("unchecked")
  private boolean isLowerPartAllSmaller(Comparable[] org, int mid) {
    return !Sort.isGreater(org[mid], org[mid + 1]);
  }

  private void copyArray(Comparable[] org, Comparable[] copy, int low, int high) {
    for(int i = low; i <= high; i++)
      copy[i] = org[i];
  }
}