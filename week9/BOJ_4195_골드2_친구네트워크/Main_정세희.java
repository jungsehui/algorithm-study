package week9.BOJ_4195_골드2_친구네트워크;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static Map<String, Integer> names;
    private static int[] parent;
    private static int id;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());

            names = new HashMap<>();

            parent = new int[200_200];
            Arrays.fill(parent, -1); // 초기화 (자기 자신이 루트이면서 size = 1)

            id = 0;

            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                int id1 = getIdByName(name1);
                int id2 = getIdByName(name2);

                union(id1, id2);

                sb.append(Math.abs(parent[find(id1)])).append(System.lineSeparator());
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getIdByName(String name) {
        if (!names.containsKey(name)) {
            names.put(name, id++);
        }
        return names.get(name);
    }

    private static int find(int x) {
        if (parent[x] < 0) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] += parent[a];
            parent[a] = b;
        }
    }
}