package week11.BOJ_16118_골드1_달빛여우;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_정세희 {

    private static int INF = Integer.MAX_VALUE;
    private static int N;
    private static int M;

    private static int[][] map;
    private static int[][] dist;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) * 2;
            graph.get(a).add(new Node(b, d));
            graph.get(b).add(new Node(a, d));
        }

        int[] fox = dijkstraFox(graph);
        int[] wolf = dijkstraWolf(graph);

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (fox[i] < wolf[i]) {
                result++;
            }
        }

        System.out.println(result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] dijkstraFox(List<List<Node>> graph) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (dist[curr.to] < curr.cost) {
                continue;
            }

            for (Node next : graph.get(curr.to)) {
                int cost = curr.cost + next.cost;
                if (dist[next.to] > cost) {
                    dist[next.to] = cost;
                    pq.add(new Node(next.to, cost));
                }
            }
        }

        return dist;
    }

    private static int[] dijkstraWolf(List<List<Node>> graph) {
        int[][] dist = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }
        Queue<Wolf> pq = new PriorityQueue<>();
        pq.add(new Wolf(1, 0, 0));
        dist[1][0] = 0;

        while (!pq.isEmpty()) {
            Wolf curr = pq.poll();
            if (dist[curr.to][curr.run] < curr.cost) {
                continue;
            }

            for (Node next : graph.get(curr.to)) {
                int cost = curr.run == 0 ? next.cost / 2 : next.cost * 2;
                int weight = curr.cost + cost;
                int run = 1 - curr.run;

                if (dist[next.to][run] > weight) {
                    dist[next.to][run] = weight;
                    pq.add(new Wolf(next.to, weight, run));
                }
            }
        }

        int[] _dist = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            _dist[i] = Math.min(dist[i][0], dist[i][1]);
        }
        return _dist;
    }

    private static class Node implements Comparable<Node> {

        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    private static class Wolf implements Comparable<Wolf> {

        int to;
        int cost;
        int run;

        public Wolf(int to, int cost, int run) {
            this.to = to;
            this.cost = cost;
            this.run = run;
        }

        @Override
        public int compareTo(Wolf o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
