package union_find;

public class QuickFind extends UnionFind {

  public QuickFind(int size) {
    super(size);
  }

  @Override
  public void union(int p, int q) {
    int pVal = nodes[p];
    int qVal = nodes[q];
    for (int i = 0; i < size; i++)
      if (nodes[i] == pVal) 
        nodes[i] = qVal;
  }

  @Override
  public boolean isConnected(int p, int q) {
    return nodes[p] == nodes[q];
  }

  public static void main(String[] args) {
    QuickFind quickFind = new QuickFind(10);
    quickFind.union(0, 1);
    quickFind.union(1, 2);
    System.out.println(quickFind.isConnected(0, 2));
  }
}

