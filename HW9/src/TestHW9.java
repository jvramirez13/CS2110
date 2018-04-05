import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class TestHW9 {

	@Test
	public void test() {
		BinaryTreeNode<Integer> rightTest = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> leftTest = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> test1 = new BinaryTreeNode<Integer>(3, leftTest, rightTest);
		BinaryTree<Integer> treeTest = new BinaryTree<Integer>(test1);

		BinaryTreeNode<Integer> leftTestChild = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> rightTestChild = new BinaryTreeNode<Integer> (20);
		BinaryTreeNode<Integer> rightTest2 = new BinaryTreeNode<Integer>(10, leftTestChild, rightTestChild);
		BinaryTreeNode<Integer> leftTest2 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> test2 = new BinaryTreeNode<Integer>(8, leftTest2, rightTest2);
		BinaryTree<Integer> treeTest2 = new BinaryTree<Integer>(test2);

		BinaryTreeNode<Integer> rightTest3 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> leftTest3 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> test3 = new BinaryTreeNode<Integer>(3, leftTest3, rightTest3);
		BinaryTree<Integer> treeTest3 = new BinaryTree<Integer>(test3);

		//JUnit tests dealing with size and height
		assertEquals(treeTest.size(), 3);
		assertEquals(treeTest.height(), 2);
		assertEquals(treeTest2.size(), 5);
		assertEquals(treeTest2.height(), 3);

		//JUnit tests dealing with inOrder
		assertEquals(treeTest.inOrder(), "(2)(3)(4)");
		assertEquals(treeTest2.inOrder(), "(6)(8)(9)(10)(20)");

		//JUnit tests dealing with equals
		assertTrue(treeTest.equals(treeTest3));
		assertFalse(treeTest.equals(treeTest2));

		//JUnit tests dealing with deepCopy
		assertEquals(treeTest.deepCopy(), treeTest);
		assertEquals(treeTest3.deepCopy(), treeTest3);

		//JUnit tests dealing with full
		assertFalse(treeTest.full());
		assertFalse(treeTest2.full());
	}
}
