package week5.BOJ_12847_실버3_꿀아르바이트;

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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] wages = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            wages[i] = Integer.parseInt(st.nextToken());
        }

        long[] copyOfWages = new long[n + 1];
        copyOfWages[1] = wages[1];
        for (int i = 1; i < n; i++) {
            copyOfWages[i + 1] = copyOfWages[i] + wages[i + 1];
        }

        long max = 0;
        for (int i = m; i <= n; i++) {
            long target = copyOfWages[i] - copyOfWages[i - m];
            max = Math.max(max, target);
        }

        System.out.println(max);

        bw.flush();
        bw.close();
        br.close();
    }
}
