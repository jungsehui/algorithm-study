package week7.BOJ_11060_실버2_점프점프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int INF = Integer.MAX_VALUE >> 1;

    private static int N;
    private static int[] A;
    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N];
        Arrays.fill(dp, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int result = topDown(0);
        if (result != INF) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int topDown(int index) {
        if (index >= N - 1) {
            return 0;
        }

        if (A[index] == 0) {
            return INF;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int ret = INF;

        for (int i = 1; i <= A[index]; i++) {
            if (index + i < N) {
                ret = Math.min(ret, topDown(index + i) + 1);
            }
        }

        return dp[index] = ret;
    }
}
