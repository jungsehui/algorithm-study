package week6.BOJ_2512_실버2_예산;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] budgets = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budgets);

        int M = Integer.parseInt(br.readLine());

        int max = budgets[budgets.length - 1];

        int answer = search(budgets, M, max);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int search(int[] arr, int total, int limit) {
        int left = 0;
        int right = limit;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int budget : arr) {
                sum += Math.min(budget, mid);
            }

            if (sum <= total) {
                result = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result - 1;
    }

    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (target <= arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
}