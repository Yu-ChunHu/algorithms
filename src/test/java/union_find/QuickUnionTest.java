package union_find;

import union_find.UnionFind;
import union_find.QuickUnion;

public class QuickUnionTest extends UnionFindTest {

  @Override
  protected UnionFind getUnionFindAlg() {
    return new QuickUnion(10);
  }
}