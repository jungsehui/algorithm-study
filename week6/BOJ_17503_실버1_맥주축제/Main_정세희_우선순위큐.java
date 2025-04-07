package week6.BOJ_17503_실버1_맥주축제;

import java.io.*;
import java.util.*;

public class Main_정세희_우선순위큐 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 마실 맥주 수
        long M = Long.parseLong(st.nextToken());  // 최소 선호도 합
        int K = Integer.parseInt(st.nextToken()); // 전체 맥주 수

        List<Beer> beers = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            beers.add(new Beer(v, c));
        }

        // 도수 기준 오름차순 정렬
        beers.sort(Comparator.comparingInt(b -> b.c));

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 낮은 선호도 우선 제거
        long total = 0;
        int result = -1;

        for (Beer beer : beers) {
            pq.offer(beer.v);
            total += beer.v;

            if (pq.size() > N) {
                total -= pq.poll();
            }

            if (pq.size() == N && total >= M) {
                result = beer.c;
                break;
            }
        }

        bw.write(result + System.lineSeparator());
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Beer {

        int v; // 선호도
        int c; // 도수

        public Beer(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
