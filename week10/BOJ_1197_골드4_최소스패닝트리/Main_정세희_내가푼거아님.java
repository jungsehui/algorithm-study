package week10.BOJ_1197_골드4_최소스패닝트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정세희_내가푼거아님 {

    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        // 1. 가중치 기준 정렬 (전처리)
        Arrays.sort(edges, Comparator.comparingInt(o -> o.c));

        // 2. Kruskal
        int answer = 0;
        for (Edge edge: edges) { // weight 작은 순으로
            if (find(edge.a) == find(edge.b))
                continue;
            union(edge.a, edge.b);
            answer += edge.c;
        }
        System.out.println(answer);
        br.close();
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static class Edge {
        int a, b, c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}