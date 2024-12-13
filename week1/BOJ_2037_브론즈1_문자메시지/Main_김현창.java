package week1.BOJ_2037_브론즈1_문자메시지;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    private static final char[][] keypad = {
            {'A', 'B', 'C'}, {'D', 'E', 'F'},
            {'G', 'H', 'I'}, {'J', 'K', 'L'}, {'M', 'N', 'O'},
            {'P', 'Q', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[] msg = br.readLine().toCharArray();
        int answer = 0;
        char prev = '!';
        for (char c: msg) {
            if (c == ' ') {
                answer += p;
                prev = ' ';
            } else {
                for (char[] key: keypad) {
                    if (contains(key, c)) {
                        if (contains(key, prev)) {
                            answer += w;
                        }
                        answer += (getIndex(key, c) + 1) * p;
                        prev = c;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static boolean contains(char[] array, char value) {
        for (char c: array) {
            if (c == value)
                return true;
        }
        return false;
    }

    private static int getIndex(char[] array, char value) {
        int index = 0;
        for (char c: array) {
            if (c == value)
                break;
            ++index;
        }
        return index;
    }
}
