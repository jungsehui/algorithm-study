package week2.BOJ_15649_실버3_N과M1;

import java.io.*;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int N;
    private static int M;
    private static int[] perm;
    private static boolean[] visited;
    private static StringBuilder result;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        perm = new int[M];
        visited = new boolean[N + 1];
        result = new StringBuilder();

        dfs(0);

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth) throws IOException {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int elem : perm) {
                result.append(elem).append(" ");
            }
            result.append("/n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                perm[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
