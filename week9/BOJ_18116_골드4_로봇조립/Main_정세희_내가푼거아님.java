package week9.BOJ_18116_골드4_로봇조립;

import java.io.*;
import java.util.StringTokenizer;

public class Main_정세희_내가푼거아님 {

    private static final int MAX = 1_000_001;
    private static int[] parent = new int[MAX];
    private static int[] size = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < MAX; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("I")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else if (cmd.equals("Q")) {
                int c = Integer.parseInt(st.nextToken());
                bw.write(size[find(c)] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
    }
}
