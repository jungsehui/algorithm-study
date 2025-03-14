package week5.BOJ_11659_실버3_구간합구하기4;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; ++i) {
			nums[i] += nums[i - 1];
		}

		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			if (i > j) {
				int temp = i;
				i = j;
				j = temp;
			}
			sb.append(nums[j] - nums[i - 1]).append("\n");
		}
		System.out.println(sb.toString());
	    br.close();
	}
}
