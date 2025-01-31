package week3.BOJ_18126_실버2_너구리구구;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_정세희 {

    private static List<List<Node>> graph;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        System.out.println(bfs(N));

        bw.flush();
        bw.close();
        br.close();
    }

    private static long bfs(int N) {
        long[] distance = new long[N + 1];
        Arrays.fill(distance, -1);
        distance[1] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        long maxDistance = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Node nextNode : graph.get(now)) {
                if (distance[nextNode.index] == -1) {
                    queue.add(nextNode.index);
                    distance[nextNode.index] = distance[now] + nextNode.distance;
                    maxDistance = Math.max(maxDistance, distance[nextNode.index]);
                }
            }
        }

        return maxDistance;
    }

    private static class Node {
        int index;
        int distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
