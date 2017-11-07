import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com
	
	private void solve() {
		// 피보나치
		// 직사각형 둘레 = (가로 + 세로) * 2
		int n = sc.nextInt();
		long[] array = new long[n + 1];
		array[1] = 1;
		for (int i = 2; i <= n; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}

		long a = array[n] + array[n - 1];
		long b = array[n];
		
		System.out.println((a + b) * 2);
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