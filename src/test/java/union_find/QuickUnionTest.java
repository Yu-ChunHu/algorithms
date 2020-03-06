package union_find;

public class QuickUnionTest extends UnionFindTest {

  @Override
  protected UnionFind getUnionFindAlg() {
    return new QuickUnion(10);
  }
}