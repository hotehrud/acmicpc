import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dice = new int[7];
	static int[][] map = new int[20][20];
	static int[] dx = { 1, -1, 0, 0 }; // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
	static int[] dy = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();

	private void solve() {
		// http://mygumi.tistory.com/244
		int n = sc.nextInt();
		int m = sc.nextInt();
		int y = sc.nextInt();
		int x = sc.nextInt();
		int k = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < k; i++) {
			int d = sc.nextInt();
			int nx = dx[d - 1] + x;
			int ny = dy[d - 1] + y;

			if (0 <= nx && nx < m && 0 <= ny && ny < n) {
				changeDice(d);
				
				if (map[ny][nx] == 0) {
					map[ny][nx] = dice[6];
				} else {
					dice[6] = map[ny][nx];
					map[ny][nx] = 0;
				}
				
				x = nx;
				y = ny;
				sb.append(dice[1] + "\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static void changeDice(int d) {
		int[] temp = dice.clone();
		// 6 밑면, 1 윗면
		// 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
		if (d == 1) {
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[6] = temp[3];
		} else if (d == 2) {
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[6] = temp[4];
		} else if (d == 3) {
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[5] = temp[6];
			dice[6] = temp[2];
		} else {
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[5] = temp[1];
			dice[6] = temp[5];
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