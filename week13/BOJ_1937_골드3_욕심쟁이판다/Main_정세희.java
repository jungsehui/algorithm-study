package week13.BOJ_1937_골드3_욕심쟁이판다;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int INF = 123123123;
    private static int n;
    private static int[][] bamboo;
    private static int[][] dp;

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        bamboo = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                bamboo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxVisited = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxVisited = Math.max(maxVisited, dfs(i, j));
            }
        }
        System.out.println(maxVisited);

        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 다음 칸이 대나무 숲 범위 내에 있고
            // 다음 칸의 대나무 양이 현재 칸보다 많으면 이동 가능
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && bamboo[nx][ny] > bamboo[x][y]) {
                // 다음 칸에서 시작하는 경로의 최대 길이 + 1 (현재 칸 포함)과
                // 현재까지 저장된 최대 길이를 비교하여 더 큰 값을 저장
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }

        return dp[x][y]; // 계산된 최대 칸 수 반환
    }
}
