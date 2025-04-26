package week6.BOJ_1759_골드5_암호만들기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth, int start, StringBuilder password, char[] chars, int L, int C) {
        if (depth == L) {
            if (check(password.toString())) {
                sb.append(password).append(System.lineSeparator());
            }
            return;
        }

        for (int i = start; i < C; i++) {
            password.append(chars[i]);
            dfs(depth + 1, i + 1, password, chars, L, C);
            password.deleteCharAt(password.length() - 1);
        }
    }

    private static boolean check(String password) {
        int consonant = 0;
        int vowel = 0;
        for (char c : password.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }
        return consonant >= 2 && vowel >= 1;
    }
}
