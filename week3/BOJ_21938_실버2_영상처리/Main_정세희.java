package week3.BOJ_21938_실버2_영상처리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 세로
        int M = Integer.parseInt(st.nextToken());   // 가로

        int[][] graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    graph[i][j] += Integer.parseInt(st.nextToken());
                }
            }
        }

        int T = Integer.parseInt(br.readLine()) * 3;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] >= T) {
                    graph[i][j] = 255;
                } else {
                    graph[i][j] = 0;
                }
            }
        }

        boolean[][] visited = new boolean[N][M];
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 255 && !visited[i][j]) {
                    bfs(graph, N, M, i, j, visited);
                    result += 1;
                }
            }
        }

        System.out.println(result);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int[][] graph, int N, int M, int x, int y, boolean[][] visited) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (graph[nx][ny] == 255 && !visited[nx][ny]) {
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
