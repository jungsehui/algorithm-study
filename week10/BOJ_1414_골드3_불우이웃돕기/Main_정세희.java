package week10.BOJ_1414_골드3_불우이웃돕기;

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

        List<Edge> edges = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        int total = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = line.charAt(j);
                int cost = toCost(ch);
                total += cost;
                if (cost > 0 && i != j) {
                    edges.add(new Edge(i, j, cost));
                }
            }
        }

        parent = new int[N];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        edges.sort(Comparator.comparingInt(edge -> edge.cost));

        int mst = 0;
        int count = 0;
        for (Edge edge : edges) {
            if (find(edge.from) == find(edge.to)) {
                continue;
            }
            union(edge.from, edge.to);
            mst += edge.cost;
            count++;
        }

        if (count == N - 1) {
            bw.write(String.valueOf(total - mst)); // 기부 가능한 길이
        } else {
            bw.write("-1"); // 모두 연결 불가
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int toCost(char c) {
        if ('a' <= c && c <= 'z') {
            return c - 'a' + 1;
        }
        if ('A' <= c && c <= 'Z') {
            return c - 'A' + 27;
        }
        return 0;
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return false;
        }
        parent[b] = a;
        return true;
    }

    private static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
