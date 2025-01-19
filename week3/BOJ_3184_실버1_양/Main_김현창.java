package week3.BOJ_3184_실버1_양;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] graph = new char[R][C];
		for (int i = 0; i < R; ++i) {
			String line = br.readLine();
			for (int j = 0; j < C; ++j) {
				graph[i][j] = line.charAt(j);
			}
		}

		int sheep = 0;
		int wolf = 0;
		boolean[][] visited = new boolean[R][C];
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (graph[i][j] == '#')
					continue;
				if (visited[i][j])
					continue;
				int[] res = bfs(graph, R, C, visited, i, j);
				sheep += res[0];
				wolf += res[1];
			}
		}
		System.out.println(sheep + " " + wolf);
	    br.close();
	}

	private static int[] bfs(char[][] graph, int R, int C, boolean[][] visited, int x, int y) {
		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(x, y));
		visited[x][y] = true;
		int sheep = 0;
		int wolf = 0;
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			if (graph[p.x][p.y] == 'v')
				++wolf;
			else if (graph[p.x][p.y] == 'o')
				++sheep;

			for (int i = 0; i < 4; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;
				if (graph[nx][ny] == '#')
					continue;
				if (visited[nx][ny])
					continue;

				queue.add(new Pair(nx, ny));
				visited[nx][ny] = true;
			}
		}
		return wolf >= sheep ? new int[]{0, wolf} : new int[]{sheep, 0};
	}

	private static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
