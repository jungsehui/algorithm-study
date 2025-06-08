package week11.BOJ_17270_골드3_연예인은힘들어;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_정세희 {

    private static int INF = Integer.MAX_VALUE;
    private static int V;
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
        V = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int J = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] distJ = dijkstra(graph, V, J);
        int[] distS = dijkstra(graph, V, S);

        int minTotal = INF;
        List<Integer> candidates = new ArrayList<>();

        // 1단계: 최소 거리 합을 갖는 후보 찾기
        for (int i = 1; i <= V; i++) {
            if (i == J || i == S) continue;
            if (distJ[i] == INF || distS[i] == INF) continue;

            int total = distJ[i] + distS[i];
            if (total < minTotal) {
                minTotal = total;
                candidates.clear();
                candidates.add(i);
            } else if (total == minTotal) {
                candidates.add(i);
            }
        }

        // 2단계: 조건 3 만족하는 후보 중 지헌이가 더 빨리 도착하는 곳 중에서 가장 가까운 곳 고르기
        int result = -1;
        int minDistJ = INF;
        for (int i : candidates) {
            if (distJ[i] > distS[i]) {
                continue; // 지헌이가 늦으면 안 됨
            }

            if (minDistJ > distJ[i]) {
                minDistJ = distJ[i];
                result = i;
            } else if (distJ[i] == minDistJ && i < result) {
                result = i;
            }
        }

        System.out.println(result);

        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] dijkstra(List<List<Node>> graph, int n, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        Queue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        heap.add(new Node(start, 0));
        dist[start] = 0;

        while (!heap.isEmpty()) {
            Node curr = heap.poll();

            if (dist[curr.index] < curr.cost) {
                continue;
            }

            for (Node next : graph.get(curr.index)) {
                int cost = curr.cost + next.cost;
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
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
