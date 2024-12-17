package week1.BOJ_1668_브론즈2_트로피진열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Integer> trophies = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            trophies.add(Integer.parseInt(br.readLine()));
        }

        // 피벗 활용 느낌으로 풀이
        // 자바 11에서는 컬렉션에서 getFirst()가 안 된다 ..
        int leftCount = 1;
        int leftSidePivot = trophies.get(0);
        for (int i = 1; i < N; i++) {
            if (trophies.get(i) > leftSidePivot) {
                leftCount += 1;
                leftSidePivot = trophies.get(i);
            }
        }

        Collections.reverse(trophies);

        int rightCount = 1;
        int rightSidePivot = trophies.get(0);
        for (int i = 1; i < N; i++) {
            if (trophies.get(i) > rightSidePivot) {
                rightCount += 1;
                rightSidePivot = trophies.get(i);
            }
        }

        System.out.println(leftCount);
        System.out.println(rightCount);
        br.close();
    }
}
