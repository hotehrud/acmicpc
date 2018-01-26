import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	// https://github.com/hotehrud/acmicpc
	// http://mygumi.tistory.com/267
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static char[][] map = new char[12][6];
	static boolean[][] visited;
	static ArrayList<Point> list;

	private void solve() {
		int ans = 0;

		for (int i = 0; i < 12; i++) {
			map[i] = sc.readLine().toCharArray();
		}

		// 1. 모든 곳을 돌면서 터트릴 수 있는 뿌요 찾기(크기 4이상).
		// 2. 터트릴 수 있는 뿌요 있다면 모두 터트리기.
		// 3. 터트린 곳 메꾸기 위해 맵 다시 그리기

		while (true) {
			boolean flag = false;
			visited = new boolean[12][6];

			// 터트릴 수 있는 뿌요가 여러 그룹으로 나누어 있을 수 있기 때문에 하나의 정점을 기준으로 모두 탐색.
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (!visited[i][j] && map[i][j] != '.') {
						list = new ArrayList<Point>();
						dfs(i, j, map[i][j]);
						if (list.size() >= 4) {
							flag = true;
							for (Point p : list) {
								map[p.y][p.x] = '.';
							}
						}
					}
				}
			}

			if (!flag) {
				break;
			} else {
				ans++;
			}

			paint();
		}
		System.out.println(ans);
	}

	public static void paint() {
		for (int i = 0; i < 6; i++) {
			for (int j = 10; j >= 0; j--) {
				for (int k = 11; k > j; k--) {
					if (map[j][i] != '.' && map[k][i] == '.') {
						map[k][i] = map[j][i];
						map[j][i] = '.';
						break;
					}
				}
			}
		}
	}

	public static void dfs(int y, int x, char ch) {
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (0 <= nx && nx < 6 && 0 <= ny && ny < 12) {
				if (!visited[ny][nx] && map[ny][nx] == ch) {
					list.add(new Point(ny, nx));
					visited[ny][nx] = true;
					dfs(ny, nx, ch);
				}
			}
		}
	}

	public static class Point {
		int y, x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
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