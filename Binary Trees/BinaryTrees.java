import java.util.ArrayList;
import java.util.LinkedList;


public class BinaryTrees {
	public class MaxLengths {
		public int curLen;
		public int globalMax;
		public MaxLengths(int curLen, int globalMax) {
			super();
			this.curLen = curLen;
			this.globalMax = globalMax;
		}
	}
	
	public class AncestorInfo {
		TreeNode node;
		boolean isAncestor;
		public AncestorInfo(TreeNode node, boolean isAncestor) {
			super();
			this.node = node;
			this.isAncestor = isAncestor;
		}
		
	}
	
	public class PathSums {
		public int halfPathSum;
		public int fullPathSum;
		public PathSums(int halfPathSum, int fullPathSum) {
			super();
			this.halfPathSum = halfPathSum;
			this.fullPathSum = fullPathSum;
		}
		public PathSums() {
			// TODO Auto-generated constructor stub
		}
		
	}
	
	/**
	 * Given a sorted (increasing order) array with unique integer elements,
	 *  write an algorithm to create a binary search tree with minimal height
	 */
	public TreeNode createMinimalBST(int[] arr) {
		TreeNode root = createMinimalBST(arr, 0, arr.length - 1);
		return root;
	}

	private TreeNode createMinimalBST(int[] arr, int start, int end) {
		if(end < start) {
			return null;
		}
		
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = createMinimalBST(arr, start, mid - 1);
		root.right = createMinimalBST(arr, mid + 1, end);
		return root;
	}
	
	
	/**
	 * Implement a function to check if a binary tree is a binary search tree.
	 * @param Node root
	 */
	public boolean isBST(TreeNode root) {
		boolean b = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return b;
	}

	private boolean isBST(TreeNode root, int minValue, int maxValue) {
		if(root == null) {
			return true;
		}
		
		boolean bLeft = false;
		boolean bRight = false;
		boolean b = (minValue <= root.val && root.val <= maxValue);
		if(b) {
			bLeft = isBST(root.left, minValue, root.val);
			bRight = isBST(root.right, root.val, maxValue);
		}
		
		return bLeft && bRight;
	}
	
	/**
	 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at
	 * each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
	 * @param root
	 */
	public ArrayList<LinkedList<TreeNode>> createLevelLinkedLists(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> head = new LinkedList<TreeNode>();
		head.add(root);
		lists.add(head);
		LinkedList<TreeNode> itr = head;
		while(!itr.isEmpty()) {
			LinkedList<TreeNode> newLayer = new LinkedList<TreeNode>();
			for(TreeNode node : itr) {
				if(node.left != null) {
					newLayer.add(node.left);
				}
				if(node.right != null) {
					newLayer.add(node.right);
				}
			}
			lists.add(newLayer);
			itr = newLayer;
		}
		return lists;
	}
	
	
	/**
	 * Given a tree find the length of the longest consecutive sequence
	 */
	public int longestConsecutiveSequence(TreeNode root) {
		MaxLengths m = longestConsecutiveSequenceHelper(root);
		return m. globalMax;
	}

	private MaxLengths longestConsecutiveSequenceHelper(TreeNode root) {
		if(root.left == null && root.right == null) {
			return new MaxLengths(1, 1);
		}
		
		MaxLengths mLeft = new MaxLengths(Integer.MIN_VALUE, Integer.MIN_VALUE);
		MaxLengths mRight = new MaxLengths(Integer.MIN_VALUE, Integer.MIN_VALUE);
		
		if(root.left != null) {
			mLeft = longestConsecutiveSequenceHelper(root.left);
			if(root.val + 1 == root.left.val) {
				mLeft.curLen++;
				if(mLeft.globalMax < mLeft.curLen) {
					mLeft.globalMax = mLeft.curLen;
				}
			}
			else {
				mLeft.curLen = 1;
			}
		}
		
		if(root.right != null) {
			mRight = longestConsecutiveSequenceHelper(root.right);
			if(root.val + 1 == root.right.val) {
				mRight.curLen++;
				if(mRight.globalMax < mRight.curLen) {
					mRight.globalMax = mRight.curLen;
				}
			}
			else {
				mRight.curLen = 1;
			}
		}
		
		
		int curLen = Math.max(mLeft.curLen, mRight.curLen);
		int globalMax = Math.max(mLeft.globalMax, mRight.globalMax);
		MaxLengths m = new MaxLengths(curLen, globalMax);
		
		return m;
	}
	
	
	/**
	 * Design an algorithm and write code to find the first common ancestor of two nodes
	 * in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
	 * necessarily a binary search tree.
	 * @param root
	 * @param node1
	 * @param node2
	 * @return the ancestor if both nodes are present in the tree, else null
	 */	
	public TreeNode firstCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		AncestorInfo a = firstCommonAncestorHelper(root, node1, node2);
		if(a.isAncestor) {
			return a.node;
		}
		else {
			return null;
		}
	}

	/**
	 * @returns: (ancestor, true) if the ancestor is found
	 * 			 (node, false) if one of the nodes input is found
	 *           (null, false) if both nodes not found
	 */
	private AncestorInfo firstCommonAncestorHelper(TreeNode root,
			TreeNode node1, TreeNode node2) {
		if(root == null) {
			return new AncestorInfo(null, false);
		}
		
		AncestorInfo aLeft = firstCommonAncestorHelper(root.left, node1, node2);
		AncestorInfo aRight = firstCommonAncestorHelper(root.right, node1, node2);
		
		if(aLeft.isAncestor) {
			return aLeft;
		}
		
		if(aRight.isAncestor) {
			return aRight;
		}
		
		if(aLeft.node != null && aRight.node != null) {
			return new AncestorInfo(root, true);
		}
		else if((root == node1) || (root == node2)) {
			boolean b = (aLeft.node != null || aRight.node != null);
			return new AncestorInfo(root, b);
		}
		else {
			TreeNode node = null; 
			if(aLeft.node != null) 
				node = aLeft.node;
			if(aRight.node != null) 
				node = aRight.node;
			return new AncestorInfo(node, false);
		}
	}
	
	/**
	 * Find the maximum path sum in a Binary Tree. For this problem, a path
	 * is defined as any sequence of nodes from some starting node to any node
	 * in the tree along the parent-child connections. The path does not need
	 * to go through the root.
	 */
	public int maxPathSum(TreeNode root) {
		PathSums p = maxPathSumHelper(root);
		return p.fullPathSum;
	}

	private PathSums maxPathSumHelper(TreeNode root) {
		if(root == null) {
			return new PathSums(0, Integer.MIN_VALUE);
		}
		
		PathSums pLeft = maxPathSumHelper(root.left);
		PathSums pRight = maxPathSumHelper(root.right);
		
		int newMaxVal = root.val + Math.max(0, pLeft.halfPathSum) + 
				Math.max(0, pRight.halfPathSum);
		
		PathSums pCurrent = new PathSums();
		if(newMaxVal >= pLeft.fullPathSum && newMaxVal >= pRight.fullPathSum) {
			pCurrent.fullPathSum = newMaxVal;
		}
		else {
			pCurrent.fullPathSum = Math.max(pLeft.fullPathSum, pRight.fullPathSum);
		}
		
		int halfPathSum = root.val + 
				Math.max(0, Math.max(pLeft.halfPathSum, pRight.halfPathSum));
		
		pCurrent.halfPathSum = halfPathSum;
		
		return pCurrent;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
