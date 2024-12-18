package week1.BOJ_1871_브론즈2_좋은자동차번호판;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<String> numbers = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            numbers.add(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            String number = numbers.get(i);
            String[] parts = number.split("-");
            String first = parts[0];
            int second = Integer.parseInt(parts[1]);

            int firstVal = (first.charAt(0) - 'A') * 26 * 26;
            int secondVal = (first.charAt(1) - 'A') * 26;
            int thirdVal = (first.charAt(2) - 'A');

            if (Math.abs((firstVal + secondVal + thirdVal) - second) <= 100) {
                System.out.println("nice");
            } else {
                System.out.println("not nice");
            }
        }

        br.close();
    }
}
