package data_structure.symbol_table;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
  @Test
  void integration() {
    BinarySearchTree<Integer, String> searchTree = new BinarySearchTree<>();
    searchTree.put(2, "a");
    searchTree.put(1, "b");
    searchTree.put(3, "c");
    searchTree.put(5, "d");
    searchTree.put(2, "e");
    searchTree.put(0, "f");
    searchTree.delete(1);
    assertEquals("c", searchTree.get(3));
    assertEquals("e", searchTree.get(2));
    assertNull(searchTree.get(1));
    assertNull(searchTree.get(100));
    assertEquals(4, searchTree.size());
  }
}