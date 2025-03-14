package week5.BOJ_16139_실버1_인간컴퓨터상호작용;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정세희_50점 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String line = br.readLine();

        st = new StringTokenizer(br.readLine());

        int q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int count = 0;

            for (int j = l; j <= r; j++) {
                if (c == line.charAt(j)) {
                    count++;
                }
            }

            bw.write(count + System.lineSeparator());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
