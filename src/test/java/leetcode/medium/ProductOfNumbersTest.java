package leetcode.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductOfNumbersTest {
  private ProductOfNumbers product;

  @BeforeEach
  void initialProduct() {
    product = new ProductOfNumbers();
  }

  @Test
  void pushOnePopOne() {
    product.add(1);
    int result = product.getProduct(1);
    assertEquals(1, result);
  }

  @Test
  void integration() {
    product.add(3);        // [3]
    product.add(0);        // [3,0]
    product.add(2);        // [3,0,2]
    product.add(5);        // [3,0,2,5]
    product.add(4);        // [3,0,2,5,4]
    int result = product.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
    assertEquals(20, result);
    result = product.getProduct(3);     // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
    assertEquals(40, result);
    result = product.getProduct(4);     // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
    assertEquals(0, result);
    product.add(8);        // [3,0,2,5,4,8]
    result = product.getProduct(2);     // return 32. The product of the last 2 numbers is 4 * 8 = 32 
    assertEquals(32, result);
    
  }
}