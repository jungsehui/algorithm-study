package week2.BOJ_15651_실버3_N과M3;

import java.io.*;
import java.util.StringTokenizer;

/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

    1부터 N까지 자연수 중에서 M개를 고른 수열
    같은 수를 여러 번 골라도 된다.
*/

public class Main_정세희 {

    private static int N;
    private static int M;
    private static int[] perm;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        perm = new int[M];
        StringBuilder sb = new StringBuilder();

        dfs(0);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth) throws IOException {
        if (depth == M) {
            for (int elem : perm) {
                bw.write(elem + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= N; i++) {
            perm[depth] = i;
            dfs(depth + 1);
        }
    }
}
