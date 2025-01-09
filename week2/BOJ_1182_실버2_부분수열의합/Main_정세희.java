package week2.BOJ_1182_실버2_부분수열의합;

import java.io.*;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int N;
    private static int S;
    private static int count;
    private static int[] integer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N일 간 운동 플랜: 중량이 500보다 작아지면 안 된다.
        // K만큼 하루마다 중량이 감소한다.
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        integer = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            integer[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0) {
            count -= 1;
        }

        bw.write(count + System.lineSeparator());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                count += 1;
            }
            return;
        }

        dfs(depth + 1, sum);
        dfs(depth + 1, sum + integer[depth]);
    }
}
