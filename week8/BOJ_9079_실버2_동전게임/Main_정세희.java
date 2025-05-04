package week8.BOJ_9079_실버2_동전게임;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int INF = Integer.MAX_VALUE >> 1;

    private static int[] flips = {
            0b000000111,
            0b000111000,
            0b111000000,
            0b001001001,
            0b010010010,
            0b100100100,
            0b100010001,
            0b001010100
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int start = 0;

            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    if (st.nextToken().equals("T")) {
                        start |= (1 << ((i * 3) + j));
                    }
                }
            }

            bw.write(bfs(start) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int start) {
        boolean[] visited = new boolean[512];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int state = current[0];
            int depth = current[1];

            if (state == 0 || state == 511) {
                return depth;
            }

            for (int flip : flips) {
                int next = state ^ flip;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, depth + 1});
                }
            }
        }

        return -1;
    }
}
