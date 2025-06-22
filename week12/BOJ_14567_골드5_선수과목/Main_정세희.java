package week12.BOJ_14567_골드5_선수과목;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_정세희 {

    private static final int INF = 123456789;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            inDegree[B]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] semester = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                semester[i] = 1;
            }
        }

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int x = queue.poll();
            answer.add(x);

            for (int next : graph.get(x)) {
                semester[next] = Math.max(semester[next], semester[x] + 1);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; ++i) {
            sb.append(semester[i]).append(" ");
        }
        System.out.println(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
