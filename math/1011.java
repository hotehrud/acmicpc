package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		// 양 사이드는 이동거리가 1이 고정.
		// 양 사이드를 기준으로 좁혀간다.
		
		while (t-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int left = x;
			int right = y;
			int move = 1;
			int cnt = 0;

			while (true) {
				
				if (left < right) {
					left += move;
					cnt++;
				} else {
					break;
				}
				
				if (right > left) {
					right -= move;
					cnt++;
				} else {
					break;
				}
				
				move++;

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