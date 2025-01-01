package week2.BOJ_15652_실버3_N과M4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김현창 {

	private static int N, M;
	private static int[] comb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		comb = new int[M];

		StringBuilder sb = new StringBuilder();
		dfs(0, 0, sb);
		System.out.println(sb.toString());
		br.close();
	}

	private static void dfs(int index, int depth, StringBuilder sb) {
		if (depth == M) {
			for (int num: comb)
				sb.append(num).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = index; i < N; ++i) {
			comb[depth] = i + 1;
			dfs(i, depth + 1, sb);
		}
	}
}
