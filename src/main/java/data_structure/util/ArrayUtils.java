package data_structure.util;

public class ArrayUtils {
  @SuppressWarnings("unchecked")
  public static <T> T[] makeItems(int size) {
    return (T[]) new Object[size];
  }

  public static <T> T[] increaseItemSizeIfOverflow(T[] items, int times) {
    int size = items.length * times;
    T[] newItems = makeItems(size);
    return copyItems(items, newItems);
  }

  private static <T> T[] copyItems(T[] items, T[] newItems) {
    return copyItems(items, newItems, 0);
  }

  public static <T> T[] copyItems(T[] items, T[] newItems, int startIdx) {
    int size = Math.min(items.length, newItems.length);
    for (int i = startIdx; i < size; i++)
      newItems[i] = items[i];
    return newItems;
  }

  public static <T> T[] shrinkItemsSize(T[] items, int divisor) {
    int size = items.length / divisor;
    T[] newItems = makeItems(size);
    return copyItems(items, newItems);
  }
}