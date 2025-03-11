package week5.BOJ_11659_실버3_구간합구하기4;

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

        long[] numbers = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long[] copyOfNumbers = new long[N + 1];
        copyOfNumbers[1] = numbers[1];
        for (int i = 1; i < N; i++) {
            copyOfNumbers[i + 1] = copyOfNumbers[i] + numbers[i + 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(copyOfNumbers[end] - copyOfNumbers[start - 1]).append(System.lineSeparator());
//            System.out.println(copyOfNumbers[end] - copyOfNumbers[start - 1]);
        }

        System.out.println(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
