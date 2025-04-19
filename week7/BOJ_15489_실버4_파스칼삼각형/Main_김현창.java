package week7.BOJ_15489_실버4_파스칼삼각형;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int MAX = 33;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		long[][] dp = new long[MAX][MAX];
		for (int i = 0; i < MAX; ++i) {
			dp[i][0] = dp[i][i] = 1;
		}

		for (int i = 2; i < MAX; ++i) {
			for (int j = 1; j < i; ++j) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		long answer = 0;
		for (int i = 0; i < W; ++i) {
			for (int j = 0; j <= i; ++j) {
				answer += dp[R + i - 1][C + j - 1];
			}
		}
		System.out.println(answer);
	    br.close();
	}
}
