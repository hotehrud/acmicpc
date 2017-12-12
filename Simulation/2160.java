import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/
	private void solve() {
		int n = sc.nextInt();
		char[][][] array = new char[50][5][7];
		int min = Integer.MAX_VALUE;
		int a = 0;
		int b = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 5; j++) {
				array[i][j] = sc.readLine().toCharArray();
			}
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = compare(array, i, j);
				if (min > temp) {
					a = i;
					b = j;
					min = temp;
				}
			}
		}
		System.out.println((a + 1) + " " + (b + 1));
	}

	public static int compare (char[][][] array, int a, int b) {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0 ; j < 7; j++) {
				if (array[a][i][j] != array[b][i][j]) {
					++cnt;
				}
			}
		}
		return cnt;
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