package week1.BOJ_1668_브론즈2_트로피진열;

import java.io.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] trophy = new int[N];
        for (int i = 0; i < N; ++i) {
            trophy[i] = Integer.parseInt(br.readLine());
        }

        int left = 0;
        int right = 0;
        for (int i = 0, h = 0; i < N; ++i) {
            if (trophy[i] > h) {
                ++left;
                h = trophy[i];
            }
        }
        for (int i = N - 1, h = 0; i >= 0; --i) {
            if (trophy[i] > h) {
                ++right;
                h = trophy[i];
            }
        }

        System.out.println(left + "\n" + right);
        br.close();
    }
}
