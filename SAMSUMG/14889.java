import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map = new int[21][21];
	static boolean[] visited = new boolean[21];
	static int n, ans = Integer.MAX_VALUE;

	private void solve() {
		// http://mygumi.tistory.com/243
		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(0, 0);
		System.out.println(ans);
	}

	public static void dfs(int v, int len) {
		if (n / 2 == len) {
			divideTeam();
		} else {
			for (int i = v + 1; i <= n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(i, len + 1);
				}
			}
		}
		visited[v] = false;
	}

	public static void divideTeam() {
		int[] a = new int[n / 2 + 1];
		int[] b = new int[n / 2 + 1];
		int ai = 1, bi = 1;
		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				a[ai++] = i;
			} else {
				b[bi++] = i;
			}
		}

		int aStat = getStat(a);
		int bStat = getStat(b);
		int diff = Math.abs(aStat - bStat);

		if (ans > diff) {
			ans = diff;
		}
	}

	public static int getStat(int[] array) {
		int result = 0;
		int len = n / 2;

		for (int i = 1; i <= len; i++) {
			for (int j = i + 1; j <= len; j++) {
				result += map[array[i]][array[j]];
				result += map[array[j]][array[i]];
			}
		}
		return result;
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