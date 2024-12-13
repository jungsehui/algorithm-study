package week1.BOJ_1592_브론즈2_영식이와친구들;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] touch = new int[N];

        ++touch[0];
        int answer = 0;
        for (int ball = 0; touch[ball] < M; ++touch[ball], ++answer) {
            ball = (ball + N + L * ((touch[ball] & 1) == 0 ? -1 : 1)) % N;
        }
        System.out.println(answer);
        br.close();
    }
}
