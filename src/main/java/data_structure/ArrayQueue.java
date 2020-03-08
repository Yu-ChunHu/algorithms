package data_structure;

import static data_structure.util.ArrayUtils.*;

public class ArrayQueue<T> implements Queue<T> {
  private T[] items;
  private int firstIdx;
  private int lastIdx;

  public ArrayQueue() {
    init();
  }

  private void init() {
    items = makeItems(1);
    firstIdx = 0;
    lastIdx = 0;
  }
  
  @Override
  public void enqueue(T item) {
    if (lastIdx == items.length)
      items = increaseItemSizeIfOverflow(items, 2);
    items[lastIdx++] = item;
  }

  @Override
  public T dequeue() {
    if (firstIdx >= lastIdx) {
      init();
      return null;
    }
    
    T val = items[firstIdx];
    items[firstIdx++] = null;

    int trueSize = lastIdx - firstIdx;
    if (items.length / 4 >= trueSize) {
      T[] newItems = makeItems(items.length / 2);
      items = copyItems(items, newItems, firstIdx, lastIdx);
      firstIdx = 0;
      lastIdx = trueSize;
    }
    return val;
  }
}