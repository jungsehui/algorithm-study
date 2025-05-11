package week9.BOJ_4195_골드2_친구네트워크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_정세희_내가푼거아님 {
    private static int[] parent;
    private static int[] size;
    private static Map<String, Integer> nameToId;
    private static int id;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());

            parent = new int[F * 2];
            size = new int[F * 2];
            nameToId = new HashMap<>();
            id = 0;

            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                int id1 = getId(name1);
                int id2 = getId(name2);

                union(id1, id2);
                sb.append(size[find(id1)]).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    private static int getId(String name) {
        if (!nameToId.containsKey(name)) {
            nameToId.put(name, id++);
        }
        return nameToId.get(name);
    }

    private static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
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
