package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode347topKFrequent {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		int[] res = topKFrequent(nums, k);
		for (int i : res) {
			System.out.println(i);
		}
	}

	public static int[] topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			int c = map.getOrDefault(n, 0) + 1;
			map.put(n, c);
		} // number, count
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, (Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) -> {
			return b.getValue() - a.getValue();
		});
		int count = 0;
		List<Integer> l = new ArrayList<>();
		for (Map.Entry<Integer, Integer> m : list) {
			if (count < k) {
				l.add(m.getKey());
				count++;
			} else {
				break;
			}
		}
		return l.stream().mapToInt(Integer::intValue).toArray();
	}

	public static int[] topKFrequent2(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			int c = map.getOrDefault(n, 0) + 1;
			map.put(n, c);
		} // number, count
		PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>>(
				(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) -> {
					return b.getValue() - a.getValue();
				});
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			q.add(entry);
		}
		return null;
	}
}
