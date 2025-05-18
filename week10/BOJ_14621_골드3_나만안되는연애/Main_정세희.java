package week10.BOJ_14621_골드3_나만안되는연애;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학교 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수

        char[] types = new char[N + 1];
        st = new StringTokenizer(br.readLine()); // 남초, 여초 판별 M, W
        for (int i = 1; i <= N; i++) {
            types[i] = st.nextToken().charAt(0);
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (types[u] != types[v]) {
                edges.add(new Edge(u, v, d));
            }
        }

        edges.sort(Comparator.comparingInt(e -> e.d));
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int cost = 0;
        int count = 0;

        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                cost += edge.d;
                count++;
            }
        }

        bw.write(count == N - 1 ? String.valueOf(cost) : "-1");
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
        if (a != b) {
            parent[b] = a;
        }
    }

    private static class Edge {
        int u;
        int v;
        int d;

        public Edge(int u, int v, int d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }
    }
}
