package week5.BOJ_14476_골드2_최대공약수하나빼기;

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

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] left = new int[N + 1];
        int[] right = new int[N + 1];
        for (int i = 0; i < N; i++) {
            left[i + 1] = gcd(left[i], arr[i]);
        }
        for (int i = N - 1; i > 0; i--) {
            right[i] = gcd(right[i + 1], arr[i]);
        }

        int answerGcd = -1;
        int answerK = -1;
        for (int i = 1; i <= N; i++) {
            int gcd = gcd(left[i - 1], right[i]);
            int k = arr[i - 1];
            if (k % gcd == 0) {
                continue;
            }
            if (answerGcd < 0) {
                answerGcd = gcd;
                answerK = k;
            }
        }

        System.out.println(answerGcd + " " + answerK);

        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
