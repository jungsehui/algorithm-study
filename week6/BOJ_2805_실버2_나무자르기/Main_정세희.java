package week6.BOJ_2805_실버2_나무자르기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 가져 가려고 하는 나무의 길이(적어도 M미터의 나무를 집에 가져 감)

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);

        long result = upperBound(trees, M);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static long upperBound(int[] arr, int target) {
        long left = 0;
        long right = arr[arr.length - 1];

        while (left <= right) {
            long mid = right + (left - right) / 2;

            long sum = 0;
            for (long tree : arr) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            if (sum < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}