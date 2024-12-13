package week1.BOJ_1267_브론즈3_핸드폰_요금;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
동호는 새악대로 T 통신사의 새 핸드폰 옴머나를 샀다. 새악대로 T 통신사는 동호에게 다음 두 가지 요금제 중 하나를 선택하라고 했다.

영식 요금제
민식 요금제
영식 요금제는 30초마다 10원씩 청구된다. 이 말은 만약 29초 또는 그 보다 적은 시간 통화를 했으면 10원이 청구된다. 만약 30초부터 59초 사이로 통화를 했으면 20원이 청구된다.

민식 요금제는 60초마다 15원씩 청구된다. 이 말은 만약 59초 또는 그 보다 적은 시간 통화를 했으면 15원이 청구된다. 만약 60초부터 119초 사이로 통화를 했으면 30원이 청구된다.

동호가 저번 달에 새악대로 T 통신사를 이용할 때 통화 시간 목록이 주어지면 어느 요금제를 사용 하는 것이 저렴한지 출력하는 프로그램을 작성하시오.
*/

public class Main_정세희 {

    static final int YOUNG_SIK = 30;
    static final int MIN_SIK = 60;

    static final int PRICE_PER_30_SEC = 10;
    static final int PRICE_PER_60_SEC = 15;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> callTimes = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            callTimes.add(Integer.parseInt(st.nextToken()));
        }

        int ys = 0;
        int ms = 0;

        // 입력은 전부 자연수로 한정했기 때문에 0 입력에 대한 검증은 불필요
        for (Integer callTime : callTimes) {
            ys += callTime / YOUNG_SIK + 1;      // 만약에 callTime이 40이면 ys에 1이 생길 텐데 실제 계산 시에는 +1로 곱하기
            ms += callTime / MIN_SIK + 1;        // 만약에 callTime이 40이면 ms에 1이 생길 텐데 실제 계산 시에는 +1로 곱하기
        }

        int ysResult = ys * PRICE_PER_30_SEC;
        int msResult = ms * PRICE_PER_60_SEC;

        if (ysResult > msResult) {
            System.out.println("M " + msResult);
        }
        if (ysResult < msResult) {
            System.out.println("Y " + ysResult);
        }
        if (ysResult == msResult) {
            System.out.println("Y " + "M " + ysResult);
        }

        br.close();
    }

    private enum PriceType {

        Y(30, 10),
        M(60, 15);

        PriceType(int sec, int price) {
        }
    }
}
