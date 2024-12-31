package week1.BOJ_2596_브론즈1_비밀편지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정세희2 {

    private static final String[] PROMISED_CHARACTERS = {
            "000000",
            "001111",
            "010011",
            "011100",
            "100110",
            "101001",
            "110101",
            "111010"
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String message = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String subMessage = message.substring(i * 6, (i * 6) + 6);
            boolean match = false;

            for (int j = 0; j < PROMISED_CHARACTERS.length; j++) {
                String promisedCharacter = PROMISED_CHARACTERS[j];
                int diffCount = 0;

                for (int k = 0; k < 6; k++) {
                    if (subMessage.charAt(k) != promisedCharacter.charAt(k)) {
                        diffCount += 1;
                    }
                }

                if (diffCount <= 1) {
                    sb.append((char) ('A' + j));
                    match = true;
                    break;
                }
            }

            if (!match) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}
