package data_structure;

public class LinkedNode<T> {
  public LinkedNode<T> next;
  public T val;

  public LinkedNode(T val) {
    this.val = val;
  }
}