package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode468RedundantConnection {
  public static void main(String[] args) {
    int[][] edge1 = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
    int[][] edge2 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
    int[] a1 = findRedundantConnection(edge1);
    int[] a2 = findRedundantConnection(edge2);
    System.out.println(a1[0]+","+a1[1]);
    System.out.println(a2[0]+","+a2[1]);
  }

  // 把題目轉換成 找到矩陣中 最後造型環形的點
  public static int[] findRedundantConnection(int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int[] edge : edges) {
      int start = edge[0];
      int end = edge[1];
      //此次路徑上有遇到也是環狀
      Set<Integer> traveled = new HashSet<>();
      //表示第一次找到環狀
      if (!dfs(traveled, start, end, graph)) {
        return edge;
      }
      //將雙向路徑都加到MAP
      if (!graph.containsKey(edge[0])) {
        graph.put(edge[0], new ArrayList<>());
      }
      if (!graph.containsKey(edge[1])) {
        graph.put(edge[1], new ArrayList<>());
      }
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    return new int[] {-1,-1};
  }

  public static boolean dfs(Set<Integer> traveled, int start, int end, Map<Integer, List<Integer>> graph) {
    if (traveled.contains(end)) {
      return false;
    }
    
    for (int i : graph.getOrDefault(start, new ArrayList<>())) {
      if(traveled.contains(i)) 
        continue;
      traveled.add(i);
      if (!dfs(traveled, i, end, graph)) {
        return false;
      }
    }
    return true;
  }
}
