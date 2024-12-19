package week1.BOJ_1942_브론즈1_디지털시계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < 3; tc++) {
            st = new StringTokenizer(br.readLine());
            String startTime = st.nextToken();
            String endTime = st.nextToken();

            int startTimeInt = convertStringToTimeInt(startTime);
            int endTimeInt = convertStringToTimeInt(endTime);

            int count = 0;

            if (startTimeInt <= endTimeInt) {
                count += getCount(startTimeInt, endTimeInt);
            } else {
                count += getCount(startTimeInt, 86399);
                count += getCount(0, endTimeInt);
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
        br.close();

    }

    private static int getCount(int startTimeInt, int endTimeInt) {
        int count = 0;
        for (int j = startTimeInt; j <= endTimeInt; j++) {
            if (j % 3 == 0) {
                count += 1;
            }
        }
        return count;
    }

    private static int convertStringToTimeInt(String time) {
        String[] tokens = time.split(":");
        return Integer.parseInt(tokens[0]) * 3600
                + Integer.parseInt(tokens[1]) * 60
                + Integer.parseInt(tokens[2]);
    }
}
