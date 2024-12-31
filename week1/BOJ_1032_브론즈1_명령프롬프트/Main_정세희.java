package week1.BOJ_1032_브론즈1_명령프롬프트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[] files = new String[N];

        for (int i = 0; i < N; i++) {
            files[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder(files[0]);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < files[0].length(); j++) {
                if (sb.charAt(j) != files[i].charAt(j)) {
                    sb.setCharAt(j, '?');
                }
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}
