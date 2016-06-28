import java.util.ArrayList;
import java.util.HashSet;


public class GraphNode {
	int val;
	ArrayList<GraphNode> neighbors;
	public GraphNode(int val) {
		this.neighbors = new ArrayList<GraphNode>();
		this.val = val;
	}
	
	public void printAdjacencyList() {
		HashSet<GraphNode> visited = new HashSet<GraphNode>();
		this.printAdjacencyList(visited);
	}
	
	public void printAdjacencyList(HashSet<GraphNode> visited) {
		if(!visited.contains(this)) {
			visited.add(this);
			System.out.print(this.val + "->");
			for(GraphNode neighbor : this.neighbors) {
				System.out.print(neighbor.val + "->");
			}
			System.out.print("\n");
			for(GraphNode neighbor : this.neighbors) {
				neighbor.printAdjacencyList(visited);
			}
		}
	}
}
