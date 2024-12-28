package week1.BOJ_1032_브론즈1_명령프롬프트;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		char[] words = br.readLine().toCharArray();
		int length = words.length;
		for (int i = 0; i < N - 1; ++i) {
			char[] file = br.readLine().toCharArray();
			for (int j = 0; j < length; ++j) {
				if (words[j] != file[j])
					words[j] = '?';
			}
		}
		System.out.println(new String(words));
		br.close();
	}
}
