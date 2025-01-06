package week2.BOJ_16637_골드3_괄호추가하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_김현창 {

	private static int N, N2;
	private static int answer = -1234567890;
	private static int[] operand;
	private static char[] operator;
	private static boolean[] bracket;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		N2 = N >> 1;
		operand = new int[N2 + 1];
		bracket = new boolean[N2];
		operator = new char[N2];

		String expression = br.readLine();
		for (int i = 0; i < N; ++i) {
			if ((i & 1) == 0) {
				operand[i >> 1] = expression.charAt(i) - '0';
			} else {
				operator[i >> 1] = expression.charAt(i);
			}
		}
		dfs(0);
		System.out.println(answer);
		br.close();
	}

	private static void dfs(int depth) {
		if (depth >= N2) {
			answer = Math.max(answer, test());
			return;
		}

		bracket[depth] = true;
		dfs(depth + 2);

		bracket[depth] = false;
		dfs(depth + 1);
	}

	private static int test() {
		int[] nums = operand.clone();
		char[] ops = operator.clone();
		for (int i = 0; i < N2; ++i) {
			if (bracket[i]) {
				nums[i] = operation(nums[i], nums[i + 1], ops[i]);
				nums[i + 1] = 0;
				ops[i] = '+';
			}
		}

		int res = nums[0];
		for (int i = 0; i < N2; ++i) {
			res = operation(res, nums[i + 1], ops[i]);
		}
		return res;
	}

	private static int operation(int num1, int num2, char op) {
		if (op == '+')
			return num1 + num2;
		else if (op == '-')
			return num1 - num2;
		else if (op == '*')
			return num1 * num2;
		else
			throw new IllegalArgumentException("unsupported operator");
	}
}
