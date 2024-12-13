package week1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<String> names = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            names.add(st.nextToken());
        }

        List<String> firstAlphabet = names.stream()
                .map(s -> s.substring(0, 1))
                .collect(Collectors.toList());

        Collections.sort(firstAlphabet);

        StringBuilder sb = new StringBuilder();
        String previous = firstAlphabet.get(0);
        int count = 1;

        for (int i = 1; i < firstAlphabet.size(); i++) {
            String s = firstAlphabet.get(i);
            if (previous.equals(s)) {
                count++;
            } else {
                if (count >= 5) {
                    sb.append(previous);
                }
                previous = s;
                count = 1;
            }
        }

        if (count >= 5) {
            sb.append(previous);
        }

        if (sb.toString().equals("")) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb);
        }

        br.close();
    }
}
