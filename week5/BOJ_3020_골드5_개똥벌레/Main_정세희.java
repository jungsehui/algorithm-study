package week5.BOJ_3020_골드5_개똥벌레;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] bottom = new int[H + 1];
        int[] top = new int[H + 1];
        for (int i = 1; i <= N; i++) {
            int obstacle = Integer.parseInt(br.readLine());
            if (i % 2 != 0) {
                bottom[obstacle]++;
            } else {
                top[H - obstacle + 1]++;
            }
        }

        for (int i = 0; i < H - 1; i++) {
            bottom[H - i - 1] += bottom[H - i];
        }
        for (int i = 0; i < H; i++) {
            top[i + 1] += top[i];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i <= H; i++) {
            int totalObstacle = bottom[i] + top[i];

            if (totalObstacle < min) {
                min = totalObstacle;
                count = 1;
            } else if (totalObstacle == min) {
                count++;
            }
        }

        bw.write(min + " " + count);
        bw.flush();
        bw.close();
        br.close();
    }
}
