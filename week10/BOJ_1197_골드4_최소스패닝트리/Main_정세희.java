package week10.BOJ_1197_골드4_최소스패닝트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges, Comparator.comparingInt(edge -> edge.c));

        int answer = 0;
        for (Edge edge : edges) {
            if (find(edge.a) == find(edge.b)) {
                continue;
            }
            union(edge.a, edge.b);
            answer += edge.c;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
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
        int a;
        int b;
        int c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
