package week3.BOJ_2178_실버1_미로탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(N, M, graph));

        bw.flush();
        bw.close();
        br.close();
    }

    private static long bfs(int N, int M, int[][] graph) {
        boolean[][] visited = new boolean[N][M];
        Queue<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if (pair.x == N - 1 && pair.y == M - 1) {
                return graph[pair.x][pair.y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (graph[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }

                queue.add(new Pair(nx, ny));
                visited[nx][ny] = true;
                graph[nx][ny] = graph[pair.x][pair.y] + 1;
            }
        }

        return -1;
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
