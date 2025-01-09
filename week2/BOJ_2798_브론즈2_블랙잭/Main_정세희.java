package week2.BOJ_2798_브론즈2_블랙잭;

import java.io.*;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int N;
    private static int M;
    private static int result = 0;
    private static int[] deck;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N일 간 운동 플랜: 중량이 500보다 작아지면 안 된다.
        // K만큼 하루마다 중량이 감소한다.
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        deck = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            deck[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        bw.write(result + System.lineSeparator());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth, int next, int sum) {
        if (depth == 3) {
            if (sum <= M) {
                result = Math.max(result, sum);
            }
            return;
        }

        for (int i = next; i < N; i++) {
            dfs(depth + 1, i + 1, sum + deck[i]);
        }
    }
}
