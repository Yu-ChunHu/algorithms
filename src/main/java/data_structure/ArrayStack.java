package data_structure;

public class ArrayStack<T> implements Stack<T> {
  private T[] items;
  private int firstIdx;

  @SuppressWarnings("unchecked")
  public ArrayStack(int size) {
    this.items = (T[]) new Object[size];
    this.firstIdx = 0;
  }

  @Override
  public void push(T item) {
    items[firstIdx++] = item;
  }

  @Override
  public T pop() {
    if (firstIdx == 0)
      return null;
    T val = items[--firstIdx];
    items[firstIdx] = null;
    return val;
  }
}