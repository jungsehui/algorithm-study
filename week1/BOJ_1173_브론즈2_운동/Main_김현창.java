package week1.BOJ_1173_브론즈2_운동;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int answer = 0;
        if (m + T > M) {
            answer = -1;
        } else {
            int X = m;
            while (N > 0) {
                if (X + T <= M) {
                    --N;
                    X += T;
                } else {
                    X = Math.max(X - R, m);
                }
                ++answer;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
