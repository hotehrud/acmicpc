import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		while (n-- > 0) {
			String s = sc.readLine();
			char[] array = s.toCharArray();
			int g = 0, b = 0;

			for (int i = 0; i < array.length; i++) {
				if (array[i] == 'g' || array[i] == 'G') {
					g++;
					continue;
				}

				if (array[i] == 'b' || array[i] == 'B') {
					b++;
				}
			}
			sb.append(s + " is ").append(g > b ? "GOOD" : g == b ? "NEUTRAL" : "A BADDY").append("\n");
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