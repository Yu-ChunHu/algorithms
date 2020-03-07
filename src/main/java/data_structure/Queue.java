package data_structure;

public interface Queue<T> {
  void enqueue(T item);
  T dequeue();
}