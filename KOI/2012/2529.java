import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/279

	static boolean[] visited = new boolean[10];
	static ArrayList<String> list = new ArrayList<String>();
	static String[] input;
	static int k;

	private void solve() {
		k = sc.nextInt();
		input = sc.readLine().split(" ");

		for (int i = 0; i <= 9; i++) {
			visited[i] = true;
			dfs(i, 0, i + "");
		}
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));
	}

	public static void dfs(int v, int cnt, String str) {
		if (cnt == k) {
      // success
			list.add(str);
		} else {
			for (int i = 0; i <= 9; i++) {
				if (!visited[i]) {
					if (input[cnt].equals("<")) {
						if (v >= i) {
							continue;
						}
					} else {
						if (v <= i) {
							continue;
						}
					}
					visited[i] = true;
					dfs(i, cnt + 1, str + i);
				}
			}
    }
    // backtracking
		visited[v] = false;
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