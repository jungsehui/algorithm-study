package week2.BOJ_20529_실버1_가장가까운세사람의심리적거리;

import java.io.*;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static int T;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] MBIT = br.readLine().split(" ");

            if (N > 32) {
                sb.append(0).append(System.lineSeparator());
                continue;
            }

            int minDistace = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        int distance =
                                calculateDistance(MBIT[i], MBIT[j]) +
                                calculateDistance(MBIT[j], MBIT[k]) +
                                calculateDistance(MBIT[i], MBIT[k]);
                        minDistace = Math.min(minDistace, distance);
                    }
                }
            }

            sb.append(minDistace).append(System.lineSeparator());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int calculateDistance(String a, String b) {
        int distance = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distance += 1;
            }
        }
        return distance;
    }
}
