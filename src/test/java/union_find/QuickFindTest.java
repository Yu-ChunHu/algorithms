package union_find;

import union_find.QuickFind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuickFindTest {
  private QuickFind quickFind;
  
  @BeforeEach
  void setUpNode() {
    quickFind = new QuickFind(10);
  }

  @Test
  void isNotConnected_WithoutAnyUnion() {
    assertFalse(quickFind.isConnected(0, 1));
  }

  @Test
  void union01Nodes_IsConnected() {
    quickFind.union(0, 1);
    assertTrue(quickFind.isConnected(0, 1));
  }

  @Test
  void union01And12_02IsConnected() {
    quickFind.union(0, 1);
    quickFind.union(1, 2);
    assertTrue(quickFind.isConnected(0, 2));
  }
}