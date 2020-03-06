package union_find;

import union_find.QuickFind;

public class QuickFindTest extends UnionFindTest{

  @Override
  protected UnionFind getUnionFindAlg() {
    return new QuickFind(10);
  }
}