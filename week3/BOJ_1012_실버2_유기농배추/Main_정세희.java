package week3.BOJ_1012_실버2_유기농배추;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            sb.append(solve(br)).append(" ");
        }

        System.out.println(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static int solve(BufferedReader br) throws IOException {
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] graph = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            graph[X][Y] = 1;
        }

        int result = 0;

        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 & !visited[i][j]) {
                    result++;
                    bfs(graph, M, N, i, j, visited);
                }
            }
        }

        return result;
    }

    private static void bfs(int[][] graph, int M, int N, int X, int Y, boolean[][] visited) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(X, Y));
        visited[X][Y] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }

                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    queue.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
