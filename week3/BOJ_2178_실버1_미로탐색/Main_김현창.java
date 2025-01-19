package week3.BOJ_2178_실버1_미로탐색;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] graph = new int[N][M];
		for (int i = 0; i < N; ++i) {
			String line = br.readLine();
			for (int j = 0; j < M; ++j) {
				graph[i][j] = line.charAt(j) - '0';
			}
		}

		Queue<Pair> queue = new ArrayDeque<>();
		int[][] visited = new int[N][M];
		queue.add(new Pair(0, 0));
		visited[0][0] = 1;
		while (!queue.isEmpty()) {
			Pair p = queue.poll();

			if (p.x == N - 1 && p.y == M - 1)
				break;

			for (int i = 0; i < 4; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visited[nx][ny] != 0)
					continue;
				if (graph[nx][ny] == 0)
					continue;
				queue.add(new Pair(nx, ny));
				visited[nx][ny] = visited[p.x][p.y] + 1;
			}
		}
		System.out.println(visited[N - 1][M - 1]);
	    br.close();
	}

	private static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
