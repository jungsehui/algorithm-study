package week2.BOJ_20529_실버1_가장가까운세사람의심리적거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			sb.append(solve(br)).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	private static int solve(BufferedReader br) throws IOException {
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] counter = new int[16];
		for (int i = 0; i < N; ++i) {
			String mbti = st.nextToken();
			int bm = 0;
			if (mbti.charAt(0) == 'I')
				bm |= (1 << 3);
			if (mbti.charAt(1) == 'S')
				bm |= (1 << 2);
			if (mbti.charAt(2) == 'T')
				bm |= (1 << 1);
			if (mbti.charAt(3) == 'J')
				bm |= 1;
			++counter[bm];
		}

		List<Integer> candidates = new ArrayList<>();
		for (int i = 0; i < 16; ++i) {
			for (int j = 0; j < Math.min(counter[i], 3); ++j) {
				candidates.add(i);
			}
		}

		int answer = 123456789;
		int sz = candidates.size();
		for (int i = 0; i < sz; ++i) {
			for (int j = i + 1; j < sz; ++j) {
				for (int k = j + 1; k < sz; ++k) {
					int distance = 0;
					distance += countDifferentBit(candidates.get(i), candidates.get(j));
					distance += countDifferentBit(candidates.get(j), candidates.get(k));
					distance += countDifferentBit(candidates.get(k), candidates.get(i));
					answer = Math.min(answer, distance);
				}
			}
		}
		return answer;
	}

	private static int countDifferentBit(int a, int b) {
		int count = 0;
		while (a > 0 || b > 0) {
			count += Math.abs((a & 1) - (b & 1));
			a >>= 1;
			b >>= 1;
		}
		return count;
	}
}
