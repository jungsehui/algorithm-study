package week7.BOJ_16493_실버2_최대페이지수;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] wgh = new int[M + 1];
		int[] val = new int[M + 1];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			wgh[i] = Integer.parseInt(st.nextToken());
			val[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[M + 1][N + 1];
		for (int i = 1; i <= M; ++i) {
			for (int j = 0; j <= N; ++j) {
				if (j - wgh[i - 1] >= 0)
					dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wgh[i - 1]]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		System.out.println(dp[M][N]);
	    br.close();
	}
}
