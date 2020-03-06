package union_find;

class WeightedQuickUnionTest extends UnionFindTest{
  protected UnionFind getUnionFindAlg() {
    return new WeightedQuickUnion(10);
  }
}