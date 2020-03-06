package union_find;

class PathCompressQuickUnion extends QuickUnion {
    
  public PathCompressQuickUnion(int size) {
    super(size);
  }

  @Override
  protected int root(int n) {
    for (; n != nodes[n]; n = nodes[n])
      nodes[n] = nodes[nodes[n]];
    return n;
  }

}