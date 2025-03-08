package week4.BOJ_1987_골드4_알파벳;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int R;
    private static int C;
    private static char[][] graph;
    private static boolean[] visited = new boolean[26];
    private static int maxCount = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 1);
        System.out.println(maxCount);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y, int count) {
        maxCount = Math.max(maxCount, count);
        visited[graph[x][y] - 'A'] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                continue;
            }

            if (visited[graph[nx][ny] - 'A']) {
                continue;
            }

            dfs(nx, ny, count + 1);
        }

        visited[graph[x][y] - 'A'] = false;
    }
}
