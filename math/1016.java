package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		long min = sc.nextLong();
		long max = sc.nextLong();

		int cnt = 0;
		int[] ans = new int[1000001];
		
		// http://wootool.tistory.com/39

		for (long p = 2; p * p <= max; p++) {

			// x - p의 제곱 수로 최소값을 나눈 수
			long x = min / (1L * p * p);
			
			if (min % (1L * p * p) != 0) {
				x++;
			}

			while (x * (1L * p * p) <= max) {
				// x를 통해 p의 제곱수를 계속 만들어나가면서 탐색
				// ans[0] 은 min을 의미
				ans[(int) (x * (1L * p * p) - min)] = 1;
				x++;
			}

		}

		for (int i = 0; i <= max - min; i++) {
			if (ans[i] == 0) {
				cnt++;
			}
		}
		System.out.println(cnt);

		// 1000000000000 1000001000000
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