package week7.BOJ_1890_실버1_점프;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {0, 1};
	private static final int[] dy = {1, 0};

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		for (int x = 0; x < N; ++x) {
			for (int y = 0; y < N; ++y) {
				for (int i = 0; i < 2; ++i) {
					int nx = x + board[x][y] * dx[i];
					int ny = y + board[x][y] * dy[i];
					if (nx >= N || ny >= N || (x == nx && y == ny))
						continue;
					dp[nx][ny] += dp[x][y];
				}
			}
		}
		System.out.println(dp[N - 1][N - 1]);
	    br.close();
	}
}
