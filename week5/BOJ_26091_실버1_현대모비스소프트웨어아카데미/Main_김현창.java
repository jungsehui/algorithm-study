package week5.BOJ_26091_실버1_현대모비스소프트웨어아카데미;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);

		int answer = 0;
		for (int left = 0, right = N - 1; left < right; ++left, --right) {
			while (left < right && a[left] + a[right] < M) {
				++left;
			}

			if (left < right) {
				++answer;
			}
		}
		System.out.println(answer);
	    br.close();
	}
}
