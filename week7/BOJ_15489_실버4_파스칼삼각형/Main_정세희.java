package week7.BOJ_15489_실버4_파스칼삼각형;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int MAX = 30;
    private static int[][] pascal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        pascal = new int[MAX + 1][MAX + 1];
        buildPascal();

        int sum = 0;
        for (int i = 0; i < W; i++) { // 총 W번 반복
            for (int j = 0; j <= i; j++) { // 각 줄마다 j = 0부터 i까지 (왼쪽에서 오른쪽으로 확장)
                sum += pascal[(R - 1) + i][(C - 1) + j]; // (R + i)번째 줄, (C + j)번째 수
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void buildPascal() {
        for (int i = 0; i <= MAX; i++) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
    }
}
