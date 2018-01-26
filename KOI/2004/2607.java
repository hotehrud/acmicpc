import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/
	private void solve() {
		int n = sc.nextInt();
		char[] array = sc.readLine().toCharArray();
		int a = array.length;
		int ans = 0;

		Arrays.sort(array);

		for (int k = 0; k < n - 1; k++) {
			char[] temp = sc.readLine().toCharArray();
			Arrays.sort(temp);
			int b = temp.length;
			int i = 0;
			int j = 0;
			int cnt = 0;

			if (a < b) {
				if (a != b - 1) {
					continue;
				}
			} else if (a > b) {
				if (a != b + 1) {
					continue;
				}
			}
			int tmp = 0;
			for (i = 0; i < b; i++) {
				for (j = tmp; j < a; j++) {
					if (array[j] == temp[i]) {
						cnt++;
						tmp = j + 1;
						break;
					}
				}
			}

			if (a == b) {
				if (a == cnt || a == cnt + 1) {
					ans++;
				}
			} else if (a < b) {
				if (a == cnt) {
					ans++;
				}
			} else {
				if (a == cnt + 1) {
					ans++;
				}
			}
		}
		System.out.println(ans);
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