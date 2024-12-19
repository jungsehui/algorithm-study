package week1.BOJ_2037_브론즈1_문자메시지;

import java.io.*;
import java.util.*;


/*
오른쪽 그림과 같은 핸드폰 자판이 있다. 이 자판을 이용하여 어떤 영어 메시지를 치려고 할 때, 걸리는 최소 시간을 구하는 프로그램을 작성하시오.
단, 1번은 누를 경우에는 공백이 찍힌다고 하자. 그리고 만약에 AC라는 문자를 치려 한다면 A를 치고 난 후 일정 시간을 기다린 후 C를 치면 된다.

하나의 문자를 입력하려면, 버튼을 눌러야 한다. 버튼을 누르면 버튼에 쓰여 있는 문자가 입력되며, 버튼을 누를 때 마다 다음 문자로 바뀌게 된다.
예를 들어, 2를 누르면 A, 2번 누르면 B, 3번 누르면 C이다. 공백을 연속으로 누를 때는 기다릴 필요가 없다.

첫째 줄에 p와 w가 주어진다. (1 ≤ p, w ≤ 1,000) p는 버튼을 한번 누르는데 걸리는 시간이고, w는 AC와 같은, 같은 숫자인 문자를 연속으로 찍기 위해 기다리는 시간을 의미한다.
그리고 둘째 줄에는 적을 문자열이 주어진다. 단, 이 문자열의 길이는 1000보다 작고, 맨 앞과 맨 뒤에 공백이 들어오는 경우는 없다. 문자열은 알파벳 대문자와 띄어쓰기만으로 이루어져 있다.
*/


public class Main_정세희 {

    private static char[][] keypad = {
                                    {'A', 'B', 'C'},    {'D', 'E', 'F'},

            {'G', 'H', 'I'},        {'J', 'K', 'L'},    {'M', 'N', 'O'},

            {'P', 'Q', 'R', 'S'},   {'T', 'U', 'V'},    {'W', 'X', 'Y', 'Z'}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());        
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[] message = br.readLine().toCharArray();

        int result = 0;

        char tmp = ' ';     // 이전에 누른 거에 따라서 같은 숫자를 다시 눌러야 하면 기다려야 하기 때문
        for (char c : message) {
            if (c == ' ') {
                result += p;
                tmp = ' ';
            } else {
                for (int i = 0; i < keypad.length; i++) {
                    for (int j = 0; j < keypad[i].length; j++) {
                        if (keypad[i][j] == c) {
                            result += (j + 1) * p;      // 몇 번째에 있는지 확인하고 인덱스는 0부터 시작하니 +1을 해 주고 누른 만큼 곱하기
                            if (tmp == (char) ('1' + i)) {
                                result += w;
                            }
                            tmp = (char) ('1' + i);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(result);
        br.close();
    }
}
