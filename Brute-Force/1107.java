package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private void solve() {

		// http://mygumi.tistory.com/157
		
		// 1. 숫자로 가까운 번호로 누른다.
		// 2. 숫자로 가까운 번호로 누른다. 그 후 + 또는 - 버튼으로 목표 번호에 도달한다.
		// 3. + 또는 - 버튼으로만 목표 번호로 도달한다.

		// 888888까지 돌리는 이유 - 입력 예제
		// 500000
		// 8
		// 0 1 2 3 4 5 6 7

		String input = sc.readLine();
		int n = Integer.parseInt(input);
		int m = sc.nextInt();
		int[] target = new int[6];
		boolean[] remocon = new boolean[10];
		int ans = Math.abs(n - 100); // + 또는 - 버튼으로만 이동 횟수를 기준.

		for (int i = 0; i < input.length(); i++) {
			target[i] = input.charAt(i) - '0';
		}

		for (int i = 0; i < m; i++) {
			remocon[sc.nextInt()] = true;
		}

		for (int i = 0; i <= 888888; i++) {
			// i는 번호 버튼을 눌러 가까운 번호로 이동으로 가정.
			boolean flag = false;
			String current = String.valueOf(i);
			int len = current.length();

			for (int j = 0; j < len; j++) {
				int value = current.charAt(j) - '0';

				if (!check(remocon, value)) {
					flag = true;
					break;
				}

			}

			// 해당 번호가 숫자 버튼을 누를 수 있는 경우
			if (!flag) {
				// 숫자 버튼 횟수 + 이동한 번호와 목표 번호간의 차이
				if (ans > Math.abs(i - n) + len) {
					ans = Math.abs(i - n) + len;
				}

			}

		}

		System.out.println(ans);
	}

	// 고장 여부
	public static boolean check(boolean[] array, int target) {
		if (array[target]) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		sc.init();

		new Main().solve();
	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		}

		static String readLineReplace() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (IOException e) {
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}