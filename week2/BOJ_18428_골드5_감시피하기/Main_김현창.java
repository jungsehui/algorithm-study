package week2.BOJ_18428_골드5_감시피하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	private static int N;
	private static int N2;
	private static char[][] graph;
	private static List<Pair> teachers = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		N2 = N * N;
		graph = new char[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				graph[i][j] = st.nextToken().charAt(0);
				if (graph[i][j] == 'T') {
					teachers.add(new Pair(i, j));
				}
			}
		}
		System.out.println(dfs(0, 0) ? "YES" : "NO");
		br.close();
	}

	private static boolean dfs(int index, int depth) {
		if (depth == 3) {
			return test();
		}
		boolean ret = false;
		for (int i = index; !ret && i < N2; ++i) {
			int r = i / N;
			int c = i % N;
			if (graph[r][c] != 'X')
				continue;
			graph[r][c] = 'O';
			ret = dfs(i + 1, depth + 1);
			graph[r][c] = 'X';
		}
		return ret;
	}

	private static boolean test() {
		for (Pair t: teachers) {
			for (int i = 0; i < 4; ++i) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				while (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (graph[nx][ny] == 'S')
						return false;
					else if (graph[nx][ny] == 'O')
						break;
					nx += dx[i];
					ny += dy[i];
				}
			}
		}
		return true;
	}

	private static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
