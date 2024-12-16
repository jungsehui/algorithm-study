package week1.BOJ_1440_브론즈2_타임머신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_정세희 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] tokens = input.split(":");
        String first = tokens[0];
        String second = tokens[1];
        String third = tokens[2];

        int count = 0;

        if (isValidTime(first, second, third)) {
            count++;
        }
        if (isValidTime(first, third, second)) {
            count++;
        }
        if (isValidTime(second, first, third)) {
            count++;
        }
        if (isValidTime(second, third, first)) {
            count++;
        }
        if (isValidTime(third, first, second)) {
            count++;
        }
        if (isValidTime(third, second, first)) {
            count++;
        }

        System.out.println(count);
        br.close();
    }

    private static boolean isValidTime(String HH, String MM, String SS) {
        int hour = Integer.parseInt(HH);
        int minute = Integer.parseInt(MM);
        int second = Integer.parseInt(SS);

        return (hour >= 1 && hour <= 12) && (minute >= 0 && minute <= 59) && (second >= 0 && second <= 59);
    }
}
