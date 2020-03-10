package sort;

@FunctionalInterface
public interface Sort {
  <T> void sort(Comparable<T>[] unsorted);

  static <T> void swap(Comparable<T>[] input, int i, int j) {
    if (i == j)
      return;
    Comparable<T> tmp = input[i];
    input[i] = input[j];
    input[j] = tmp;
  }

  static <T> boolean isGreater(Comparable<T> a, T b) {
    return a.compareTo(b) > 0;
  }
}