package data_structure;

public class LinkedStack<T> {
  LinkedNode<T> first;

  public void push(T item) {
    LinkedNode<T> node = new LinkedNode<>(item);
    if (first == null) {
      first = node;
    } else {
      LinkedNode<T> oldFirst = first;
      first = node;
      first.next = oldFirst;
    }
  }

  public T pop() {
    if (first == null)
      return null;
    T firstVal = first.val;
    first = first.next;
    return firstVal;
  }
}