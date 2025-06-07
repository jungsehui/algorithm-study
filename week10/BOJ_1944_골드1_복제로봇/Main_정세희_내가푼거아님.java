package week10.BOJ_1944_골드1_복제로봇;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_정세희_내가푼거아님 {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static int N, M, countOfNodes;
    private static boolean[][] isWall;
    private static Node[] nodes;
    private static List<Edge> edges = new ArrayList<>();
    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        countOfNodes = M + 1;

        isWall = new boolean[N][N];
        nodes = new Node[countOfNodes];
        for (int i = 0, idx = 0; i < N; ++i) {
            String line = br.readLine();
            for (int j = 0; j < N; ++j) {
                if (line.charAt(j) == '1') {
                    isWall[i][j] = true;
                } else if (line.charAt(j) == '0') {
                    isWall[i][j] = false;
                } else {
                    nodes[idx++] = new Node(i, j);
                }
            }
        }

        // 문제에서 주어진 그래프 -> Edge 그래프 전처리
        for (int i = 0; i < countOfNodes; ++i) {
            bfs(i);
        }

        // MST - Kruskal
        parent = new int[countOfNodes];
        for (int i = 0; i < countOfNodes; ++i) {
            parent[i] = i;
        }

        edges.sort((o1, o2) -> Integer.compare(o1.w, o2.w));

        int answer = 0;
        int link = 0;
        for (Edge edge : edges) {
            if (find(edge.u) == find(edge.v)) {
                continue;
            }
            union(edge.u, edge.v);
            answer += edge.w;
            ++link;
        }
        System.out.println(link == countOfNodes - 1 ? answer : -1);
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

    private static void bfs(int index) {
        Node start = nodes[index];
        Queue<Node> queue = new ArrayDeque<>();
        int[][] visited = new int[N][N];
        queue.add(start);
        visited[start.x][start.y] = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; ++i) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if (isWall[nx][ny])
                    continue;
                if (visited[nx][ny] > 0)
                    continue;
                queue.add(new Node(nx, ny));
                visited[nx][ny] = visited[node.x][node.y] + 1;
            }
        }

        for (int i = index + 1; i < countOfNodes; ++i) {
            Node node = nodes[i];
            if (visited[node.x][node.y] == 0)
                continue;
            Edge edge = new Edge(i, index, visited[nodes[i].x][nodes[i].y] - 1);
            edges.add(edge);
        }
    }

    private static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
