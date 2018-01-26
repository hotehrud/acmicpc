package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private void solve() {
		// http://mygumi.tistory.com/160

		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			int n = sc.nextInt();
			int cnt = 1;
			long sum = 0;

			long[] array = new long[6];
			long[] quantity = new long[6];

			for (int i = 0; i < 6; i++) {
				array[i] = sc.nextInt();
				sum += array[i];
			}

			// 첫날부터 요구사항을 못 들어줄 경우 배제.
			if (sum > n) {
				sb.append("1\n");
				continue;
			}

			while (n >= sum) {
				sum = 0;
				cnt++;

				for (int i = 0; i < 6; i++) {
					// (i + 1) % 6 => 오른쪽, (i + 3) % 6 => 바라보는쪽, (i + 5) % 6 => 왼쪽
					quantity[i] = array[i] + array[(i + 1) % 6] + array[(i + 3) % 6] + array[(i + 5) % 6];

					sum += quantity[i];
				}

				// 다음 날을 위한 먹는 양 갱신
				for (int i = 0; i < 6; i++) {
					array[i] = quantity[i];
				}
			}

			sb.append(cnt + "\n");

		}
		System.out.println(sb.toString());
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