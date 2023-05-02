package problems;

import java.util.ArrayList;
import java.util.List;

public class FillBucketFromNumIsland {
	public static void main(String[] args) {
		List<String> picture = new ArrayList<>();
		picture.add("aaaba");
		picture.add("ababa");
		picture.add("aaaca");
		System.out.println(fillBucket(picture));
	}

	public static int fillBucket(List<String> picture) {
		char[][] grid = new char[picture.size()][];
		int index = 0;
		for (String s : picture) {
			grid[index] = s.toCharArray();
			index++;
		}
		int count = 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j]!='X') {//has traveled
					count++;
					char lastC = grid[i][j];
					//do DFS
					dfsTraverse(grid, m, n, i, j, lastC);
				}
			}	
		}
		
		return count;
	}
	
	public static void dfsTraverse(char[][] grid,int m, int n, int i, int j,char lastC) {
		if (i<0||i>=m||j<0||j>=n||grid[i][j]!=lastC) {//out of boundary or traveled
			return;
		} else {
			// have traversed
			grid[i][j] = 'X';
			dfsTraverse(grid, m, n, i+1, j, lastC);
			dfsTraverse(grid, m, n, i-1, j, lastC);
			dfsTraverse(grid, m, n, i, j+1, lastC);
			dfsTraverse(grid, m, n, i, j-1, lastC);
		}
	}
}
