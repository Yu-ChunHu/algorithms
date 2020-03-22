package data_structure;

import sort.Sort;

public abstract class Heap<T> {
  protected Comparable<T>[] numbs;
  protected int N;
  
  protected Heap(int size) {
    init(size);
  }

  @SuppressWarnings("unchecked")
  protected void init(int size) {
    numbs = new Comparable[size];
    N = 0;
  }

  protected void swim(int k) {
    while (k > 1) {
      int cur = k;
      int parent = k / 2;
      if (isGreater(cur, parent))
        exchange(cur, parent);
      else
        break;
      k /= 2;
    }
  }

  protected void sink(int k) {
    while (k < N) {
      int cur = k;
      int leftChild = k * 2;
      int rightChild = k * 2 + 1;
      int biggerChild;
      if (leftChild > N)
        break;
      else if (rightChild > N)
        biggerChild = leftChild;
      else
        biggerChild = (isGreater(leftChild, rightChild)) ? leftChild : rightChild;
      
      if (isGreater(biggerChild, cur))
        exchange(biggerChild, cur);
      else
        break;
      k *= 2;
    }
  }

  @SuppressWarnings("unchecked")
  protected boolean isGreater(int i, int j) {
    return Sort.isGreater(numbs[i - 1], (T) numbs[j - 1]);
  }

  protected void exchange(int i, int j) {
    Sort.swap(numbs, i - 1, j - 1);
  }
}