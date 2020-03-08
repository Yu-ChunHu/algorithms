package data_structure;

import java.util.Iterator;

public class IterableLinkedStack<T> extends LinkedStack<T> implements Iterable<T> {
  @Override
  public Iterator<T> iterator() {
    return new LinkedNodeIterator<>();
  }

  class LinkedNodeIterator<T> implements Iterator<T> {
    
    @Override
    public boolean hasNext() {
      return first != null;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T next() {
      return (T) pop();
    }
  }
  
  public static void main(String[] args) {
    IterableLinkedStack<Integer> s = new IterableLinkedStack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    s.forEach(System.out::println);
  }
}