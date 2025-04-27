package week7.BOJ_1890_실버1_점프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int INF = Integer.MAX_VALUE >> 1;

    private static int N;
    private static int[][] map;
    private static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(topDown(0, 0));

        bw.flush();
        bw.close();
        br.close();
    }

    private static long topDown(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            return 1;
        }

        if (map[x][y] == 0) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        int jump = map[x][y];

        if (x + jump < N) {
            dp[x][y] += topDown(x + jump, y);
        }

        if (y + jump < N) {
            dp[x][y] += topDown(x, y + jump);
        }

        return dp[x][y];
    }
}
