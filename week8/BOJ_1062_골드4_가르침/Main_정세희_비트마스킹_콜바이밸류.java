package week8.BOJ_1062_골드4_가르침;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정세희_비트마스킹_콜바이밸류 {

    private static int N, K;
    private static int answer = 0;
    // private static String[] words;
    // private static char[] comb;
    // private static boolean[] teach = new boolean[26];
    private static int[] wordBm;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // words = new String[N];
        wordBm = new int[N];
        for (int i = 0; i < N; ++i) {
            String word = br.readLine();
            int bm = 0;
            for (char c: word.toCharArray()) {
                bm |= (1 << (c - 'a'));
            }
            wordBm[i] = bm;
        }

        if (K < 5) {
            System.out.println(0);
        } else {
            int teach = 0;
            teach |= (1 << ('a' - 'a'));
            teach |= (1 << ('n' - 'a'));
            teach |= (1 << ('t' - 'a'));
            teach |= (1 << ('i' - 'a'));
            teach |= (1 << ('c' - 'a'));
            dfs(0, teach, 5);
            System.out.println(answer);
        }
        br.close();
    }

    private static void dfs(int index, int teach, int depth) {
        if (depth == K) {
            // 모든 경우의 수
            int count = countReadableWords(teach);
            answer = Math.max(answer, count);
            return;
        }
        for (int i = index; i < 26; ++i) {
            // if (teach[i])
            if ((teach & (1 << i)) > 0)
                continue;
            // teach[i] = true;
            // teach |= (1 << i);
            dfs(i + 1, teach | (1 << i), depth + 1);
            // teach &= ~(1 << i);
        }
    }

    private static int countReadableWords(int teach) {
        int count = 0;
        // for (String word: words) {
        //    boolean readable = true;
        //    for (char c: word.toCharArray()) {
        //       if ((teach & (1 << (c - 'a'))) == 0) {
        //          readable = false;
        //          break;
        //       }
        //    }
        //    if (readable)
        //       ++count;
        // }
        for (int bm: wordBm) {
            if ((teach & bm) == bm) {
                ++count;
            }
        }
        return count;
    }
}
