package data_structure.priority_queue;

import data_structure.Heap;

public class BinaryHeapsPriorityQueue<T> extends Heap<T> implements PriorityQueue<T> {
  
  public BinaryHeapsPriorityQueue(int size) {
    super(size);  
  }

  @Override
  public void insert(Comparable<T> v) {
    numbs[N++] = v;
    swim(N);
  }

  @SuppressWarnings("unchecked")
  @Override
  public T delMax() {
    exchange(1, N);
    sink(1);
    return (T) numbs[--N];
  }

  @Override
  public boolean isEmpty() {
    return N == 0;
  }
}