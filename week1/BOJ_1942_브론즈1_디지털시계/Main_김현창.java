package week1.BOJ_1942_브론즈1_디지털시계;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int T = 3;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; ++tc) {
			st = new StringTokenizer(br.readLine());
			String startTime = st.nextToken();
			String endTime = st.nextToken();

			int start = convertTimeStringToSeconds(startTime);
			int end = convertTimeStringToSeconds(endTime);

			int answer = 0;
			if (start < end) {
				answer += getCountOfThreeMultiples(start, end);
			} else {
				answer += getCountOfThreeMultiples(start, 86399);
				answer += getCountOfThreeMultiples(0, end);
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	private static int getCountOfThreeMultiples(int start, int end) {
		int count = 0;
		for (int seconds = start; seconds <= end; ++seconds) {
			int timeInteger = convertSecondsToTimeInteger(seconds);
			if (timeInteger % 3 == 0) {
				++count;
			}
		}
		return count;
	}

	private static int convertSecondsToTimeInteger(int seconds) {
		final int[] digits = {1, 100, 10000};
		int res = 0;
		for (int i = 0; i < 3; ++i) {
			res += (seconds % 60) * digits[i];
			seconds /= 60;
		}
		return res;
	}

	private static int convertTimeStringToSeconds(String time) {
		String[] splited = time.split(":");
		return Integer.parseInt(splited[0]) * 3600
			+ Integer.parseInt(splited[1]) * 60
			+ Integer.parseInt(splited[2]);
	}
}
