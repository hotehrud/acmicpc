import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/278

	private void solve() {
		int k = sc.nextInt();
		int[] array = new int[6];
		int w = 0;
		int h = 0;
		int ww = 0;
		int hh = 0;
		for (int i = 0; i < 6; i++) {
			sc.nextInt();
			array[i] = sc.nextInt();
		}

		// Get, max width and height
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				if (w < array[i]) {
					w = array[i];
				}
			} else {
				if (h < array[i]) {
					h = array[i];
				}
			}
		}

		// 한 변을 기준으로 앞 뒤 변의 길이의 합이 길이와 같다면 파인 지점
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				if (h == array[(i + 5) % 6] + array[(i + 1) % 6]) {
					ww = array[i];
				}
			} else {
				if (w == array[(i + 5) % 6] + array[(i + 1) % 6]) {
					hh = array[i];
				}
			}
		}
		System.out.println((w * h - ww * hh) * k);
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

		static boolean hasNext() {
			return st.hasMoreTokens();
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