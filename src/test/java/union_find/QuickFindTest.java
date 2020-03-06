package union_find;

class QuickFindTest extends UnionFindTest{
  @Override
  protected UnionFind getUnionFindAlg() {
    return new QuickFind(10);
  }
}