package week5.BOJ_18870_실버2_좌표압축;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println("numbers: " + Arrays.toString(numbers));

        int[] answer = Arrays.stream(numbers).distinct().sorted().toArray();
//        System.out.println("answer: " + Arrays.toString(answer));
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < answer.length; i++) {
            rank.put(answer[i], i);
        }
//        System.out.println(rank);

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(rank.get(number)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
