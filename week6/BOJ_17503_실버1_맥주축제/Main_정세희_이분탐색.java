package week6.BOJ_17503_실버1_맥주축제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정세희_이분탐색 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Pair[] beer = new Pair[K];
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine());
            beer[i] = new Pair();
            beer[i].v = Integer.parseInt(st.nextToken());
            beer[i].c = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(beer, (o1, o2) -> Integer.compare(o2.v, o1.v));

        long left = 0;
        long right = 2_222_222_222L;
        long answer = -1;
        while (left <= right) {
            long mid = (left + right) >> 1; // 비트 연산
            int x = test(beer, N, mid);
            if (x >= M) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
        br.close();
    }

    // 현재 간 레벨
    private static int test(Pair[] beer, int N, long parameter) {
        int count = 0; // 맥주 몇 번 마셨는지
        int total = 0; // 선호도 총합
        for (Pair b: beer) {
            if (b.c > parameter) {
                continue;
            }
            count++;
            total += b.v;
            if (count == N) {
                break;
            }
        }
        return count == N ? total : 0;
    }

    private static class Pair {
        int v;
        int c;
    }
}
