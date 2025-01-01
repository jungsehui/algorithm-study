package week2.BOJ_15650_실버3_N과M2;

import java.io.*;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int N;
    private static int M;
    private static int[] comb;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        comb = new int[M];
        StringBuilder sb = new StringBuilder();

        dfs(0, 1);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int depth, int start) throws IOException {
        if (depth == M) {
            for (int elem : comb) {
                bw.write(elem + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = start; i <= N; i++) {
            comb[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}
