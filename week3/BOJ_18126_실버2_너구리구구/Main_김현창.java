package week3.BOJ_18126_실버2_너구리구구;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<List<Node>> graph = new ArrayList<>(N + 1);
		for (int i = 0; i <= N; ++i) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph.get(A).add(new Node(B, C));
			graph.get(B).add(new Node(A, C));
		}

		Queue<Integer> queue = new ArrayDeque<>();
		long[] visited = new long[N + 1];
		Arrays.fill(visited, -1);

		queue.add(1);
		visited[1] = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (Node nextNode: graph.get(now)) {
				if (visited[nextNode.index] == -1) {
					queue.add(nextNode.index);
					visited[nextNode.index] = visited[now] + nextNode.cost;
				}
			}
		}
		System.out.println(Math.max(max(visited), 0));
	    br.close();
	}

	private static long max(long[] nums) {
		long max = Long.MIN_VALUE;
		for (long num: nums) {
			max = Math.max(max, num);
		}
		return max;
	}

	private static class Node {
		int index, cost;

		Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
	}
}
