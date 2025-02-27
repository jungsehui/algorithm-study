package week4.BOJ_10026_골드5_적록색약;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        char[][] graph = new char[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        char[][] graphForDisabled = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graphForDisabled[i][j] = graph[i][j];

                if (graphForDisabled[i][j] == 'G') {
                    graphForDisabled[i][j] = 'R';
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += bfs(graph, visited, N, i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        int countForDisabled = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                countForDisabled += bfs(graphForDisabled, visited, N, i, j);
            }
        }

        System.out.println(count + " " + countForDisabled);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(char[][] graph, boolean[][] visited, int N, int x, int y) {
        if (visited[x][y]) {
            return 0;
        }

        int count = 1;

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;
        char color = graph[x][y];

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (!visited[nx][ny] && graph[nx][ny] == color) {
                    queue.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return count;
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