import java.util.ArrayList;
import java.util.HashSet;


public class DataStructures {
	/**
	 * Given a Histogram find the area of the largest rectangle
	 * that can be inscribed in it
	 * @param Bar heights as an Array
	 * @return the area of the rectangle with maximum area
	 */
	public int LargestRectangleArea(int[] H) {
		Stack myStack = new Stack();
		int i = 0;
		int size = H.length;
		int maxArea = 0;
		while(i <= size) {
			if(myStack.isEmpty() || (i != size && H[i] > H[myStack.peek()])) {
				myStack.push(i);
				i++;
			}
			else {
				int stackTopIndex = myStack.pop();
				int max = i;
				int min = myStack.isEmpty() ? -1 : myStack.peek();
				int curArea = H[stackTopIndex] * (max - min - 1);
				maxArea = Math.max(maxArea, curArea);
			}
		}
		
		return maxArea;
	}
	
	/**
	 * Find Median from the input Data Stream of integers
	 * @param nums
	 * @return the median of the integers in it
	 */
	public float medianOfNums(int[] nums) {
		MaxHeap left = new MaxHeap();
		MinHeap right = new MinHeap();
		
		for(int num : nums) {
			float curMedian = getCurrentMedian(right, left);
			int sizeDiff = right.size() - left.size();
			if(num > curMedian) {
				if(sizeDiff == 1) {
					right.insert(num);
					int rightRoot = right.deleteRoot();
					left.insert(rightRoot);
				}
				else {
					right.insert(num);
				}
			}
			else if(num < curMedian) {
				if(sizeDiff == -1) {
					left.insert(num);
					int leftRoot = left.deleteRoot();
					right.insert(leftRoot);
				}
				else {
					left.insert(num);
				}
			}
			else if(num == curMedian) {
				if(sizeDiff == -1) {
					right.insert(num);
				}
				else {
					left.insert(num);
				}
			}
		}
		return getCurrentMedian(right, left);
	}
	
	private float getCurrentMedian(MinHeap minHeap, MaxHeap maxHeap) {
		if(minHeap.size() == 0 && maxHeap.size() == 0) {
			return 0;
		}
		int sizeDiff = minHeap.size() - maxHeap.size();
		if(sizeDiff == 0) {
			return ((float)(minHeap.root()) + (float)(maxHeap.root())) / 2;
		}
		else if(sizeDiff == 1) {
			return minHeap.root();
		}
		else {
			return maxHeap.root();
		}
	}
	
	/**
	 * Given an unsorted array of integers, find the length
	 * of the longest consecutive elements sequence.
	 * @param arr
	 * @return the length of the longest consecutive sequence
	 * Ex: {100,4,1,200,5,3,201,2}; Output = 5
	 */
	public int longestConsecutiveSequence(int[] arr) {
		HashSet<Integer> vals = new HashSet<Integer>();
		int maxLen = 0;
		for(int val : arr) {
			vals.add(val);
		}
		
		while(!vals.isEmpty()) {
			for(int val : vals) {
				int leftLen = searchAndRemove(vals, val, -1);
				int rightLen = searchAndRemove(vals, val, 1);
				vals.remove(val);
				maxLen = Math.max(maxLen, leftLen + rightLen + 1);
				break;
			}
		}
		
		return maxLen;
	}

	private int searchAndRemove(HashSet<Integer> vals, int val, int diff) {
		int i = 1;
		while(vals.contains(val + i * diff)) {
			vals.remove(val + i * diff);
			i++;
		}
		
		return i - 1;
	}
	
	/**
	 * Given a 2D board and a list of words from the dictionary,
	 * find all words in the board. Each word must be constructed 
	 * from letters of sequentially adjacent cell, where "adjacent"
	 * cells are those horizontally or vertically neighboring.
	 * The same letter cell may not be used more than once in a word.
	 * @param board - 2D array of characters
	 * @param words - the dictionary
	 * @return all the words that can be formed
	 * Ex: board = [
		  			['o','a','a','n'],
		  			['e','t','a','e'],
		  			['i','h','k','r'],
		  			['i','f','l','v']
				   ]
	   Given words = ["oath","pea","eat","rain"]
	   Output = ["oath", "eat"]
	 */
	public ArrayList<String> findWords(char[][] board, String[] words) {
		TrieNode trie = new TrieNode("");
		for(String word : words) {
			trie.insert(word);
		}
		ArrayList<String> validWords = new ArrayList<String>();
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visited = new boolean[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				char c = board[i][j];
				TrieNode tNode = trie.leaves[c - 'a'];
				if(tNode != null) {
					search(board, visited, validWords, tNode, i, j);
					clearVisited(visited);
				}
			}
		}
		
		return validWords;
	}

	private void search(char[][] board, boolean[][] visited,
			ArrayList<String> validWords, TrieNode tNode, int i, int j) {
		if(tNode.isword) {
			validWords.add(tNode.s);
		}
		visited[i][j] = true;
		ArrayList<int[]> neighbors = getBoardNeighbors(board, i, j);
		for(int[] neighbor : neighbors) {
			int newI = neighbor[0];
			int newJ = neighbor[1];
			if(!visited[newI][newJ]) {
				char c = board[newI][newJ];
				TrieNode newTNode = tNode.leaves[c - 'a'];
				if(newTNode != null) {
					search(board, visited, validWords, newTNode, newI, newJ);
				}
			}
		}
		visited[i][j] = false;
	}

	private ArrayList<int[]> getBoardNeighbors(char[][] board, int i, int j) {
		ArrayList<int[]> neighbors = new ArrayList<int[]>();
		int rows = board.length;
		int cols = board[0].length;
		if(i - 1 >= 0) {
			int[] neighbor = {i - 1, j};
			neighbors.add(neighbor);
		}
		if(i + 1 < rows) {
			int[] neighbor = {i + 1, j};
			neighbors.add(neighbor);
		}
		if(j - 1 >= 0) {
			int[] neighbor = {i, j - 1};
			neighbors.add(neighbor);
		}
		if(j + 1 < cols) {
			int[] neighbor = {i, j + 1};
			neighbors.add(neighbor);
		}
		
		return neighbors;
		
	}
	
	private void clearVisited(boolean[][] visited) {
		int rows = visited.length;
		int cols = visited[0].length;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
