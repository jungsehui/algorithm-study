package week7.BOJ_1495_실버1_기타리스트;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int INF = Integer.MAX_VALUE;
	private static int N, M;
	private static int[] V;
	private static int[][] cache;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cache = new int[N + 1][M + 1];
		fill2D(cache, -1);

		V = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			V[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solve(0, S) == -INF ? -1 : cache[0][S]);
	    br.close();
	}

	private static int solve(int index, int volume) {
		if (index == N)
			return volume;
		if (cache[index][volume] != -1)
			return cache[index][volume];

		int temp = -INF;
		if (volume - V[index] >= 0)
			temp = Math.max(temp, solve(index + 1, volume - V[index]));
		if (volume + V[index] <= M)
			temp = Math.max(temp, solve(index + 1, volume + V[index]));
		return cache[index][volume] = temp;
	}

	private static void fill2D(int[][] array, int value) {
		for (int[] row: array)
			Arrays.fill(row, value);
	}
}
