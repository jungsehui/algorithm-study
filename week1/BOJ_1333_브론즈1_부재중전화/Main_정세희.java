package week1.BOJ_1333_브론즈1_부재중전화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 노래 N곡 들어 있음
        int L = Integer.parseInt(st.nextToken());   // 노래 길이 L초
        int D = Integer.parseInt(st.nextToken());   // 전화벨이 D초에 한 번씩 울리고, 한 번 울릴 때 1초 동안 지속

        // 2 5 7 >> 7
        int totalAlbumLength = N * L + (N - 1) * 5;

        for (int t = 0; ; t += D) {
            if (t >= totalAlbumLength) {
                System.out.println(t);
                break;
            }

            boolean canHearCall = true;
            for (int i = 0; i < N; i++) {
                int songStart = i * (L + 5);
                int songEnd = songStart + L;

                if (t == songStart || (t > songStart && t < songEnd)) {
                    canHearCall = false;
                    break;
                }
            }

            if (canHearCall) {
                System.out.println(t);
                break;
            }
        }

        br.close();
    }
}
