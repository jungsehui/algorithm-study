package week5.BOJ_25708_실버2_만남의광장;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] area = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] rowSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                rowSum[i] += area[i][j];
            }
        }

        int[] colSum = new int[M + 1];
        for (int j = 1; j <= M; j++) {
            for (int i = 1; i <= N; i++) {
                colSum[j] += area[i][j];
            }
        }

        int result = Integer.MIN_VALUE;
        for (int x1 = 0; x1 < N; x1++) {
            for (int x2 = x1 + 1; x2 < N; x2++) {
                for (int y1 = 0; y1 < M; y1++) {
                    for (int y2 = y1 + 1; y2 < M; y2++) {
                        int target = 0;
                        target += rowSum[x1 + 1];
                        target += rowSum[x2 + 1];
                        target += colSum[y1 + 1];
                        target += colSum[y2 + 1];
                        target -= area[x1 + 1][y1 + 1] + area[x2 + 1][y1 + 1] + area[x1 + 1][y2 + 1] + area[x2 + 1][y2 + 1];
                        target += (x2 - x1 - 1) * (y2 - y1 - 1);
                        result = Math.max(result, target);
                    }
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
