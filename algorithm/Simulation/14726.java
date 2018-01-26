import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/

	private void solve() {
		int t = sc.nextInt();
		int[] array = new int[10];
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 4; i++) {
			array[i] = i * 2;
		}

		for (int i = 5; i <= 9; i++) {
			array[i] = ((i * 2) % 10) + 1;
		}

		while (t-- > 0) {
			String[] input = sc.readLine().split("");
			int sum = 0;

			for (int i = 0; i < input.length; i++) {
				if (i % 2 == 0) {
					sum += array[Integer.parseInt(input[i])];
				} else {
					sum += Integer.parseInt(input[i]);
				}
			}
			if (sum % 10 == 0) {
				sb.append("T\n");
			} else {
				sb.append("F\n");
			}
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