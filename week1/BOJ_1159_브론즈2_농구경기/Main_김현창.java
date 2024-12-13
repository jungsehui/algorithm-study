package week1.BOJ_1159_브론즈2_농구경기;

import java.io.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alpha = new int[26];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            String input = br.readLine();
            ++alpha[input.charAt(0) - 'a'];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            if (alpha[i] >= 5)
                sb.append((char) (i + 'a'));
        }
        System.out.println(sb.length() > 0 ? sb.toString() : "PREDAJA");
        br.close();
    }
}
