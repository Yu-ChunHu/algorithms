package union_find;

public class QuickFindTest extends UnionFindTest{

  @Override
  protected UnionFind getUnionFindAlg() {
    return new QuickFind(10);
  }
}