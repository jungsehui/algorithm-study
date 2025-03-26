package week5.BOJ_2531_실버1_회전초밥;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int[] sushi;
    private static int[] eated;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        eated = new int[d + 1];

        // 처음에 먹은 초밥 결정
        int eatCount = 0;
        for (int i = 0; i < k; i++) {
            if (eated[sushi[i]] == 0) {
                eatCount++;
            }
            eated[sushi[i]]++;
        }

        // 최대 초밥 종류 수 결정
        int max = eatCount;
        if (max <= eatCount) {
            if (eated[c] == 0) {
                max = eatCount + 1;
            } else {
                max = eatCount;
            }
        }

        for (int i = 1; i < N; i++) {
            if (max <= eatCount) {
                if (eated[c] == 0) {
                    max = eatCount + 1;
                } else {
                    max = eatCount;
                }
            }

            int next = (i + k - 1) % N;
            if (eated[sushi[next]] == 0) {
                eatCount++;
            }
            eated[sushi[next]]++;

            int prev = (i - 1 + N) % N;
            eated[sushi[prev]]--;
            if (eated[sushi[prev]] == 0) {
                eatCount--;
            }
        }

        if (max <= eatCount) {
            if (eated[c] == 0) {
                max = eatCount + 1;
            } else {
                max = eatCount;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
