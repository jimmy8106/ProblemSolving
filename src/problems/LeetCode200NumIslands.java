package problems;

public class LeetCode200NumIslands {
	public static void main(String[] args) {
		
		
	}

	public int numIslands(char[][] grid) {
		if(grid.length==0||grid[0].length==0) {
			return 0;
		}
		int count = 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("i:%s j:%s val:",i,j, grid[i][j]);
				System.out.println();
				if(grid[m][n]=='1') {
					count++;
					System.out.printf("count:%s travel", count);
					System.out.println();
					//do DFS
					dfsTraverse(grid, m, n, i, j);
				}
			}	
		}
		
		return count;
	}
	
	public void dfsTraverse(char[][] grid,int m, int n, int i, int j) {
		if (i<0||i>=m||j<0||j>=n||grid[i][j]=='1') {//out of boundary
			return;
		} else {
			// have traversed
			grid[i][j] = '2';
			dfsTraverse(grid, m, n, i+1, j);
			dfsTraverse(grid, m, n, i-1, j);
			dfsTraverse(grid, m, n, i, j+1);
			dfsTraverse(grid, m, n, i, j-1);
		}
	}
}
