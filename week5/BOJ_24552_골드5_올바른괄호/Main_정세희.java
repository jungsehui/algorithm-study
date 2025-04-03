package week5.BOJ_24552_골드5_올바른괄호;

import java.io.*;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String S = br.readLine();

        int[] arr = new int[S.length() + 1];
        for (int i = 1; i <= S.length(); i++) {
            char c = S.charAt(i - 1);
            if (c == '(') {
                arr[i] = 1;
            } else {
                arr[i] = -1;
            }
        }

        int[] prefix = new int[S.length() + 1];
        for (int i = 1; i <= arr.length - 1; i++) {
            prefix[i] += arr[i] + prefix[i - 1];
        }

        if (prefix[S.length()] == 1) {
            int index = 0;
            for (int i = S.length(); i >= 0; i--) {
                if (prefix[i] == 0) {
                    index = i;
                    break;
                }
            }

            int count = 0;
            for (int i = index + 1; i <= S.length(); i++) {
                if (S.charAt(i - 1) == '(') {
                    count++;
                }
            }
            bw.write(String.valueOf(count));
        } else {
            int index = S.length();
            for (int i = 1; i < S.length(); i++) {
                if (prefix[i] == -1) {
                    index = i;
                    break;
                }
            }

            int count = 0;
            for (int i = 1; i <= index; i++) {
                if (S.charAt(i - 1) == ')') {
                    count++;
                }
            }
            bw.write(String.valueOf(count));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}