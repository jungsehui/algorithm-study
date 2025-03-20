package week5.BOJ_2559_실버3_수열;

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
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temp[i];
        }

        int result = sum;
        for (int i = K; i < N; i++) {
            sum += temp[i];
            sum -= temp[i - K];
            result = Math.max(result, sum);
        }

        System.out.println(result);

        bw.flush();
        bw.close();
        br.close();
    }
}
