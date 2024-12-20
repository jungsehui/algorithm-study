package week1.BOJ_1440_브론즈2_타임머신;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[][] indices = {
		{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), ":");
		int[] time = new int[3];
		for (int i = 0; i < 3; ++i) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		for (int[] i: indices) {
			if (isValid(time[i[0]], time[i[1]], time[i[2]])) {
				++answer;
			}
		}
		System.out.println(answer);
	    br.close();
	}

	private static boolean isValid(int hh, int mm, int ss) {
		return (1 <= hh && hh <= 12) && (0 <= mm && mm <= 59) && (0 <= ss && ss <= 59);
	}
}
