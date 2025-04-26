package week7.BOJ_17216_실버2_가장큰감소부분수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = A[i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
        }

        int result = 0;
        for (int val : dp) {
            result = Math.max(result, val);
        }

        System.out.println(result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int topDown(int N) {
        return 0;
    }
}
