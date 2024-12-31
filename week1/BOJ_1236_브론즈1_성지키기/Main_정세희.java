package week1.BOJ_1236_브론즈1_성지키기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] square = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                square[i][j] = line.charAt(j);
            }
        }

        int row = 0;
        int col = 0;

        // 경비원이 로우에 없으면 추가
        for (int i = 0; i < N; i++) {
            boolean hasRiot = false;

            for (int j = 0; j < M; j++) {
                if (square[i][j] == 'X') {
                    hasRiot = true;
                    break;
                }
            }

            if (!hasRiot) {
                row += 1;
            }
        }

        // 경비원이 컬럼에 없으면 추가
        for (int i = 0; i < M; i++) {
            boolean hasRiot = false;

            for (int j = 0; j < N; j++) {
                if (square[j][i] == 'X') {
                    hasRiot = true;
                    break;
                }
            }

            if (!hasRiot) {
                col += 1;
            }
        }

        System.out.println(Math.max(row, col));
        br.close();
    }
}
