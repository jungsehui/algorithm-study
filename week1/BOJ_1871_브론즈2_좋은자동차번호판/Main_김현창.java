package week1.BOJ_1871_브론즈2_좋은자동차번호판;

import java.io.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            String[] splited = br.readLine().split("-");
            String firstString = splited[0];
            int second = Integer.parseInt(splited[1]);

            int first = ((firstString.charAt(0) - 'A') * 26 * 26)
                    + ((firstString.charAt(1) - 'A') * 26)
                    + (firstString.charAt(2) - 'A');

            if (Math.abs(first - second) <= 100) {
                sb.append("nice\n");
            } else {
                sb.append("not nice\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
