package week1.BOJ_1333_브론즈1_부재중전화;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int albumLength = N * L + (N - 1) * 5;
		boolean[] music = new boolean[albumLength + 1];
		for (int i = 0; i < albumLength; i = i + L + 5) {
			Arrays.fill(music, i, i + L, true);
		}

		int answer = ((albumLength - 1) / D) * D + D;
		for (int i = 0; i < albumLength; i += D) {
			if (!music[i]) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
