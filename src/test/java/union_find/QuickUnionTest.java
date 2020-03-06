package union_find;

class QuickUnionTest extends UnionFindTest {

  @Override
  protected UnionFind getUnionFindAlg() {
    return new QuickUnion(10);
  }
}