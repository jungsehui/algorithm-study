package week1.BOJ_28417_브론즈3_스케이트보드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정세희2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        int N = Integer.parseInt(br.readLine());

        // 리스트를 쓴 이유 : 컬렉션 사용에 더 익숙해지기 위해서, 배열보다 리스트에서 할 수 있는 게 많고 배열에서 할 수 있는 건 리스트에서도 가능
        // 인덱스로 찾는 건 배열이 리스트보다 빠르겠지만 .. 아마 ?
        for (int i = 0; i < N; i++) {
            List<Integer> run = new ArrayList<>();
            List<Integer> trick = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                run.add(Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j < 5; j++) {
                trick.add(Integer.parseInt(st.nextToken()));
            }

            // 여기서 최댓값 계산할 때 for문을 돌까 아니면 Math의 static 메서드를 사용할까 할 때 어떤 게 더 빠를지 고민했음
            // Math.max의 구현은 반복 없이 비교연산자로 return을 바로 해 줌 -> 당연 for문보다 빠름
            // 근데 만약 입력 값이 커지고 요소가 많아진다면 ? for문을 도는 게 더 나음
            int runMaxVal = Collections.max(run);

            Collections.sort(trick);
            int trickMaxVal = trick.get(trick.size() - 1) + trick.get(trick.size() - 2);

            int target = runMaxVal + trickMaxVal;
            answer = Math.max(answer, target);
        }

        System.out.println(answer);
        br.close();
    }
}
