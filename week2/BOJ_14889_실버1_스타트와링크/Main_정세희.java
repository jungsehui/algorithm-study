package week2.BOJ_14889_실버1_스타트와링크;

import java.io.*;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int N;
    private static int[][] S;
    private static boolean[] visited;
    private static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();

        S = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(minDifference + System.lineSeparator());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth, int start) {
        if (depth == (N / 2)) {
            calculateDiff();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static void calculateDiff() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += S[i][j];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += S[i][j];
                }
            }
        }

        int difference = Math.abs(startTeam - linkTeam);
        minDifference = Math.min(minDifference, difference);
    }
}
