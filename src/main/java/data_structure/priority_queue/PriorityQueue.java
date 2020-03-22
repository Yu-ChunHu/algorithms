package data_structure.priority_queue;

public interface PriorityQueue<T> {
  void insert(Comparable<T> v);
  T delMax();
  boolean isEmpty();
}