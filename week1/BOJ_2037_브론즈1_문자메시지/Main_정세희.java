package week1.BOJ_2037_브론즈1_문자메시지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정세희 {

    private static char[][] keypad = {
                                    {'A', 'B', 'C'},    {'D', 'E', 'F'},

            {'G', 'H', 'I'},        {'J', 'K', 'L'},    {'M', 'N', 'O'},

            {'P', 'Q', 'R', 'S'},   {'T', 'U', 'V'},    {'W', 'X', 'Y', 'Z'}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());        
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[] message = br.readLine().toCharArray();

        int result = 0;

        char tmp = ' ';
        for (char c : message) {
            if (c == ' ') {
                result += p;
                tmp = ' ';
            } else {
                for (int i = 0; i < keypad.length; i++) {
                    for (int j = 0; j < keypad[i].length; j++) {
                        if (keypad[i][j] == c) {
                            result += (j + 1) * p;
                            if (tmp == (char) ('1' + i)) {
                                result += w;
                            }
                            tmp = (char) ('1' + i);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(result);
        br.close();
    }
}
