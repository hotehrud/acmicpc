import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/271
	private void solve() {
		int n = sc.nextInt();
		int[] array = new int[n];
		int sum = 0;
		int max = 0;

		for (int i = 0; i < n; i++) {
			sum += array[i] = sc.nextInt();
    }
    
		int budget = sc.nextInt();
		Arrays.sort(array);

		if (sum <= budget) {
			System.out.println(array[n - 1]);
		} else {
			int tmp = budget / n;
			int remain = n;
			for (int i = 0; i < n; i++) {
				if (array[i] <= tmp) {
					budget -= array[i];
				} else {
					remain = n - i;
					tmp = budget / remain;
					if (array[i] > tmp) {
						break;
					}
					i--;
				}
			}
			System.out.println(budget / remain);
		}
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