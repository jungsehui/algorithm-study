package week8.BOJ_1062_골드4_가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정세희 {

    static int N, K;
    static int[] words;
    static int max = 0;

    // 'a','n','t','i','c' 필수
    static int baseMask = (1 << ('a' - 'a')) |
            (1 << ('n' - 'a')) |
            (1 << ('t' - 'a')) |
            (1 << ('i' - 'a')) |
            (1 << ('c' - 'a'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }

        words = new int[N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String core = line.substring(4, line.length() - 4); // "anta" + core + "tica"
            int mask = 0;
            for (char c : core.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            words[i] = mask;
        }

        dfs(0, 0, baseMask);
        System.out.println(max);
    }

    // depth: 선택한 글자 수, idx: 현재 선택할 글자 인덱스
    static void dfs(int depth, int idx, int mask) {
        if (depth == K - 5) {
            int count = 0;
            for (int word : words) {
                if ((word & ~mask) == 0) { // word에 mask 외의 문자가 없으면 읽을 수 있음
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if ((baseMask & (1 << i)) != 0) continue; // 이미 배운 글자

            dfs(depth + 1, i + 1, mask | (1 << i));
        }
    }
}
