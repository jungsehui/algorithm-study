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

/*
        List<String> firstAlphabet = names.stream()
                .map(s -> s.substring(0, 1))
                .toList();
*/

        // 첫 글자 추출 및 등장 횟수 카운트
        Map<String, Long> firstLetterCount = names.stream()
                .map(s -> s.substring(0, 1)) // 첫 글자 추출
                .collect(Collectors.groupingBy(letter -> letter, Collectors.counting())); // 카운트

        // 등장 횟수가 5 이상인 첫 글자만 추출
        List<String> firstAlphabet = firstLetterCount.entrySet().stream()
                .filter(entry -> entry.getValue() >= 5) // 5번 이상 등장하는 경우 필터링
                .map(Map.Entry::getKey) // 알파벳만 추출
                .collect(Collectors.toList());

        StringBuilder answer = new StringBuilder();
        for (String s : firstAlphabet) {
            answer.append(s);
        }

        if (answer.toString().isEmpty()) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(answer);
        }

        br.close();
    }
}
