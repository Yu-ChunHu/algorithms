package data_structure;

import static data_structure.util.ArrayUtils.*;

public class ArrayStack<T> implements Stack<T> {
  private T[] items;
  private int firstIdx;

  public ArrayStack() {
    this.items = makeItems(1);
    this.firstIdx = 0;
  }

  @Override
  public void push(T item) {
    if (firstIdx == items.length)
      items = increaseItemSizeIfOverflow(items, 2);
    items[firstIdx++] = item;
  }

  @Override
  public T pop() {
    if (firstIdx == 0)
      return null;
    T val = items[--firstIdx];
    items[firstIdx] = null;

    if (firstIdx < items.length / 4)
      items = shrinkItemsSize(items, 2);
    return val;
  }
}