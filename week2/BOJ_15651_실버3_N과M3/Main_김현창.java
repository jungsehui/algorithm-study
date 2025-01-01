package week2.BOJ_15651_실버3_N과M3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김현창 {

	private static int N, M;
	private static int[] perm;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		perm = new int[M];

		StringBuilder sb = new StringBuilder();
		dfs(0, sb);
		System.out.println(sb.toString());
		br.close();
	}

	private static void dfs(int depth, StringBuilder sb) {
		if (depth == M) {
			for (int num: perm)
				sb.append(num).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; ++i) {
			perm[depth] = i + 1;
			dfs(depth + 1, sb);
		}
	}
}
