package week7.BOJ_14916_실버5_거스름돈;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_정세희 {

    private static final int INF = Integer.MAX_VALUE >> 2;
    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        Arrays.fill(dp, -1); // ✅ 초기값을 -1로 설정해서 구분

        int result = solveTopDown(N);
        bw.write(String.valueOf(result >= INF ? -1 : result)); // ✅ 불가능한 경우 처리
        bw.flush();
        bw.close();
        br.close();
    }

    private static int solveTopDown(int n) {
        if (n < 0) return INF;
        if (n == 0) return 0;

        if (dp[n] != -1) {
            return dp[n]; // ✅ 메모이제이션 확인
        }

        int use5 = solveTopDown(n - 5) + 1;
        int use2 = solveTopDown(n - 2) + 1;

        return dp[n] = Math.min(use5, use2);
    }

    private static int solveUsingBottomUp(int N) {
        // dp[i] => i라는 숫자가 1이 되기 위해 필요한 연산의 수
        // answer : dp[N]
        Arrays.fill(dp, INF);

        // Base Condition
        dp[1] = 0;

        for (int i = 1; i <= N; ++i) {
            if (i * 3 <= N)
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);

            if (i * 2 <= N)
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);

            if (i + 1 <= N)
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
        }

        return dp[N];
    }

    private static int solveBottomUp(int n) {
        // dp[i] => i라는 숫자가 0이 되기 위해(전부 다 거슬러 줌) 필요한 연산의 수
        // answer : dp[N]
        int[] dp = new int[n + 1]; // ✅ n+1로 공간 확보
        Arrays.fill(dp, INF);      // ✅ 초기값은 INF
        dp[0] = 0;                 // ✅ 0원 거스름돈 = 동전 0개

        for (int i = 1; i <= n; i++) {
            if (i >= 2) {
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            }
            if (i >= 5) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        return dp[n] == INF ? -1 : dp[n]; // ✅ 불가능한 경우 -1 처리
    }
}
