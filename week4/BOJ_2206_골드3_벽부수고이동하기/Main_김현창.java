package week4.BOJ_2206_골드3_벽부수고이동하기;

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

		int answer = -1;
		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(0, 0, 0, 1));
		boolean[][][] visited = new boolean[N][M][2];
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			Pair p = queue.poll();

			if (p.x == N - 1 && p.y == M - 1) {
				answer = p.count;
				break;
			}

			for (int i = 0; i < 4; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nc = p.crush;
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (graph[nx][ny] == 1) {
					if (p.crush == 0) ++nc;
					else continue;
				}
				if (visited[nx][ny][nc])
					continue;
				queue.add(new Pair(nx, ny, nc, p.count + 1));
				visited[nx][ny][nc] = true;
			}
		}
		System.out.println(answer);
	    br.close();
	}

	private static class Pair {
		int x, y, crush, count;

		public Pair(int x, int y, int crush, int count) {
			this.x = x;
			this.y = y;
			this.crush = crush;
			this.count = count;
		}
	}
}
