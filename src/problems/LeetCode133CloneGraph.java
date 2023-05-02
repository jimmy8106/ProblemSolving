package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class LeetCode133CloneGraph {
	public static void main(String[] args) {
		
		
	}

	public Node cloneGraph(Node node) {
		if(node==null) return null;
		Node res = new Node(node.val);
		Node[] visited = new Node[101];//boundary
		Arrays.fill(visited, null);
		dfs(node, res, visited);
		return res;
	}
	
	public void dfs(Node node,Node res,Node[] visited) {
		visited[res.val] = res;
		for (Node toVisit : node.neighbors) { // loop all neighbors
			if(visited[toVisit.val]==null) {// not visited go deep
				Node newNode = new Node(toVisit.val);
				res.neighbors.add(newNode);
				dfs(toVisit, newNode, visited);
			} else {
				res.neighbors.add(visited[toVisit.val]);
			}
		}
	}

	public class Node {
		public Node(int val) {
			super();
			this.val = val;
		}
		public Node(int val, List<Node> neighbors) {
			this.val = val;
			this.neighbors = neighbors;
		}
		public int val;
		public List<Node> neighbors;
	}
}
