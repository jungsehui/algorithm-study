package week9.BOJ_4195_골드3_DancDancRevolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정세희_내가푼거아님 {

    static final int INF = Integer.MAX_VALUE / 2;
    static int[][][] dp;
    static int[] steps;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> input = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            input.add(n);
        }

        int N = input.size();
        steps = new int[N];
        for (int i = 0; i < N; i++) {
            steps[i] = input.get(i);
        }

        dp = new int[N + 1][5][5];
        for (int[][] d1 : dp) {
            for (int[] d2 : d1) {
                Arrays.fill(d2, INF);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < N; i++) {
            int next = steps[i];
            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    if (dp[i][l][r] == INF) continue;
                    if (next != r) {
                        dp[i + 1][next][r] = Math.min(dp[i + 1][next][r], dp[i][l][r] + cost(l, next));
                    }
                    if (next != l) {
                        dp[i + 1][l][next] = Math.min(dp[i + 1][l][next], dp[i][l][r] + cost(r, next));
                    }
                }
            }
        }

        int answer = INF;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                answer = Math.min(answer, dp[N][l][r]);
            }
        }

        System.out.println(answer);
    }

    static int cost(int from, int to) {
        if (from == 0) return 2;
        if (from == to) return 1;
        if ((from == 1 && to == 3) || (from == 3 && to == 1) ||
                (from == 2 && to == 4) || (from == 4 && to == 2)) return 4;
        return 3;
    }
}
