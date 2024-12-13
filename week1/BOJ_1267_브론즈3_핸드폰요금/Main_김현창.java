package week1.BOJ_1267_브론즈3_핸드폰요금;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int youngsik = 0;
        int minsik = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            int price = Integer.parseInt(st.nextToken());
            youngsik += ((price / 30) + 1) * 10;
            minsik += ((price / 60) + 1) * 15;
        }

        if (youngsik > minsik) {
            System.out.println("M " + minsik);
        } else if (minsik > youngsik) {
            System.out.println("Y " + youngsik);
        } else {
            System.out.println("Y M " + youngsik);
        }
        br.close();
    }
}
