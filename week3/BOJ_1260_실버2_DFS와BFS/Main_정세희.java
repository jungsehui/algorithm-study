package week3.BOJ_1260_실버2_DFS와BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_정세희 {

    private static int N;
    private static int M;
    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        StringBuilder sb = new StringBuilder();

        dfs(V, sb);

        sb.append(System.lineSeparator());
        Arrays.fill(visited, false);

        bfs(V, sb);

        System.out.println(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, StringBuilder sb) {
        sb.append(x).append(" ");
        visited[x] = true;

        for (int next : graph.get(x)) {
            if (!visited[next]) {
                dfs(next, sb);
            }
        }
    }

    private static void bfs(int x, StringBuilder sb) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
