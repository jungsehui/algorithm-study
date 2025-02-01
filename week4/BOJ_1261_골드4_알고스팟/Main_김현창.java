package week4.BOJ_1261_골드4_알고스팟;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] graph = new int[N][M];
		for (int i = 0; i < N; ++i) {
			String line = br.readLine();
			for (int j = 0; j < M; ++j) {
				graph[i][j] = line.charAt(j) - '0';
			}
		}

		int answer = 0;
		Deque<Pair> deque = new ArrayDeque<>();
		deque.add(new Pair(0, 0, 0));
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		while (!deque.isEmpty()) {
			Pair p = deque.poll();

			if (p.x == N - 1 && p.y == M - 1) {
				answer = p.count;
				break;
			}

			for (int i = 0; i < 4; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visited[nx][ny])
					continue;

				if (graph[nx][ny] == 1) {
					deque.addLast(new Pair(nx, ny, p.count + 1));
				} else {
					deque.addFirst(new Pair(nx, ny, p.count));
				}
				visited[nx][ny] = true;
			}
		}
		System.out.println(answer);
	    br.close();
	}

	private static class Pair {
		int x, y, count;

		Pair(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
