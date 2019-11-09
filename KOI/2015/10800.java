import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	private void solve() {
		// https://mygumi.tistory.com/273
		int n = sc.nextInt();
		ArrayList<Ball> input = new ArrayList<Ball>();
		int[] players = new int[200001];
		int[] colors = new int[200001];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			int color = sc.nextInt();
			int size = sc.nextInt();
			input.add(new Ball(i, color, size));
		}

		Collections.sort(input, new Comparator<Ball>() {
			public int compare(Ball b1, Ball b2) {
				if (b1.size < b2.size) {
					return -1;
				} else if (b1.size > b2.size) {
					return 1;
				} else {
					if (b1.color < b2.color) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		});

		int sum = 0;
		for (int i = 0, j = 0; i < n; i++) {
			Ball a = input.get(i);
			Ball b = input.get(j);

			while (b.size < a.size) {
				sum += b.size;
				colors[b.color] += b.size;

				b = input.get(++j);
			}
			players[a.id] = sum - colors[a.color];
		}

		for (int i = 0; i < n; i++) {
			sb.append(players[i] + "\n");
		}
		System.out.println(sb.toString());
	}

	public static class Ball {
		int id;
		int color;
		int size;

		Ball(int id, int color, int size) {
			this.id = id;
			this.color = color;
			this.size = size;
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