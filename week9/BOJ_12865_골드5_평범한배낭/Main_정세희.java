package week9.BOJ_12865_골드5_평범한배낭;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int N;
    private static int K;
    private static int[] W;
    private static int[] V;
    private static int[][] memo; // memo[index(현재 몇 번째 물건까지 넣었나, weight(그때 적재된 총 무게)] = value(의 값이 총 가치)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        W = new int[N]; // 물건 개수만큼 크기 할당 ex) W[i] (i + 1) 번째 물건의 무게
        V = new int[N]; // 물건 개수만큼 크기 할당 ex) V[i] --> W[i]번째 물건의 가치
        memo = new int[N + 1][K + 1]; // memo 의 실제 값은 value
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken()); // 물건 무게
            V[i] = Integer.parseInt(st.nextToken()); // 물건 가치
        }

//        bw.write(String.valueOf(topDownBruteForce(0, K)));
        bw.write(String.valueOf(topDownDynamicProgramming(0, K)));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int topDownBruteForce(int index, int weight) {
        if (index == N) {
            return 0;
        }

        int ret = topDownBruteForce(index + 1, weight); // 물건 안 넣는 경우 다음으로 그냥 인덱스만 이동
        if (weight - W[index] >= 0) {
            // 물건 넣는 경우 전체 가능한 무게(weight)에서 현재 해당 물건 무게(W[index])를 빼고(물건 넣은 셈 치는 것)
            // 넣은 물건의 가치(V[index])만큼 더하기
            ret = Math.max(ret, topDownBruteForce(index + 1, weight - W[index]) + V[index]);
        }
        return ret;
    }

    private static int topDownDynamicProgramming(int index, int weight) {
        if (index == N) {
            return 0;
        }

        if (memo[index][weight] != -1) {
            return memo[index][weight];
        }

        int ret = topDownDynamicProgramming(index + 1, weight); // 물건 안 넣는 경우 다음으로 그냥 인덱스만 이동
        if (weight - W[index] >= 0) {
            // 물건 넣는 경우 전체 가능한 무게(weight)에서 현재 해당 물건 무게(W[index])를 빼고(물건 넣은 셈 치는 것)
            // 넣은 물건의 가치(V[index])만큼 더하기
            ret = Math.max(ret, topDownDynamicProgramming(index + 1, weight - W[index]) + V[index]);
        }
        return memo[index][weight] = ret;
    }
}
