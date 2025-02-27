package week4.BOJ_14502_골드4_연구소;

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

    private static int N;
    private static int M;
    private static int[][] graph;
    private static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0);

        System.out.println(result);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void comb(int depth) {
        if (depth == 3) {
            result = Math.max(result, bfs());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    comb(depth + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    private static int bfs() {
        int[][] tempGraph = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempGraph[i][j] = graph[i][j];

                if (graph[i][j] == 2) {
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (tempGraph[nx][ny] != 0) {
                    continue;
                }

                tempGraph[nx][ny] = 2;
                queue.add(new Pair(nx, ny));
                visited[nx][ny] = true;
            }
        }

        int safeCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempGraph[i][j] == 0) {
                    safeCount++;
                }
            }
        }

        return safeCount;
    }

    private static class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}