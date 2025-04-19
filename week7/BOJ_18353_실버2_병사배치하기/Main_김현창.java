package week7.BOJ_18353_실버2_병사배치하기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] s = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			s[N - i - 1] = Integer.parseInt(st.nextToken());
		}

		int[] queue = new int[N + 1];
		int qIdx = 0;
		for (int x: s) {
			if (qIdx == 0 || queue[qIdx - 1] < x) {
				queue[qIdx++] = x;
			} else {
				int index = lowerBound(queue, 0, qIdx, x);
				queue[index] = x;
			}
		}
		System.out.println(N - qIdx);
	    br.close();
	}

	private static int lowerBound(int[] array, int left, int right, int k) {
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (array[mid] >= k)
				right = mid - 1;
			else left = mid + 1;
		}
		return right + 1;
	}
}
