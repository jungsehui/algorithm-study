package week2.BOJ_18429_실버3_근손실;

import java.io.*;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int N;
    private static int K;
    private static int count;
    private static int[] kit;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N일 간 운동 플랜: 중량이 500보다 작아지면 안 된다.
        // K만큼 하루마다 중량이 감소한다.
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kit = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);

        bw.write(count + System.lineSeparator());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int day, int weight) {
        if (day == N) {
            count += 1;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int nextDayWeight = weight + kit[i] - K;
                if (nextDayWeight >= 500) {
                    visited[i] = true;
                    dfs(day + 1, nextDayWeight);
                    visited[i] = false;
                }
            }
        }
    }
}
