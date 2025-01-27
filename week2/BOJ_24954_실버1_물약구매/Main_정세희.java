package week2.BOJ_24954_실버1_물약구매;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int[] potion;
    private static boolean[] visited;
    private static int result = Integer.MAX_VALUE;
    private static List<Discount>[] discounts;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        potion = new int[N];
        visited = new boolean[N];
        discounts = new List[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            potion[i] = Integer.parseInt(st.nextToken());
            discounts[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(br.readLine());

            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                int target = Integer.parseInt(st.nextToken()) - 1;
                int discount = Integer.parseInt(st.nextToken());
                discounts[i].add(new Discount(target, discount));
            }
        }

        perm(0, 0, N);

        bw.write(String.valueOf(result) + System.lineSeparator());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void perm(int index, int coin, int N) {
        if (coin >= result) {
            return;
        }

        if (index == N) {
            result = Math.min(result, coin);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            for (Discount d : discounts[i]) {
                potion[d.index] -= d.discount;
            }

            perm(index + 1, coin + (potion[i] <= 0 ? 1 : potion[i]), N);

            for (Discount d : discounts[i]) {
                potion[d.index] += d.discount;
            }

            visited[i] = false;
        }
    }

    static class Discount {

        int index;
        int discount;

        public Discount(int index, int discount) {
            this.index = index;
            this.discount = discount;
        }
    }
}
