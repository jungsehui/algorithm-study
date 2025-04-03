package week6.BOJ_26168_실버4_배열전체탐색하기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                long target = Long.parseLong(st.nextToken());
                sb.append(n - lowerBound(A, 0, n - 1, target))
                        .append(System.lineSeparator());
            } else if (type == 2) {
                long target = Long.parseLong(st.nextToken());
                sb.append(n - upperBound(A, 0, n - 1, target) - 1)
                        .append(System.lineSeparator());
            } else if (type == 3){
                long I = Long.parseLong(st.nextToken());
                long J = Long.parseLong(st.nextToken());
                sb.append(upperBound(A, 0, n - 1, J) - lowerBound(A, 0, n - 1, I) + 1)
                        .append(System.lineSeparator());
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int upperBound(long[] arr, int left, int right, long target) {
        while (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] <= target) {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private static int lowerBound(long[] arr, int left, int right, long target) {
        while (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
}