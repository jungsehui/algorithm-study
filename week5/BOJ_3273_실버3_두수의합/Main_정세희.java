package week5.BOJ_3273_실버3_두수의합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        Arrays.sort(a);

        long result = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = a[left] + a[right];

            if (sum == x) {
                result++;
                left++;
                right--;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
