package problems;

import java.util.ArrayList;
import java.util.List;

public class LeetCode207CourseSchedule {
	public static void main(String[] args) {
		int[][] p1 = {{1,0}}; 
		int[][] p2 = {{1,0},{0,1}}; 
		int[][] p3 = {{1,0},{2,1},{3,0}};
		int[][] p4 = {{2,0},{3,0},{3,1},{4,2},{5,2},{5,3}};
		int[][] p5 = {{1,0},{2,0},{2,1},{3,2},{1,3}};
		System.out.println("p1:"+canFinish(2, p1));
		System.out.println("p2:"+canFinish(2, p2));
		System.out.println("p3:"+canFinish(4, p3));
		System.out.println("p4:"+canFinish(6, p4));
		System.out.println("p5:"+canFinish(4, p5));
		
	}
	// 有向圖 將問題理解成是否有環
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = (List<Integer>[]) new ArrayList<?>[numCourses];
        for (int i = 0; i < numCourses; i++) 
            graph[i] = new ArrayList<>();
        //adjacency list directed graph
        //ex
        //1-> 3,4
        //2-> 4
        //3-> 5,6
        //4-> 6
        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }
        boolean[] visited = new boolean[numCourses];
        
        boolean[] onpath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(graph, visited, onpath, i)) {
                return false;
            }
        }
        return true;

    }
	//DFS ex: 1->3->5
    private static boolean hasCycle(List<Integer>[] graph, boolean[] visited, boolean[] onpath, int i) {
        visited[i] = true;
        // 此輪是否已走過
        onpath[i] = true;
        for (int j : graph[i]) {
        	//未拜訪過 繼續走
            if (!visited[j] && hasCycle(graph, visited, onpath, j)) {
                return true;
            } else if (onpath[j]) {
                return true;
            }
        }
        onpath[i] = false;
        return false;
    }
}
