package union_find;

public class PathCompressQuickUnionTest extends UnionFindTest {
  @Override
  protected UnionFind getUnionFindAlg() {
    return new PathCompressQuickUnion(10);
  }
}