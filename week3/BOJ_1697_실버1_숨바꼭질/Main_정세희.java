package week3.BOJ_1697_실버1_숨바꼭질;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static final int MAX = 1024 * 1000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[MAX];

        int result = bfs(N, K, visited);

        System.out.println(result);

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int N, int K, int[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                break;
            }

            int[] next = {now - 1, now + 1, now * 2};

            for (int i : next) {
                if (i < 0 || i >= MAX || visited[i] != 0) {
                    continue;
                }

                queue.add(i);
                visited[i] = visited[now] + 1;
            }
        }

        return visited[K] - 1;
    }
}
