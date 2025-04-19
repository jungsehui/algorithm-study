package week7.BOJ_17216_실버2_가장큰감소부분수열;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		System.arraycopy(A, 0, dp, 0, N);
		for (int i = 1; i < N; ++i) {
			for (int j = i - 1; j >= 0; --j) {
				if (A[i] < A[j])
					dp[i] = Math.max(dp[i], dp[j] + A[i]);
			}
		}
		System.out.println(max(dp));
	    br.close();
	}

	private static int max(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int num: nums) {
			max = Math.max(max, num);
		}
		return max;
	}
}
