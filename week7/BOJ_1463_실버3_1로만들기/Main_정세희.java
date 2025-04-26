package week7.BOJ_1463_실버3_1로만들기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        int result = topDown(N);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int topDown(int N) {
        if (N == 1) {
            return 0;
        }

        if (dp[N] > 0) {
            return dp[N];
        }

        int ret = Integer.MAX_VALUE >> 1;

        if (N % 3 == 0) {
            ret = Math.min(ret, topDown(N / 3) + 1);
        }

        if (N % 2 == 0) {
            ret = Math.min(ret, topDown(N / 2) + 1);
        }

        ret = Math.min(ret, topDown(N - 1) + 1);

        return dp[N] = ret;
    }
}
