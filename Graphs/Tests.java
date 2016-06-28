import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class Tests {
	Graphs g = new Graphs();
	
	@Test
	public void cloneGraphTests() {
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);
		
		node1.neighbors.add(node2);
		node1.neighbors.add(node3);
		node2.neighbors.add(node3);
		node2.neighbors.add(node4);
		
		GraphNode clone = g.cloneGraph(node1);
		node1.printAdjacencyList();
		clone.printAdjacencyList();
	}
	
	@Test
	public void wordLadderTests() {
		int depth = g.wordLadder("sing", "most");
		assertEquals(depth, 4);
	}
	
	@Test
	public void permuteTests() {
		int[] nums = {1,2,3};
		ArrayList<ArrayList<Integer>> lists = g.permute(nums);
		for(ArrayList<Integer> list : lists) {
			for(Integer elem : list) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}
	}
	
	
	@Test
	public void nQueensTests() {
		g.nQueens(8);
		g.nQueens(3);
	}
	
	/*
	

	
	
	@Test
	public void printAdjacencyTests() {
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);
		
		node1.neighbors.add(node2);
		node1.neighbors.add(node3);
		node2.neighbors.add(node3);
		node2.neighbors.add(node4);
		
		//node1.printAdjacencyList();
	}
	
	
	
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
