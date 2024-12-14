package week1;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 분
        int m = Integer.parseInt(st.nextToken());   // 초기 맥박 (맥박 최소 한도)
        int M = Integer.parseInt(st.nextToken());   // 최대 맥박
        int T = Integer.parseInt(st.nextToken());   // 운동 시 맥박 증가량
        int R = Integer.parseInt(st.nextToken());   // 휴식 시 맥박 감소량

        int result = 0;

        if (m + T > M) {
            result = -1;
        } else {
            int X = m;  // 운동 시작 시 맥박
            while (N > 0) {
                if (X + T <= M) {   // 운동 가능 시 운동 선택 (최대 맥박 M을 넘지 않는다면)
                    N -= 1;         // 운동했으니 1분 감소
                    X += T;         // 운동했으니 맥박 증가 (운동 시작 맥박(X)에 운동 시 맥박 증가량(T)을 더해 준다)
                } else {            // 그렇지 않으면 휴식 선택
                    X = Math.max(X - R, m); // 휴식 선택 시 현재 맥박 X에서 휴식 시 맥박 감소량(R)을 뺀 것과 최소 맥박(m) 중 더 큰 것 선택
                }
                result += 1;
            }
        }

        System.out.println(result);
        br.close();
    }
}
