package week4.BOJ_2206_골드3_벽부수고이동하기;

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
    private static int N;
    private static int M;
    private static int[][] graph;
    private static boolean[][][] visited;
    private static int result = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M][2];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0, 0, 1);

        System.out.println(result);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int x, int y, int crush, int count) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x, y, crush, count));
        visited[x][y][0] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            if (p.x == N - 1 && p.y == M - 1) {
                result = p.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nc = p.crush;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (graph[nx][ny] == 1) {
                    if (p.crush == 0) {
                        nc++;
                    } else {
                        continue;
                    }
                }

                if (visited[nx][ny][nc]) {
                    continue;
                }

                queue.add(new Pair(nx, ny, nc, p.count + 1));
                visited[nx][ny][nc] = true;
            }
        }
    }

    private static class Pair {

        int x;
        int y;
        int crush;
        int count;

        public Pair(int x, int y, int crush, int count) {
            this.x = x;
            this.y = y;
            this.crush = crush;
            this.count = count;
        }
    }
}
