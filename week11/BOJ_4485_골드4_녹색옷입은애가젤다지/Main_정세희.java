package week11.BOJ_4485_골드4_녹색옷입은애가젤다지;

import java.io.*;
import java.util.*;

public class Main_정세희 {

    private static int INF = Integer.MAX_VALUE;
    private static int N;

    private static int[][] map;
    private static int[][] dist;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int problemCount = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }

            sb.append("Problem ").append(problemCount++).append(": ").append(dijkstra()).append(System.lineSeparator());
        }

        System.out.println(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dijkstra() {
        Queue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        heap.add(new Node(0, 0, map[0][0]));
        dist[0][0] = map[0][0];

        while (!heap.isEmpty()) {
            Node curr = heap.poll();

            if (curr.cost > dist[curr.x][curr.y]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                int newCost = dist[curr.x][curr.y] + map[nx][ny];
                if (newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;
                    heap.add(new Node(nx, ny, newCost));
                }
            }
        }
        return dist[N - 1][N - 1];
    }

    private static class Node {

        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}

