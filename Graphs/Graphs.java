import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Graphs {
	public class Square {
		char file;
		int rank;
		public Square(char file, int rank) {
			super();
			this.file = file;
			this.rank = rank;
		}
		
	}
	
	/**
	 * Clone a graph
	 * @param node : The input graph
	 * @return The cloned graph
	 */
	public GraphNode cloneGraph(GraphNode node) {
		HashMap<Integer, GraphNode> visited = new HashMap<>();
		GraphNode clone = cloneGraph(node, visited);
		return clone;
	}

	private GraphNode cloneGraph(GraphNode node,
			HashMap<Integer, GraphNode> visited) {
		GraphNode clone = new GraphNode(node.val);
		visited.put(clone.val, clone);
		
		for(GraphNode neighbor : node.neighbors) {
			if(visited.containsKey(neighbor.val)) {
				GraphNode newNeighbor = visited.get(neighbor.val);
				clone.neighbors.add(newNeighbor);
			}
			else {
				GraphNode newNeighbor = cloneGraph(neighbor, visited);
				clone.neighbors.add(newNeighbor);
				visited.put(newNeighbor.val, newNeighbor);
			}
		}
		return clone;
	}
	
	/**
	 * Given two words (beginWord and endWord), and a dictionary's word list, 
	 * find the length of shortest transformation sequence from beginWord to 
	 * endWord, such that:
     * 1. Only one letter can be changed at a time
     * 2. Each intermediate word must exist in the Dictionary
	 * EX: "hit" -> "hot" -> "dot" -> "dog" -> "cog"
	 */
	public int wordLadder(String src, String dest) {
		if(src.equals(dest)) {
			return 0;
		}
		
		Queue<String> queue = new Queue<String>();
		queue.push(src);
		String dummy = "";
		queue.push(dummy);
		HashSet<String> visited = new HashSet<String>();
		visited.add(src);
		int depth = 1;
		while(!queue.isEmpty()) {
			String node = queue.pop();
				if(!(node.equals(dummy))) {
				ArrayList<String> neighbors = getNeighbors(node, visited);
				for(String neighbor : neighbors) {
					if(neighbor.equals(dest)) {
						return depth;
					}
					queue.push(neighbor);
					visited.add(neighbor);
				}
				if(queue.peek().equals(dummy)) {
					queue.push(dummy);
					depth++;
				}
			}
		}
		return -1;
	}

	private ArrayList<String> getNeighbors(String str, HashSet<String> visited) {
		ArrayList<String> neighbors = new ArrayList<>();
		char[] letters = str.toCharArray();
		int size = letters.length;
		for(int i = 0; i < size; i++) {
			char temp = letters[i];
			for(char j = 'a'; j <= 'z'; j++) {
				letters[i] = j;
				String newWord = new String(letters);
				if(isWord(newWord) && !visited.contains(newWord)) {
					neighbors.add(newWord);
				}
			}
			letters[i] = temp;
		}
		
		return neighbors;
	}
	
	private boolean isWord(String str) {
		return (str.equals("sing") || str.equals("king") || str.equals("mist") || str.equals("ming")
				|| str.equals("mint") || str.equals("lint") || str.equals("pint") || str.equals("most"));
	}
	
	
	/**
	 * Given an array of unique Integers, return all permutations of 
	 * those Integers
	 * @param nums : the integers to be permuted
	 * @return : All permutations of the input array
	 */
	public ArrayList<ArrayList<Integer>> permute(int[] nums) {
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		permute(permutations, tempList, nums);
		return permutations;
	}

	private void permute(ArrayList<ArrayList<Integer>> permutations,
			ArrayList<Integer> tempList, int[] nums) {
		if(tempList.size() == nums.length) {
			permutations.add(tempList);
			return;
		}
		int size = tempList.size();
		int val = nums[size];
		for(int i = 0; i <= size; i++) {
			ArrayList<Integer> newTempList = new ArrayList<Integer>(tempList);
			newTempList.add(i, val);
			permute(permutations, newTempList, nums);
		}
	}
	
	/**
	 * Return the queen positions on an n X n chess board
	 * @param n
	 * @return the queens' positions as array indices, if there are any
	 */
	public void nQueens(int n) {
		ArrayList<Square> squares = new ArrayList<Square>();
		nQueens(n, squares);
		for(Square square : squares) {
			System.out.print(square.file);
			System.out.print(square.rank);
			System.out.print("\n");
		}
	}

	private void nQueens(int n, ArrayList<Square> squares) {
		char file = (char)(squares.size() + 'a');
		for(int rank = 1; rank <= n; rank++) {
			Square newSquare = new Square(file, rank);
			if(!underAttack(squares, newSquare)) {
				squares.add(newSquare);
				nQueens(n, squares);
				if(squares.size() == n) {
					return;
				}
				else {
					squares.remove(newSquare);
				}
			}
		}
	}

	private boolean underAttack(ArrayList<Square> squares, Square newSquare) {
		for(Square square : squares) {
			if(underAttack(square, newSquare)) {
				return true;
			}
		}
		return false;
	}

	private boolean underAttack(Square square1, Square square2) {
		boolean b1 = (square1.rank == square2.rank);
		boolean b2 = (square1.file == square2.file);
		boolean b3 = (Math.abs(square1.file - square2.file) == 
				Math.abs(square1.rank - square2.rank));
		
		return b1||b2||b3;
	}
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
