package week2.BOJ_18429_실버3_근손실;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int[] perm = new int[N];
		for (int i = 0; i < N; ++i) {
			perm[i] = i;
		}

		int answer = 0;
		do {
			answer += test(A, N, K, perm) ? 1 : 0;
		} while (nextPermutation(perm, N));

		System.out.println(answer);
		br.close();
	}

	private static boolean test(int[] A, int N, int K, int[] order) {
		int weight = 500;
		for (int i = 0; i < N; ++i) {
			weight += A[order[i]];
			weight -= K;
			if (weight < 500)
				return false;
		}
		return true;
	}

	private static boolean nextPermutation(int[] perm, int n) {
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

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
