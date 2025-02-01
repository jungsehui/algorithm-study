package week4.BOJ_14502_골드4_연구소;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	private static final int[][] graph = new int[8][8];
	private static final boolean[][] visited = new boolean[8][8];
	private static final List<Pair> viruses = new ArrayList<>(66);
	private static int N, M, countOfCells, wallCount;
	private static int answer = 0;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		countOfCells = N * M;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1)
					++wallCount;
				else if (graph[i][j] == 2)
					viruses.add(new Pair(i, j));
			}
		}
		combination(0, 0);
		System.out.println(answer);
	    br.close();
	}

	private static void combination(int index, int depth) {
		if (depth == 3) {
			answer = Math.max(answer, countSafeArea());
			return;
		}
		for (int i = index; i < countOfCells; ++i) {
			int r = i / M;
			int c = i % M;
			if (graph[r][c] == 0) {
				graph[r][c] = 1;
				combination(i + 1, depth + 1);
				graph[r][c] = 0;
			}
		}
	}

	private static int countSafeArea() {
		Queue<Pair> queue = new ArrayDeque<>();
		for (Pair virus: viruses) {
			queue.add(virus);
			visited[virus.x][virus.y] = true;
		}
		int count = 0;
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			++count;

			for (int i = 0; i < 4; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visited[nx][ny])
					continue;
				if (graph[nx][ny] > 0)
					continue;
				queue.add(new Pair(nx, ny));
				visited[nx][ny] = true;
			}
		}
		fill2D(visited, false);
		return countOfCells - count - wallCount - 3;
	}

	private static void fill2D(boolean[][] array, boolean value) {
		for (boolean[] row: array) {
			Arrays.fill(row, value);
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
