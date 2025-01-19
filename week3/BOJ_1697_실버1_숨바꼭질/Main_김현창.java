package week3.BOJ_1697_실버1_숨바꼭질;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] visited = new int[222222];

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		visited[N] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			if (now == K)
				break;

			int[] nextCandidates = {now - 1, now + 1, now * 2};
			for (int next: nextCandidates) {
				if (next >= 0 && next <= 101010 && visited[next] == 0) {
					queue.add(next);
					visited[next] = visited[now] + 1;
				}
			}
		}
		System.out.println(visited[K] - 1);
		br.close();
	}
}
