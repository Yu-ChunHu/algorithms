package union_find;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

abstract class UnionFindTest {
  protected UnionFind unionFind;

  @BeforeEach
  void setUpNode() {
    unionFind = getUnionFindAlg();
  }

  protected abstract UnionFind getUnionFindAlg();

  @Test
  void isNotConnected_WithoutAnyUnion() {
    assertFalse(unionFind.isConnected(0, 1));
  }

  @Test
  void union01Nodes_IsConnected() {
    unionFind.union(0, 1);
    assertTrue(unionFind.isConnected(0, 1));
  }

  @Test
  void union01And12_02IsConnected() {
    unionFind.union(0, 1);
    unionFind.union(1, 2);
    assertTrue(unionFind.isConnected(0, 2));
  }
}