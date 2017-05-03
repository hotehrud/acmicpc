package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		// http://mygumi.tistory.com/155
		
		while (t-- > 0) {

			int n = sc.nextInt();
			int cnt = 0;
			int[] array = new int[4];

			while (n != 6174) {

				for (int i = 3; i >= 0; i--) {
					array[i] = n % 10;
					n /= 10;
				}

				// 정렬 목적
				Arrays.sort(array);

				int a = select(false, array);
				int d = select(true, array);

				n = a - d;

				cnt++;
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int select(boolean flag, int[] array) {
		int result = 0;
		int temp = 1000;

		if (flag) {
			// 내림차순 == 작은 수
			for (int i = 0; i < 4; i++) {
				result += array[i] * temp;
				temp /= 10;
			}
		} else {
			// 오름차순 == 큰 수
			for (int i = 3; i >= 0; i--) {
				result += array[i] * temp;
				temp /= 10;
			}
		}

		return result;
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