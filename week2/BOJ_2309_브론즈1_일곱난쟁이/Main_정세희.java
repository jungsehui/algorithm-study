package week2.BOJ_2309_브론즈1_일곱난쟁이;

import java.io.*;
import java.util.Arrays;

public class Main_정세희 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int total = 0;
        int[] heights = new int[9];
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            total += heights[i];
        }
        Arrays.sort(heights);

        int targetI = -1;
        int targetJ = -1;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (total - (heights[i] + heights[j]) == 100) {
                    targetI = i;
                    targetJ = j;
                    i = 1234;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != targetI && i != targetJ) {
                sb.append(heights[i]).append(System.lineSeparator());
            }
        }

        System.out.println(sb);

        bw.flush();
        bw.close();
        br.close();
    }
}
