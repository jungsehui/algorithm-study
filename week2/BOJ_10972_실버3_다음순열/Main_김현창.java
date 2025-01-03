package week2.BOJ_10972_실버3_다음순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] perm = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			perm[i] = Integer.parseInt(st.nextToken());
		}

		if (np(perm, N)) printArray(perm, N);
		else System.out.println("-1");
		br.close();
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

	private static void printArray(int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}