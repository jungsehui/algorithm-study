package week5.BOJ_16139_실버1_인간컴퓨터상호작용;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		String S = br.readLine();
		int length = S.length();
		int q = Integer.parseInt(br.readLine());

		int[][] cnt = new int[length + 1][26];
		for (int i = 1; i <= length; ++i) {
			System.arraycopy(cnt[i - 1], 0, cnt[i], 0, 26);
			++cnt[i][S.charAt(i - 1) - 'a'];
		}

		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int c = st.nextToken().charAt(0) - 'a';
			int l = Integer.parseInt(st.nextToken()) + 1;
			int r = Integer.parseInt(st.nextToken()) + 1;
			sb.append(cnt[r][c] - cnt[l - 1][c])
				.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
