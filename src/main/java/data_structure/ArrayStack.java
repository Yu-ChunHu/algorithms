package data_structure;

public class ArrayStack<T> implements Stack<T> {
  private T[] items;
  private int firstIdx;

  public ArrayStack() {
    this.items = makeItems(1);
    this.firstIdx = 0;
  }

  @SuppressWarnings("unchecked")
  private T[] makeItems(int size) {
    return (T[]) new Object[size];
  }

  @Override
  public void push(T item) {
    increaseItemSizeIfOverflow();
    items[firstIdx++] = item;
  }

  private void increaseItemSizeIfOverflow() {
    if (firstIdx == items.length) {
      int size = items.length * 2;
      T[] newItems = makeItems(size);
      copyItems(newItems);
    }
  }

  private void copyItems(T[] newItems) {
    int size = Math.min(items.length, newItems.length);
    for (int i = 0; i < size; i++)
      newItems[i] = items[i];
    items = newItems;
  }

  @Override
  public T pop() {
    if (firstIdx == 0)
      return null;
    T val = items[--firstIdx];
    items[firstIdx] = null;
    shrinkItemsSize();
    return val;
  }

  private void shrinkItemsSize() {
    int size = items.length / 4;
    if (firstIdx < size) {
      T[] newItems = makeItems(size);
      copyItems(newItems);
    }
  }
}