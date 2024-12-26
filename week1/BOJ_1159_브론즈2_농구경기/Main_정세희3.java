package week1.BOJ_1159_브론즈2_농구경기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main_정세희3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * stream 안쓰는 연습
         *      => 길어져도 그냥 for문 등 사용
         */
        int[] counter = new int[200]; // index 0 ~ 25
                                      // 대문자 65 ~ 90
                                      // 소문자 97 ~ 1??

        int N = Integer.parseInt(br.readLine());

        /**
         * 알파벳 -> A-Z : 26개
         *             아스키 활용 쉽게 기록
         */
        for (int i = 0; i < N; ++i) {
            char first = br.readLine().charAt(0);
            ++counter[first - 'a'];   // **************
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            if (counter[i] >= 5) {
                sb.append((char) (i + 'a'));
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
