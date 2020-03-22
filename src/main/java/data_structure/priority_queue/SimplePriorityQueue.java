package data_structure.priority_queue;

import sort.Sort;

public class SimplePriorityQueue<T> implements PriorityQueue<T> {
  private Comparable<T>[] numbs;
  private int length;

  @SuppressWarnings("unchecked")
  public SimplePriorityQueue(int size) {
    numbs = new Comparable[size];
    length = 0;
  }

  @Override
  public void insert(Comparable<T> v) {
    numbs[length++] = v;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T delMax() {
    int maxIdx = 0;
    for (int i = 1; i < length; i++)
      if (Sort.isGreater(numbs[i], (T) numbs[maxIdx]))
        maxIdx = i;
    Sort.swap(numbs, maxIdx, --length);
    return (T) numbs[length];
  }

  @Override
  public boolean isEmpty() {
    return length == 0;
  }
}