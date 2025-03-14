package week5.BOJ_25708_실버2_만남의광장;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] d = new int[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] lToR = new int[N];
		int[] tToB = new int[M];
		for (int i = 0; i < N; ++i) {
			int sum = 0;
			for (int j = 0; j < M; ++j) {
				sum += d[i][j];
			}
			lToR[i] = sum;
		}

		for (int j = 0; j < M; ++j) {
			int sum = 0;
			for (int i = 0; i < N; ++i) {
				sum += d[i][j];
			}
			tToB[j] = sum;
		}

		int answer = Integer.MIN_VALUE;
		for (int x1 = 0; x1 < N; ++x1) {
			for (int x2 = x1 + 1; x2 < N; ++x2) {
				for (int y1 = 0; y1 < M; ++y1) {
					for (int y2 = y1 + 1; y2 < M; ++y2) {
						int value = 0;
						value += lToR[x1];
						value += lToR[x2];
						value += tToB[y1];
						value += tToB[y2];
						value -= (d[x1][y1] + d[x2][y1] + d[x1][y2] + d[x2][y2]);
						value += (y2 - y1 - 1) * (x2 - x1 - 1);
						answer = Math.max(answer, value);
					}
				}
			}
		}
		System.out.println(answer);
	    br.close();
	}
}
