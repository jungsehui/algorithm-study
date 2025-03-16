package week5.BOJ_2531_실버1_회전초밥;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static int N;
	private static int[] arr;
	private static int[] chk;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		arr = new int[N + k];
		chk = new int[d + 1];

		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < k; ++i) {
			arr[N + i] = arr[i];
		}

		int count = 0;
		for (int i = 0; i < k; ++i) {
			count += add(i);
		}

		int answer = count;
		for (int i = k; i < N + k; ++i) {
			count += add(i);
			count -= poll(i - k);
			answer = Math.max(answer, count + (chk[c] == 0 ? 1 : 0));
		}
		System.out.println(answer);
	    br.close();
	}

	private static int add(int index) {
		return ++chk[arr[index]] == 1 ? 1 : 0;
	}

	private static int poll(int index) {
		return --chk[arr[index]] == 0 ? 1 : 0;
	}
}
