package union_find;

public class WeightedQuickUnion extends QuickUnion {
    private int[] depth;

    public WeightedQuickUnion(int size) {
      super(size);
    }

    @Override
    protected void initialNode() {
      nodes = new int[size];
      depth = new int[size];
      for (int i = 0; i < size; i++) {
        nodes[i] = i;
        depth[i] = 1;
      }
    }

    @Override
    public void union(int p, int q) {
      int big = q;
      int small = p;
      if (depth[p] > depth[q]) {
        big = p;
        small = q;
      }
      nodes[root(small)] = root(big);
      setTreeDepth(small, big);
    }

    private void setTreeDepth(int small, int big) {
      if (depth[big] == depth[small])
        depth[big] += 1;
      depth[small] = depth[big];
    }
  }