package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int ans;
	
	private void solve() {

		// DFS 비슷
		// 재귀를 통해 구현 - 1,1 에서 출발하여 n,m 으로  도착한 개수
		
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] map = new int[n + 1][m + 1];
 
		for (int i = 1; i <= n; i++) {

//			String[] s = sc.readLine().split(" ");

			for (int j = 1; j <= m; j++) {

				map[i][j] = Integer.parseInt(sc.next());

			}

		}

		move(map,1,1);
		
		System.out.println(ans);
	
	}

	public static void move(int[][] map, int x, int y) {
		
		if (n == y && m == x) {
			ans++;
			return;
		}
		
		for(int i=0;i<4;i++) {
			
			int xx = dx[i] + x;
			int yy = dy[i] + y;
			
			if (1 > xx || xx > m || 1 > yy || yy > n) {
				continue;
			}
			
			if (map[y][x] > map[yy][xx]) {
				move(map,xx,yy);
			}
			
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