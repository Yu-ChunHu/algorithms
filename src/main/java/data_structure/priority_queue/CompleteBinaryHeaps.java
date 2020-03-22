package data_structure.priority_queue;

import sort.Sort;

public class CompleteBinaryHeaps<T> implements PriorityQueue<T> {
  private Comparable<T>[] numbs;
  private int N;

  @SuppressWarnings("unchecked")
  public CompleteBinaryHeaps(int size) {
    numbs = new Comparable[size];
    N = 0;
  }

  @Override
  public void insert(Comparable<T> v) {
    numbs[N++] = v;
    swim(N);
  }

  @SuppressWarnings("unchecked")
  @Override
  public T delMax() {
    Sort.swap(numbs, 0, --N);
    sink(1);
    return (T) numbs[N];
  }

  @Override
  public boolean isEmpty() {
    return N == 0;
  }

  @SuppressWarnings("unchecked")
  private void swim(int k) {
    while (k > 1) {
      int cur = k - 1;
      int parent = k / 2 - 1;
      if (Sort.isGreater(numbs[cur], (T) numbs[parent]))
        Sort.swap(numbs, cur, parent);
      else
        break;
      k /= 2;
    }
  }

  @SuppressWarnings("unchecked")
  private void sink(int k) {
    while (k < N) {
      int cur = k - 1;
      int leftChild = k * 2 - 1;
      int rightChild = k * 2;
      int biggerChild;
      if (leftChild >= N)
        break;
      else if (rightChild >= N)
        biggerChild = leftChild;
      else
        biggerChild = (Sort.isGreater(numbs[leftChild], (T) numbs[rightChild])) ? leftChild : rightChild;
      
      if (Sort.isGreater(numbs[biggerChild], (T) numbs[cur]))
        Sort.swap(numbs, biggerChild, cur);
      else
        break;
      k *= 2;
    }
  }
}