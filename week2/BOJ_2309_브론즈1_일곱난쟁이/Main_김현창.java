package week2.BOJ_2309_브론즈1_일곱난쟁이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int total = 0;
		int[] h = new int[9];
		for (int i = 0; i < 9; ++i) {
			total += h[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(h);

		int bestI = -1;
		int bestJ = -1;
		for (int i = 0; i < 9; ++i) {
			for (int j = i + 1; j < 9; ++j) {
				if (total - h[i] - h[j] == 100) {
					bestI = i;
					bestJ = j;
					i = 1234;
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; ++i) {
			if (i == bestI || i == bestJ)
				continue;
			sb.append(h[i]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
