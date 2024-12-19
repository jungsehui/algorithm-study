package week1.BOJ_1672_브론즈1_DNA해독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String genuine = br.readLine();
        char[] tokens = genuine.toCharArray();

        for (int i = N - 1; i > 0; i--) {
            char curr = tokens[i];
            char target = tokens[i - 1];

            if (curr == 'a') {
                tokens[i - 1] = target;
            }
            if (curr == 'A') {
                if (target == 'G') tokens[i - 1] = 'C';
                if (target == 'C') tokens[i - 1] = 'A';
                if (target == 'T') tokens[i - 1] = 'G';
            } else if (curr == 'G') {
                if (target == 'A') tokens[i - 1] = 'C';
                if (target == 'C') tokens[i - 1] = 'T';
                if (target == 'T') tokens[i - 1] = 'A';
            } else if (curr == 'C') {
                if (target == 'A') tokens[i - 1] = 'A';
                if (target == 'G') tokens[i - 1] = 'T';
                if (target == 'T') tokens[i - 1] = 'G';
            } else if (curr == 'T') {
                if (target == 'A') tokens[i - 1] = 'G';
                if (target == 'G') tokens[i - 1] = 'A';
                if (target == 'C') tokens[i - 1] = 'G';
            }
        }

        System.out.println(tokens[0]);
        br.close();
    }
}
