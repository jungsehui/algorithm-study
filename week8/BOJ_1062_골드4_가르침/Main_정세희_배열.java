package week8.BOJ_1062_골드4_가르침;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정세희_배열 {

    private static int N, K;
    private static int answer = 0;
    private static String[] words;
    // private static char[] comb;
    private static boolean[] teach = new boolean[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        for (int i = 0; i < N; ++i) {
            words[i] = br.readLine();
        }

        if (K < 5) {
            System.out.println(0);
        } else {
            teach['a' - 'a'] = true;
            teach['n' - 'a'] = true;
            teach['t' - 'a'] = true;
            teach['i' - 'a'] = true;
            teach['c' - 'a'] = true;
            dfs(0, 5);
            System.out.println(answer);
        }
        br.close();
    }

    private static void dfs(int index, int depth) {
        if (depth == K) {
            // 모든 경우의 수
            int count = countReadableWords();
            answer = Math.max(answer, count);
            return;
        }
        for (int i = index; i < 26; ++i) {
            if (teach[i])
                continue;
            teach[i] = true;
            dfs(i + 1, depth + 1);
            teach[i] = false;
        }
    }

    private static int countReadableWords() {
        int count = 0;
        for (String word: words) {
            boolean readable = true;
            for (char c: word.toCharArray()) {
                if (!teach[c - 'a']) {
                    readable = false;
                    break;
                }
            }
            if (readable)
                ++count;
        }
        return count;
    }
}
