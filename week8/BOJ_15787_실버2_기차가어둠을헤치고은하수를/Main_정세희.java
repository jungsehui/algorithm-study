package week8.BOJ_15787_실버2_기차가어둠을헤치고은하수를;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int INF = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 기차 수
        int M = Integer.parseInt(st.nextToken()); // 명령 수

        int[] trains = new int[N + 1];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1: { // 1 i x
                    int x = Integer.parseInt(st.nextToken());
                    trains[i] |= (1 << (x - 1));
                    break;
                }
                case 2: { // 2 i x
                    int x = Integer.parseInt(st.nextToken());
                    trains[i] &= ~(1 << (x - 1));
                    break;
                }
                case 3: // 3 i
                    trains[i] <<= 1;
                    trains[i] &= ~(1 << 20); // 21번째 비트 제거 (20번 좌석 초과 제거)
                    break;
                case 4: // 4 i
                    trains[i] >>= 1;
                    break;
            }
        }

        Set<Integer> uniques = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            uniques.add(trains[i]);
        }

        bw.write(String.valueOf(uniques.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}
