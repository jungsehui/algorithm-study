package week4.BOJ_10026_골드5_적록색약;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	private static int N;
	private static char[][] graph = new char[100][100];
	private static boolean[][] visited = new boolean[100][100];

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; ++i) {
			String line = br.readLine();
			for (int j = 0; j < N; ++j) {
				graph[i][j] = line.charAt(j);
			}
		}

		System.out.println(solve(false) + " " + solve(true));
	    br.close();
	}

	private static int solve(boolean isBlindness) {
		int count = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!visited[i][j]) {
					bfs(i, j, isBlindness);
					++count;
				}
			}
		}
		fill2D(visited, false);
		return count;
	}

	private static void bfs(int x, int y,  boolean isBlindness) {
		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(x, y));
		visited[x][y] = true;

		final int color = graph[x][y];

		while (!queue.isEmpty()) {
			Pair p = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (visited[nx][ny])
					continue;
				if (isBlindness) {
					if (color == 'B' && graph[nx][ny] != 'B')
						continue;
					else if (color != 'B' && graph[nx][ny] == 'B')
						continue;
				} else {
					if (color != graph[nx][ny])
						continue;
				}
				queue.add(new Pair(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}

	private static void fill2D(boolean[][] array, boolean value) {
		for (boolean[] row: array) {
			Arrays.fill(row, value);
		}
	}

	private static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
