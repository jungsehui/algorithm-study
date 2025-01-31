package week3.BOJ_2667_실버1_단지번호붙이기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_정세희 {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static int N;
    private static int[][] graph;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    results.add(bfs(i, j));
                }
            }
        }

        Collections.sort(results);

        System.out.println(results.size());

        for (int result : results) {
            System.out.println(result);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int x, int y) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;

        int houseCount = 1;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (graph[nx][ny] != 1 || visited[nx][ny]) {
                    continue;
                }

                queue.add(new Pair(nx, ny));
                visited[nx][ny] = true;
                houseCount += 1;
            }
        }

        return houseCount;
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
