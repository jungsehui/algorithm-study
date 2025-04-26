package week7.BOJ_17484_실버3_진우의달여행;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int INF = Integer.MAX_VALUE >> 1;
    private static final int[] dy = {-1, 0, 1};

    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M][4];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, INF);
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = INF;
        for (int i = 0; i < M; i++) {
            result = Math.min(result, topDown(0, i, -1));
        }

        System.out.println(result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int topDown(int x, int y, int dir) {
        if (x == N - 1) {
            return map[x][y];
        }

        if (dp[x][y][dir + 1] != INF) {
            return dp[x][y][dir + 1];
        }

        int ret = INF;

        for (int i = 0; i < 3; i++) {
            if (i == dir) {
                continue;
            }

            int nx = x + 1;
            int ny = y + dy[i];

            if (ny < 0 || ny >= M) {
                continue;
            }

            ret = Math.min(ret, topDown(nx, ny, i) + map[x][y]);
        }

        return dp[x][y][dir + 1] = ret;
    }
}
