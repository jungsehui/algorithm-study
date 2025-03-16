package week5.BOJ_2559_실버3_수열;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		for (int i = 0; i < K; ++i) {
			sum += arr[i];
		}

		int answer = sum;
		for (int i = K; i < N; ++i) {
			sum += arr[i];
			sum -= arr[i - K];
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	    br.close();
	}
}
