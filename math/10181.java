import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/

	private void solve() {
		String input = "";
		StringBuilder ans = new StringBuilder();

		while (!(input = sc.readLine()).equals("-1")) {
			int n = Integer.parseInt(input);
			int sum = 1;
			StringBuilder sb = new StringBuilder(input);
			StringBuilder temp = new StringBuilder("1");

			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					sum += i;
					temp.append(" + " + i);
				}
			}
			
			if (sum == n) {
				sb.append(" = " + temp);
			} else {
				sb.append(" is NOT perfect.");
			}
			
			ans.append(sb.toString() + "\n");
		}
		System.out.println(ans.toString());
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