package week9.BOJ_18116_골드4_로봇조립;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] parent = new int[1111111];
        Arrays.fill(parent, -1);

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            if (cmd == 'I') {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(parent, a, b);
            } else {
                int c = Integer.parseInt(st.nextToken());
                int par = find(parent, c);
                sb.append(-parent[par]).append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static int find(int[] parent, int x) {
        if (parent[x] < 0) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }

    private static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a != b) {
            parent[b] += parent[a];
            parent[a] = b;
        }
    }
}