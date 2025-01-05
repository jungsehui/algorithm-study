package week2.BOJ_14889_실버1_스타트와링크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김현창 {

	private static int N, N2;
	private static int[][] S;
	private static int answer = 1234567890;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		N2 = N >> 1;
		S = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1, 1, 1);
		System.out.println(answer);
		br.close();
	}

	private static void dfs(int index, int visit, int depth) {
		if (depth == N2) {
			answer = Math.min(answer, test(visit));
			return;
		}
		for (int i = index; i < N; ++i) {
			if ((visit & (1 << i)) > 0)
				continue;
			dfs(i + 1, visit | (1 << i), depth + 1);
		}
	}

	private static int test(int visit) {
		int start = 0;
		int link = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = i + 1; j < N; ++j) {
				if ((visit & (1 << i)) > 0 && (visit & (1 << j)) > 0) {
					start += S[i][j];
					start += S[j][i];
				} else if ((visit & (1 << i)) == 0 && (visit & (1 << j)) == 0) {
					link += S[i][j];
					link += S[j][i];
				}
			}
		}
		return Math.abs(start - link);
	}
}