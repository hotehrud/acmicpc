package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		// http://mygumi.tistory.com/180
		int page = sc.nextInt();
		int[] ans = new int[10];
		int point = 1;
		int start = 1;

		while (start <= page) {
			// 끝자리 9로 만들기
			while (page % 10 != 9 && start <= page) {
				cal(page, ans, point);
				page--;
			}

			if (page < start) {
				break;
			}

			// 끝자리 0으로 만들기
			while (start % 10 != 0 && start <= page) {
				cal(start, ans, point);
				start++;
			}

			start /= 10;
			page /= 10;

			for (int i = 0; i < 10; i++) {
				ans[i] += (page - start + 1) * point;
			}
			
			point *= 10;
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(ans[i] + " ");
		}

	}

	public static void cal(int x, int[] ans, int point) {
		while (x > 0) {
			ans[x % 10] += point;
			x /= 10;
		}
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

		static long nextLong() {
			return Long.parseLong(next());
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}