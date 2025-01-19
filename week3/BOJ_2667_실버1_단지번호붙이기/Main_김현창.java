package week3.BOJ_2667_실버1_단지번호붙이기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	private static int N;
	private static int[][] graph;
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			String line = br.readLine();
			for (int j = 0; j < N; ++j) {
				graph[i][j] = line.charAt(j) -'0';
			}
		}

		List<Integer> results = new ArrayList<>();
		for (int x = 0; x < N; ++x) {
			for (int y = 0; y < N; ++y) {
				if (graph[x][y] == 1 && visited[x][y] == false) {
					results.add(bfs(x, y));
				}
			}
		}

		Collections.sort(results);
		StringBuilder sb = new StringBuilder();
		sb.append(results.size()).append("\n");
		for (int x: results) {
			sb.append(x).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	private static int bfs(int x, int y) {
		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(x, y));
		visited[x][y] = true;

		int houseCnt = 0;
		while (!queue.isEmpty()) {
			++houseCnt;
			Pair p = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (visited[nx][ny] == true)
					continue;
				if (graph[nx][ny] != 1)
					continue;
				queue.add(new Pair(nx, ny));
				visited[nx][ny] = true;
			}
		}
		return houseCnt;
	}

	private static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
