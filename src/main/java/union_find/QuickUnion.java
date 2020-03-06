package union_find;

public class QuickUnion extends UnionFind {
  public QuickUnion(int size) {
    super(size);
  }

  @Override
  public void union(int p, int q) {
    // change p's root to q's root
    nodes[root(p)] = root(q);
  }

  protected int root(int n) {
    int i = nodes[n];
    for (; i != nodes[i]; i = nodes[i]);
    return i;
  }

  @Override
  public boolean isConnected(int p, int q) {
    return root(p) == root(q);
  }
}