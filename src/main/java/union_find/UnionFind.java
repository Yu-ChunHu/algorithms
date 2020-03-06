package union_find;

public abstract class UnionFind {
  protected int[] nodes;
  protected int size;

  protected UnionFind(int size) {
    this.size = size;
    initialNode();
  }

  protected void initialNode() {
    nodes = new int[size];
    for (int i = 0; i < size; i++)
      nodes[i] = i;
  }

  protected abstract void union(int p, int q);
  protected abstract boolean isConnected(int p, int q);
}