package week5.BOJ_3273_실버3_두수의합;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());
		Arrays.sort(a);

		long answer = 0;
		for (int left = 0, right = n - 1; left < right; ++left) {
			while (a[left] + a[right] > x)
				--right;

			if (left < right && a[left] + a[right] == x) {
				++answer;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
