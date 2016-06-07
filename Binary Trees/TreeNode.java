import java.util.ArrayList;
import java.util.LinkedList;


public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	public int depth() {
		int leftDepth = 0, rightDepth = 0;
		if(this.left != null) {
			leftDepth = this.left.depth();
		}
		
		if(this.right != null) {
			rightDepth = this.right.depth();
		}
		return 1 + Math.max(leftDepth, rightDepth);
	}
	
	public void addToLeft(int val) {
		TreeNode newNode = new TreeNode(val);
		this.left = newNode;
		newNode.parent = this;
	}
	
	public void addToRight(int val) {
		TreeNode newNode = new TreeNode(val);
		this.right = newNode;
		newNode.parent = this;
	}
	
	public void prettyPrintTree() {
		BinaryTrees tree = new BinaryTrees();
		ArrayList<LinkedList<TreeNode>> lists = tree.createLevelLinkedLists(this);
		for(LinkedList<TreeNode> list : lists) {
			for(TreeNode node : list) {
				System.out.print(node.val + " ");
			}
			System.out.println("");
		}
		
	}
	
	
	
}
