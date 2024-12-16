package week1;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();
        String[] tokens = input.split(":");
        int first = Integer.parseInt(tokens[0]);
        int second = Integer.parseInt(tokens[1]);
        int third = Integer.parseInt(tokens[2]);

        int count = 0;

        if (first >= 1 && first <= 12) {
            if (second <= 59 && third <= 59) {
                count += 2;
            }
        }

        if (second >= 1 && second <= 12) {
            if (first <= 59 && third <= 59) {
                count += 2;
            }
        }

        if (third >= 1 && third <= 12) {
            if (first <= 59 && second <= 59) {
                count += 2;
            }
        }

        if (first == 0 && second == 0 && third == 0) {
            count = 0;
        }

        System.out.println(count);
        br.close();
    }
}
