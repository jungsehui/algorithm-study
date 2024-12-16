package week1.BOJ_2596_브론즈1_비밀편지;

import java.io.*;

public class Main_김현창 {

	private static final String[] characters = {
		"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"
	};

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String string = br.readLine();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			String substr = string.substring(i * 6, i * 6 + 6);

			boolean match = false;
			for (int cIdx = 0; cIdx < 8; ++cIdx) {
				if (substr.equals(characters[cIdx])) {
					sb.append((char) ('A' + cIdx));
					match = true;
					break;
				}
			}

			if (!match) {
				char c = get(substr);
				if (c == '!') {
					sb.setLength(0);
					sb.append(i + 1);
					break;
				}
				sb.append(c);
			}
		}
		System.out.println(sb.toString());
		br.close();
	}

	private static char get(String str) {
		int predict = 0;
		char character = '!';
		for (int cIdx = 0; cIdx < 8; ++cIdx) {
			String charstr = characters[cIdx];
			int diff = 0;
			for (int i = 0; i < 6; ++i) {
				if (str.charAt(i) != charstr.charAt(i)) {
					++diff;
				}
			}
			if (diff == 1) {
				++predict;
				character = (char) ('A' + cIdx);
			}
		}
		return predict == 1 ? character : '!';
	}
}
