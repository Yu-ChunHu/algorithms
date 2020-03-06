package union_find;

public class WeightedQuickUnionTest extends UnionFindTest{

  protected UnionFind getUnionFindAlg() {
    return new WeightedQuickUnion(10);
  }
}