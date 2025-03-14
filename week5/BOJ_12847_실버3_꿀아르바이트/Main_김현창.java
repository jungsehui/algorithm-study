package week5.BOJ_12847_실버3_꿀아르바이트;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] T = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			T[i] = Integer.parseInt(st.nextToken());
		}

		long profit = 0;
		for (int i = 0; i < m; ++i) {
			profit += T[i];
		}

		long answer = profit;
		for (int i = m; i < n; ++i) {
			profit += T[i];
			profit -= T[i - m];
			answer = Math.max(answer, profit);
		}
		System.out.println(answer);
	    br.close();
	}
}
