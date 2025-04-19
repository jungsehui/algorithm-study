package week7.BOJ_1463_실버3_1로만들기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int INF = 123456789;
	private static final int[] cache = new int[1001011];

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Arrays.fill(cache, 0, N + 1, INF);
		System.out.println(dp(N));
	    br.close();
	}

	private static int dp(int x) {
		if (x == 1)
			return 0;
		if (cache[x] != INF)
			return cache[x];

		int ret = INF;
		if (x % 3 == 0)
			ret = Math.min(ret, dp(x / 3) + 1);
		if ((x & 1) == 0)
			ret = Math.min(ret, dp(x >> 1) + 1);
		ret = Math.min(ret, dp(x - 1) + 1);
		return cache[x] = ret;
	}
}
