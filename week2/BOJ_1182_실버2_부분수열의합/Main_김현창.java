package week2.BOJ_1182_실버2_부분수열의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(subset(arr, N, S, 0, 0) - (S == 0 ? 1 : 0));
		br.close();
	}

	private static int subset(int[] arr, int n, int s, int depth, int sum) {
		if (depth == n) {
			return sum == s ? 1 : 0;
		}
		return subset(arr, n, s, depth + 1, sum + arr[depth]) +
			subset(arr, n, s, depth + 1, sum);
	}
}