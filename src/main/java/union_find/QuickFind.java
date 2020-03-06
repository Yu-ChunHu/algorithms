package union_find;

public class QuickFind {
  private int[] nodes;
  private int size;

  public QuickFind(int size) {
    this.size = size;
    initialNode();
  }

  private void initialNode() {
    nodes = new int[size];
    for (int i = 0; i < size; i++)
      nodes[i] = i;
  }

  public void union(int p, int q) {
    int pVal = nodes[p];
    int qVal = nodes[q];
    for (int i = 0; i < size; i++)
      if (nodes[i] == pVal) 
        nodes[i] = qVal;
  }

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

