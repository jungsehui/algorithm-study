package week3.BOJ_1012_실버2_유기농배추;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) sb.append(solve(br)).append("\n");
		System.out.println(sb.toString());
		br.close();
	}

	private static int solve(BufferedReader br) throws IOException {
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] graph = new int[N][M];

		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[y][x] = 1;
		}

		int answer = 0;
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (graph[i][j] == 1 && !visited[i][j]) {
					++answer;
					bfs(graph, N, M, i, j, visited);
				}
			}
		}
		return answer;
	}

	private static void bfs(int[][] graph, int N, int M, int x, int y, boolean[][] visited) {
		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Pair p = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (graph[nx][ny] == 0)
					continue;

				if (!visited[nx][ny]) {
					queue.add(new Pair(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}

	private static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}