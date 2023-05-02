package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LeetCode261GraphValidTree {
	public static void main(String[] args) {
		
		int[][] edge1 = {{0,1},{0,2},{0,3},{0,4}};
		int[][] edge2 = {{0,1},{1,2},{2,3},{1,3},{1,4}};
		System.out.println("edge1:"+doTree(5, edge1));
		System.out.println("edge2:"+doTree(5, edge2));
	}

	//是一個Tree
	//表示全部點都有走，並且沒有出現環
	
	//將相鄰的表組裝
	public static boolean doTree(int n, int[][] edgs) {
		// adjacency 
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i<n ;i++) {
			map.put(i, new ArrayList<>());
		}
		
		//把每個點的雙向都加到 相鄰的表格
		for (int[] e :edgs) {
			map.get(e[0]).add(e[1]);
			map.get(e[1]).add(e[0]);
		}
		
		for(int i =0;i<n;i++) {
			for (int j :map.get(i)) {
			}
		}
		
		boolean[] visited = new boolean[n];
		// 第一次給-1當pre
		if (!dfs(map, visited, 0, -1)) {
			return false;
		}
		return true;
	}
	
	public static boolean dfs(HashMap<Integer, List<Integer>> map, boolean[] visited, int cur, int pre) {
		//無向圖與樹不會訪問第二次
		if(visited[cur]) {
			return false;
		}
		visited[cur] = true;
		for (int i : map.get(cur)) {
			// 檢查除了前一個訪問的 之外要在DFS
			if(i != pre && !dfs(map, visited, i, cur)) {
				return false;
			}
		}
		return true;
	}
	
}
