package problems;

public class LeetCode323 {
	public static void main(String[] args) {
		int[][] edges = {{0,1},{1,2},{3,4}};
		int n = 5;
		System.out.println(countComponents(n, edges));
	}
	
	//DFS
	private static int countComponents(int n, int[][] edges)  {
		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			//¨ì³Ì²` count++
			if (!visited[i]) {
				dfs(visited, edges, i);
				count++;
			}
		}
		return count;
    }
	
	private static void dfs(boolean[] visited , int[][] edges, int i)  {
		visited[i] = true;
		for (int[] edge : edges) {
			int x = edge[0];
			int y = edge[1];
			if(x==i&&!visited[y]) {
				dfs(visited, edges, y);
			}
			if(y==i&&!visited[x]) {
				dfs(visited, edges, x);
			}
		}
	}
}
