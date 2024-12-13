package week1;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[] run = new int[2];
        int[] trick = new int[5];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                run[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < 5; j++) {
                trick[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(trick);

            // 여기서 최댓값 계산할 때 for문을 돌까 아니면 Math의 static 메서드를 사용할까 할 때 어떤 게 더 빠를지 고민했음
            // Math.max의 구현은 반복 없이 비교연산자로 return을 바로 해 줌 -> 당연 for문보다 빠름
            // 근데 만약 입력 값이 커지고 요소가 많아진다면 ? for문을 도는 게 더 나음
            int target = Math.max(run[0], run[1]) + trick[4] + trick[3];

            answer = Math.max(answer, target);
        }

        System.out.println(answer);
        br.close();
    }
}
