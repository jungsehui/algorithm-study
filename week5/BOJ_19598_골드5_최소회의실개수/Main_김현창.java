package week5.BOJ_19598_골드5_최소회의실개수;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MAX_SIZE = 202020;

		int N = Integer.parseInt(br.readLine());
		int[] table = new int[MAX_SIZE]; // 1. Memory (21억 => 20만) [좌표 압축]
		Pair[] pairs = new Pair[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pairs[i] = new Pair(s, e);
		}

		coordinateCompression(N, pairs);

		for (Pair p: pairs) {
			table[p.s] += 1;
			table[p.e] -= 1;
		}

		// 누적합
		for (int i = 0; i < MAX_SIZE - 1; ++i) {
			table[i + 1] += table[i];
		}
		System.out.println(max(table));
		br.close();
	}

	private static int max(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int x: arr) {
			max = Math.max(x, max);
		}
		return max;
	}

	private static void coordinateCompression(int n, Pair[] pairs) {
		Set<Integer> set = new HashSet<>();
		for (Pair p: pairs) {
			set.add(p.s);
			set.add(p.e);
		}

		// set => list [ 정렬 ]
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);

		// Map
		Map<Integer, Integer> map = new HashMap<>();
		int index = 0;
		for (int i = 0, end = list.size(); i < end; ++i) {
			int x = list.get(i);

			if (!map.containsKey(x)) {
				map.put(x, index++);
			}
		}

		// Compression
		for (Pair p: pairs) {
			p.s = map.get(p.s);
			p.e = map.get(p.e);
		}
	}

	private static class Pair {
		int s, e;

		public Pair(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
}
