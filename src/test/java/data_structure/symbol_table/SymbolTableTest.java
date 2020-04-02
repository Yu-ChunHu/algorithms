package data_structure.symbol_table;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class BinarySearchTreeTest {

  private static Stream<SymbolTable<Integer, String>> provideImplementation() {
    return Stream.of(
        new BinarySearchTree<>(),
        new RedBlackBSTs<>()
    );
  }
  @ParameterizedTest
  @MethodSource("provideImplementation")
  void integration(SymbolTable<Integer, String> searchTree) {
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