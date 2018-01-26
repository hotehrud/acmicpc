import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/273
	private void solve() {
		int n = sc.nextInt();
		ArrayList<Ball> input = new ArrayList<Ball>();
		ArrayList<Integer>[] colors = (ArrayList<Integer>[]) new ArrayList[200001];
		int[] sizes = new int[2001];
		int[] psum = new int[200001];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 200001; i++) {
			colors[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= n; i++) {
			int color = sc.nextInt();
			int size = sc.nextInt();
			input.add(new Ball(color, size));
			colors[color].add(size);
			sizes[size]++;
		}

		// 부분합
		for (int i = 1; i < 2001; i++) {
			psum[i] = psum[i - 1] + (sizes[i] * i);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(colors[i]);
		}

		for (int i = 0; i < n; i++) {
			Ball b = input.get(i);
			int c = b.c;
			int s = b.s;
			int sum = psum[s - 1];

			for (int same : colors[c]) {
				if (same < s) {
					sum -= same;
				} else {
					break;
				}
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb.toString());
	}

	public static class Ball {
		int c;
		int s;

		Ball(int c, int s) {
			this.c = c;
			this.s = s;
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