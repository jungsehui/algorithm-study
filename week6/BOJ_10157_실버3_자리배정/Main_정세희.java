package week6.BOJ_10157_실버3_자리배정;

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
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[][] snail = makeSnail(R, C);
        int[] result = find(snail, K);

        bw.write(String.valueOf(result == null ? 0 : (result[1] + " " + result[0])));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] find(int[][] arr, int K) {
        int r = arr.length;
        int c = arr[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == K) {
                    return new int[]{r - i, j + 1};
                }
            }
        }
        return null;
    }

    private static int[][] makeSnail(int R, int C) {
        int[][] snail = new int[R][C];
        int top = 0;
        int bottom = R - 1;
        int left = 0;
        int right = C - 1;
        int number = 1;
        int n = R * C;

        while (number <= n) {
            for (int i = bottom; i >= top; i--) {
                snail[i][left] = number++;
            }
            left++;

            if (number <= n) {
                for (int j = left; j <= right; j++) {
                    snail[top][j] = number++;
                }
                top++;
            }

            if (number <= n) {
                for (int i = top; i <= bottom; i++) {
                    snail[i][right] = number++;
                }
                right--;
            }

            if (number <= n) {
                for (int j = right; j >= left; j--) {
                    snail[bottom][j] = number++;
                }
                bottom--;
            }
        }
        return snail;
    }
}
