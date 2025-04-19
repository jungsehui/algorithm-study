package week5.BOJ_18870_실버2_좌표압축;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] X = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			X[i] = Integer.parseInt(st.nextToken());
		}

		coordinateCompression(N, X);

		StringBuilder sb = new StringBuilder();
		for (int x: X)
			sb.append(x).append(" ");
		System.out.println(sb.toString());
		br.close();
	}

	private static void coordinateCompression(int n, int[] arr) {
		int[] cloned = arr.clone();
		Arrays.sort(cloned);

		Map<Integer, Integer> map = new HashMap<>();
		int index = 0;
		for (int x: cloned) {
			if (!map.containsKey(x)) {
				map.put(x, index++);
			}
		}

		for (int i = 0; i < n; ++i) {
			arr[i] = map.get(arr[i]);
		}
	}
}