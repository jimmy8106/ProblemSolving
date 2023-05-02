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

	//�O�@��Tree
	//��ܥ����I�������A�åB�S���X�{��
	
	//�N�۾F����ո�
	public static boolean doTree(int n, int[][] edgs) {
		// adjacency 
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i<n ;i++) {
			map.put(i, new ArrayList<>());
		}
		
		//��C���I�����V���[�� �۾F�����
		for (int[] e :edgs) {
			map.get(e[0]).add(e[1]);
			map.get(e[1]).add(e[0]);
		}
		
		for(int i =0;i<n;i++) {
			for (int j :map.get(i)) {
			}
		}
		
		boolean[] visited = new boolean[n];
		// �Ĥ@����-1��pre
		if (!dfs(map, visited, 0, -1)) {
			return false;
		}
		return true;
	}
	
	public static boolean dfs(HashMap<Integer, List<Integer>> map, boolean[] visited, int cur, int pre) {
		//�L�V�ϻP�𤣷|�X�ݲĤG��
		if(visited[cur]) {
			return false;
		}
		visited[cur] = true;
		for (int i : map.get(cur)) {
			// �ˬd���F�e�@�ӳX�ݪ� ���~�n�bDFS
			if(i != pre && !dfs(map, visited, i, cur)) {
				return false;
			}
		}
		return true;
	}
	
}
