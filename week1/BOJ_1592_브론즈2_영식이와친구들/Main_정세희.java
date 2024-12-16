package week1.BOJ_1592_브론즈2_영식이와친구들;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 3 <= N <= 50, 1부터 N까지의 자리
        int M = Integer.parseInt(st.nextToken());   // 1 <= M <= 50, 한 사람이 M번 받으면 게임 끝
        int L = Integer.parseInt(st.nextToken());   // 1 <= L <= N - 1, 공을 받은 횟수가 홀수면 시계 방향 L, 짝수면 반시계 방향 L

        int result = 0;
        int[] toss = new int[N];    // N명 앉아서 게임을 한다
        toss[0] = 1;                // 첫 번째 사람은 일단 공을 받고 시작한다
        int ball = 0;               // 공이 왔다 갔다 한다. 처음 시작 자리는 첫 번째 자리(배열상으로 0번째 인덱스)

        while (toss[ball] < M) {
            if (toss[ball] % 2 == 1) {
                ball = (ball + L) % N;
            } else if (toss[ball] % 2 == 0) {
                ball = (ball - L + N) % N;
            }

            toss[ball] += 1;
            result += 1;
        }

        System.out.println(result);
        br.close();
    }
}
