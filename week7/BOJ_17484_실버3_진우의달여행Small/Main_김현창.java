package week7.BOJ_17484_실버3_진우의달여행Small;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dy = {-1, 0, 1};
	private static final int INF = 123456789;

	private static int N, M;
	private static int[][] graph;
	private static int[][][] dp;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N + 1][M];
		dp = new int[N + 1][M][3];
		fill3D(dp, INF);

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = INF;
		for (int j = 0; j < M; ++j) {
			answer = Math.min(answer, dfs(0, j, -1));
		}
		System.out.println(answer);
	    br.close();
	}

	private static int dfs(int x, int y, int dir) {
		if (x == N)
			return 0;
		if (x > 0 && dp[x][y][dir] != INF)
			return dp[x][y][dir];

		int temp = INF;
		for (int i = 0; i < 3; ++i) {
			if (i == dir) continue;
			int nx = x + 1;
			int ny = y + dy[i];
			if (ny < 0 || ny >= M)
				continue;
			temp = Math.min(temp, dfs(nx, ny, i) + graph[nx][ny]);
		}
		if (x == 0)
			return temp;
		return dp[x][y][dir] = temp;
	}

	private static void fill3D(int[][][] array, int value) {
		for (int[][] one: array)
			for (int[] two: one)
				Arrays.fill(two, value);
	}
}
