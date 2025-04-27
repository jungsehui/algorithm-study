package week7.BOJ_1495_실버1_기타리스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int INF = Integer.MAX_VALUE >> 1;

    private static int N;
    private static int S;
    private static int M;
    private static int[] V;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        V = new int[N];
        dp = new int[N + 1][M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; ++i) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(topDown(0, S) == -INF ? -1 : topDown(0, S));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int topDown(int index, int volume) {
        if (index == N) {
            return volume;
        }

        if (dp[index][volume] != -1) {
            return dp[index][volume];
        }

        int ret = -INF;
        if (volume - V[index] >= 0) {
            ret = Math.max(ret, topDown(index + 1, volume - V[index]));
        }
        if (volume + V[index] <= M) {
            ret = Math.max(ret, topDown(index + 1, volume + V[index]));
        }

        return dp[index][volume] = ret;
    }
}
