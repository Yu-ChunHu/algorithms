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

    int divisor = 4;
    if (firstIdx < items.length / divisor)
      items = shrinkItemsSize(items, divisor);
    return val;
  }
}