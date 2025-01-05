package week2.BOJ_24954_실버1_물약구매;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] c = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			c[i] = Integer.parseInt(st.nextToken());
		}

		int[][] a = new int[N + 1][];
		int[][] d = new int[N + 1][];
		for (int i = 1; i <= N; ++i) {
			int p = Integer.parseInt(br.readLine());
			a[i] = new int[p];
			d[i] = new int[p];
			for (int j = 0; j < p; ++j) {
				st = new StringTokenizer(br.readLine());
				a[i][j] = Integer.parseInt(st.nextToken());
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] perm = new int[N];
		for (int i = 0; i < N; ++i) {
			perm[i] = i + 1;
		}

		int answer = 123456789;
		do {
			answer = Math.min(answer, test(N, perm, c, a, d));
		} while (np(perm, N));

		System.out.println(answer);
		br.close();
	}

	private static int test(int N, int[] order, int[] c, int[][] a, int[][] d) {
		int coin = 0;
		int[] cost = c.clone();
		for (int i = 0; i < N; ++i) {
			int o = order[i];
			coin += cost[o];
			for (int j = 0, end = a[o].length; j < end; ++j) {
				cost[a[o][j]] = Math.max(cost[a[o][j]] - d[o][j], 1);
			}
		}
		return coin;
	}

	private static boolean np(int[] perm, int n) {
		int i = n - 1;
		while (i > 0 && perm[i - 1] >= perm[i])
			--i;

		if (i == 0)
			return false;

		int j = n - 1;
		while (perm[i - 1] >= perm[j])
			--j;

		swap(perm, i - 1, j);

		int k = n - 1;
		while (i < k)
			swap(perm, i++, k--);

		return true;
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
