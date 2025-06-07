package week11.BOJ_1753_골드4_최단경로;

import java.io.*;
import java.util.*;

public class Main_정세희 {

    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        int[] dist = dijkstra(V, graph, K);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] dijkstra(int V, List<List<Node>> graph, int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        Queue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        heap.add(new Node(start, 0));
        dist[start] = 0;
        while (!heap.isEmpty()) {
            Node curr = heap.poll();

            for (Node next : graph.get(curr.index)) {
                int cost = curr.weight + next.weight;
                if (dist[next.index] > cost) {
                    dist[next.index] = cost;
                    heap.add(new Node(next.index, cost));
                }
            }
        }
        return dist;
    }

    private static class Node {

        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}

