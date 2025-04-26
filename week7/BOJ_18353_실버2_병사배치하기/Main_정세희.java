package week7.BOJ_18353_실버2_병사배치하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int INF = Integer.MAX_VALUE >> 1;

    private static int N;
    private static int[] power;
    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        power = new int[N];
        dp = new int[N];
        Arrays.fill(dp, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, topDown(i));
        }
        System.out.println(N - result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int topDown(int index) {
        if (dp[index] != -1) {
            return dp[index];
        }

        dp[index] = 1;

        for (int prev = 0; prev < index; prev++) {
            if (power[prev] > power[index]) {
                dp[index] = Math.max(dp[index], topDown(prev) + 1);
            }
        }
        
        return dp[index];
    }
}
