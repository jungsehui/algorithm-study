package week7.BOJ_16493_실버2_최대페이지수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int N;
    private static int M;
    private static int[] days;
    private static int[] pages;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        days = new int[M + 1];
        pages = new int[M + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[M + 1][N + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        int result = topDown(0, N);
        System.out.println(result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int topDown(int index, int day) {
        if (index == M) {
            return 0;
        }

        if (dp[index][day] != -1) {
            return dp[index][day];
        }

        int ret = topDown(index + 1, day);

        if (day - days[index] >= 0) {
            ret = Math.max(ret, topDown(index + 1, day - days[index]) + pages[index]);
        }

        return dp[index][day] = ret;
    }
}
