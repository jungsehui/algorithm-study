package week7.BOJ_14916_실버5_거스름돈;

import java.io.*;

public class Main_김현창 {

	private static final int INF = Integer.MAX_VALUE >> 2;
	private static final int[] cache = new int[101010];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		System.out.println(solve(n) >= INF ? -1 : cache[n]);

		br.close();
	}

	private static int solve(int n) {
		if (n == 0)
			return 0;
		else if (n < 0)
			return INF;
		if (cache[n] > 0)
			return cache[n];

		return cache[n] = Math.min(solve(n - 2) + 1, solve(n - 5) + 1);
	}
}
