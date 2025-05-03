package week8.BOJ_11723_실버5_집합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static final int INF = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        int S = 0;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x;

            switch (cmd) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    S |= (1 << (x - 1));
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    S &= ~(1 << (x - 1));
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    bw.write(((S & (1 << (x - 1))) > 0 ? 1 : 0) + " \n");
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    S ^= (1 << (x - 1));
                    break;
                case "all":
                    S = (1 << 30) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
