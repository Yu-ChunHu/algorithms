package sort;

import data_structure.Heap;

public class HeapSort<B> extends Heap<B> implements Sort {
  protected HeapSort(int size) {
    super(size);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> void sortAlg(Comparable<T>[] unsorted) {
    this.numbs = (Comparable<B>[]) unsorted;
    this.N = unsorted.length;  
    fixViolation();
    sortAsc();
  }

  private void fixViolation() {
    for (int i = N / 2; i > 0; i--)
      sink(i);
  }

  private void sortAsc() {
    while (N > 1) {
      exchange(1, N--);
      sink(1);
    }
  }
}