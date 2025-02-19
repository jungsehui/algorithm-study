package week3.BOJ_5014_실버1_스타트링크;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int[] dx = {1, -1, 0, 0};

    private static final int MAX = 1024 * 1000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken()); // 건물 층 수
        int S = Integer.parseInt(st.nextToken()); // 타겟 층
        int G = Integer.parseInt(st.nextToken()); // 현재 층
        int U = Integer.parseInt(st.nextToken()); // 올라가기
        int D = Integer.parseInt(st.nextToken()); // 내려가기

        int[] visited = new int[F + 1];

        int result = bfs(F, S, G, U, D, visited);

        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int F, int S, int G, int U, int D, int[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(S);
        visited[S] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == G) {
                return visited[now] - 1;
            }

            int[] next = {now + U, now - D};

            for (int i : next) {
                if (i < 1 || i > F || visited[i] != 0) {
                    continue;
                }

                queue.add(i);
                visited[i] = visited[now] + 1;
            }
        }

        if (visited[G] == 0) {
            return -1;
        }

        return visited[G] - 1;
    }
}
