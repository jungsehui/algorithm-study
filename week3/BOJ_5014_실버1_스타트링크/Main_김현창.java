package week3.BOJ_5014_실버1_스타트링크;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(S);
		int[] visited = new int[F + 1];
		visited[S] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			if (now == G)
				break;

			for (int next: new int[]{now - D, now + U}) {
				if (next <= 0 || next > F)
					continue;
				if (visited[next] != 0)
					continue;
				queue.add(next);
				visited[next] = visited[now] + 1;
			}
		}

		if (visited[G] == 0)
			System.out.println("use the stairs");
		else
			System.out.println(visited[G] - 1);
	    br.close();
	}
}
