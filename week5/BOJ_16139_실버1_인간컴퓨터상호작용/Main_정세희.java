package week5.BOJ_16139_실버1_인간컴퓨터상호작용;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_정세희 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String S = br.readLine();

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        int[][] arr = new int[S.length() + 1][26];
        for (int i = 1; i <= S.length(); i++) {
            System.arraycopy(arr[i - 1], 0, arr[i], 0, 26);
            arr[i][S.charAt(i - 1) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(arr[r + 1][a] - arr[l][a]).append(System.lineSeparator());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
