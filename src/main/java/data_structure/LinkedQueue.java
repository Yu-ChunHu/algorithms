package data_structure;

public class LinkedQueue<T> implements Queue<T> {
  private LinkedNode<T> first;
  private LinkedNode<T> last;

  @Override
  public void enqueue(T item) {
    LinkedNode<T> node = new LinkedNode<>(item);
    if (first == null) {
      first = node;
      last = first;
    } else {
      last.next = node;
      last = last.next;
    }
  }

  @Override
  public T dequeue() {
    if (first == null)
      return null;
    T val = first.val;
    first = first.next;
    return val;
  }
}