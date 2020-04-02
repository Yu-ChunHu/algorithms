package data_structure.symbol_table;

// Red-black tree to implement 2-3 tree
public class RedBlackBSTs<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
  private Node<Key, Value> root;
  private int size;

  @Override
  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Node<Key, Value> put(Node<Key,Value> node, Key key, Value value) {
    if (node == null) {
      size++;
      return new Node<>(key, value);
    }
    Key cur = node.key;
    int compare = key.compareTo(cur);
    if (compare < 0) // find left
      node.left = put(node.left, key, value);
    else if (compare > 0) // find right
      node.right = put(node.right, key, value);
    else
      node.value = value;

    if (!isRed(node.left) && isRed(node.right))
      node = rotateLeft(node);
    if (isRed(node.left) && isRed(node.left.left))
      node = rotateRight(node);
    if (isRed(node.left) && isRed(node.right))
      flipColor(node);
    return node;
  }

  private boolean isRed(Node<Key, Value> node) {
    return (node != null) && node.isRed;
  }

  private Node<Key, Value> rotateLeft(Node<Key, Value> node) {
    Node<Key, Value> r = node.right;
    node.right = r.left;
    r.left = node;
    r.isRed = node.isRed;
    node.isRed = true;
    return r;
  }

  private Node<Key, Value> rotateRight(Node<Key, Value> node) {
    Node<Key, Value> l = node.left;
    node.left = l.right;
    l.right = node;
    l.isRed = node.isRed;
    node.isRed = true;
    return l;
  }

  private void flipColor(Node<Key, Value> node) {
    node.isRed = true;
    node.left.isRed = false;
    node.right.isRed = false;
  }

  @Override
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

  @Override
  public int size() {
    return size;
  }

  private class Node<K, V> {
    private K key;
    private V value;
    private boolean isRed;
    private Node<K, V> left;
    private Node<K, V> right;
    private Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.isRed = true;
    }
  }
}