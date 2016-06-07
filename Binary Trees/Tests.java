import static org.junit.Assert.*;

import org.junit.Test;


public class Tests {
	BinaryTrees tree = new BinaryTrees();
	
	
	@Test
	public void isBSTTests() {
		TreeNode left = new TreeNode(5);
		left.addToLeft(3);
		left.addToRight(7);
		TreeNode right = new TreeNode(13);
		right.addToLeft(11);
		right.addToRight(15);
		
		TreeNode root = new TreeNode(9);
		root.left = left;
		root.right = right;
		boolean b1 = tree.isBST(root);
		
		root.left = right;
		root.right = left;
		boolean b2 = tree.isBST(root);
		assertEquals(b1, true);
		assertEquals(b2, false);
	}
	
	@Test
	public void createMinimalBSTTests() {
		int[] arr = {1, 3, 5, 6, 7, 9, 11, 13, 15, 17, 18, 20, 23, 26, 29};
		TreeNode root = tree.createMinimalBST(arr);
		root.prettyPrintTree();
	}
	
	@Test
	public void longestConsecutiveSequenceTests() {
		TreeNode node1 = new TreeNode(1);
		node1.addToLeft(2);
		node1.left.addToLeft(3);
		node1.left.left.addToLeft(8);
		node1.left.left.left.addToLeft(9);
		
		int num = tree.longestConsecutiveSequence(node1);
		assertEquals(num, 3);
		
		node1.addToRight(2);
		node1.right.addToLeft(3);
		node1.right.left.addToRight(4);
		num = tree.longestConsecutiveSequence(node1);
		assertEquals(num, 4);
		
	}
	
	@Test
	public void firstCommonAncestorTests() {
		int[] arr = {1, 3, 5, 6, 7, 9, 11, 13, 15, 17, 18, 20, 23, 26, 29};
		TreeNode root = tree.createMinimalBST(arr);
		TreeNode node1 = tree.firstCommonAncestor(root, root.left.left, root.left.right);
		TreeNode node2 = tree.firstCommonAncestor(root, root.left, root.left.right);
		TreeNode node3 = tree.firstCommonAncestor(root, root.left.left, root.right.right.right);
		TreeNode node4 = tree.firstCommonAncestor(root, new TreeNode(5), root.left.right);
		TreeNode node5 = tree.firstCommonAncestor(root, root, new TreeNode(5));
		TreeNode node6 = tree.firstCommonAncestor(root, new TreeNode(5), new TreeNode(5));
		
		assertEquals(node1, root.left);
		assertEquals(node2, root.left);
		assertEquals(node3, root);
		assertEquals(node4, null);
		assertEquals(node5, null);
		assertEquals(node6, null);
	}
	
	@Test
	public void maxPathSum() {
		int[] arr = {1, 2, 3};
		TreeNode root = tree.createMinimalBST(arr);
		int maxPathSum = tree.maxPathSum(root);
		assertEquals(maxPathSum, 6);
		
		int[] arr3 = {100, 200, 300};
		TreeNode root3 = tree.createMinimalBST(arr3);
		root.left.left = root3;
		int maxPathSum3 = tree.maxPathSum(root);
		assertEquals(maxPathSum3, 600);
		
		int[] arr1 = {-2};
		TreeNode root1 = tree.createMinimalBST(arr1);
		int maxPathSum1 = tree.maxPathSum(root1);
		assertEquals(maxPathSum1, -2);
		
		int[] arr2 = {2, -1};
		TreeNode root2 = tree.createMinimalBST(arr2);
		int maxPathSum2 = tree.maxPathSum(root2);
		assertEquals(maxPathSum2, 2);
	}
	
}
