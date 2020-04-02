package data_structure.symbol_table;
// Avg: o(logn)
// Worst: o(n)

public class BinarySearchTree<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value>  {
  private Node<Key, Value> root;
  private int size = 0;

  public void put(Key key, Value value) {
    root = insert(root, key, value);
  }

  private Node<Key, Value> insert(Node<Key, Value> node, Key key, Value value) {
    if (node == null) {
      size++;
      return new Node<>(key, value);
    }
    Key cur = node.key;
    int compare = key.compareTo(cur);
    if (compare < 0) // find left
      node.left = insert(node.left, key, value);
    else if (compare > 0) // find right
      node.right = insert(node.right, key, value);
    else // find
      node.value = value;
    return node;
  }
  
  public Value get(Key key) {
    return findByKey(root, key);
  }

  private Value findByKey(Node<Key, Value> node, Key key) {
    if (node == null)
      return null;
    Key cur = node.key;
    int compare = key.compareTo(cur);
    if (compare < 0) // find left
      return findByKey(node.left, key);
    else if (compare > 0) // find right
      return findByKey(node.right, key);
    else // find
      return node.value;
  }
  
  public void delete(Key key) {
    deleteByKey(root, key); 
  }

  private Node<Key, Value> deleteByKey(Node<Key, Value> node, Key key) {
    if (node == null)
      return null;
    Key cur = node.key;
    int compare = key.compareTo(cur);
    if (compare < 0) // find left
      node.left = deleteByKey(node.left, key);
    else if (compare > 0) // find right
      node.right = deleteByKey(node.right, key);
    else { // find
      size--;
      if (node.right == null)
        return node.left;
      Node<Key, Value> min = findMin(node.right);
      deleteMin(node.right);
      min.right = node.right;
      min.left = node.left;
      return min;
    }
    return node;
  }

  private Node<Key, Value> findMin(Node<Key, Value> node) {
    if (node.left == null)
      return node;
    return findMin(node.left);
  }

  private Node<Key, Value> deleteMin(Node<Key, Value> node) {
    if (node.left == null)
      return node.right;
    node.left = deleteMin(node.left);
    return node;
  }

  public int size() {
    return size;
  }

  private class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> left;
    private Node<K, V> right;

    private Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
}