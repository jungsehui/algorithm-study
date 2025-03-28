package week6.BOJ_19598_골드5_최소회의실개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        Pair[] meeting = new Pair[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meeting);

        pq.offer(meeting[0].end);

        for (int i = 1; i < N; i++) {
            if (meeting[i].start >= pq.peek()) {
                pq.poll();
            }

            pq.offer(meeting[i].end);
        }

        System.out.println(pq.size());
    }

    private static class Pair implements Comparable<Pair>{
        int start;
        int end;

        public Pair (int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair next) {
            if (this.start == next.start) {
                return this.end - next.end;
            } else {
                return this.start - next.start;
            }
        }
    }
}
