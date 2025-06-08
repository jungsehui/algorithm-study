package week11.BOJ_1800_골드1_인터넷설치;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_정세희 {

    private static int INF = Integer.MAX_VALUE;
    private static int N;
    private static int P;
    private static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int maxCost = 0;
        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, d));
            graph.get(b).add(new Node(a, d));
            maxCost = Math.max(maxCost, d);
        }

        int left = 0;
        int right = maxCost;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (dijkstraFox(graph, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean dijkstraFox(List<List<Node>> graph, int bound) {
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
                int cost = curr.cost + (next.cost > bound ? 1 : 0);
                if (dist[next.to] > cost) {
                    dist[next.to] = cost;
                    pq.add(new Node(next.to, cost));
                }
            }
        }

        return dist[N] <= K;
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
}
