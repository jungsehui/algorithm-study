package week3.BOJ_1189_실버1_컴백홈;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static int R;
    private static int C;
    private static int K;
    private static char[][] graph;
    private static boolean[][] visited;

    private static int result = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        visited[R - 1][0] = true;

        dfs(R - 1, 0, 1);

        System.out.println(result);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y, int depth) {
        if (depth == K) {
            if (x == 0 && y == C - 1) {
                result += 1;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                continue;
            }

            if (visited[nx][ny] || graph[nx][ny] == 'T') {
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1);
            visited[nx][ny] = false;
        }
    }
}
