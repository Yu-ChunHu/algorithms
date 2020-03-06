package union_find;

class PathCompressQuickUnionTest extends UnionFindTest {
  @Override
  protected UnionFind getUnionFindAlg() {
    return new PathCompressQuickUnion(10);
  }
}