package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 방향 그래프 v2->v1와 같이 정점 반대로 생각
		
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
		boolean[] c = new boolean[n+1];
		int[] ans = new int[n+1];

		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			a[v2].add(v1);
		}

		Queue<Integer> q = new LinkedList<>();

		int max = 0;
		int idx = 0;
		for(int i=1;i<=n;i++) {
			int cnt = 0;
			Arrays.fill(c, false);
			
			q.add(i);
			c[i] = true;
			while (!q.isEmpty()) {
				
				int v = q.poll();
				
				for(int x : a[v]) {
					
					if (!c[x]) {
						q.add(x);
						c[x] = true;
						cnt++;
					}
					
				}
				
			}
			
			// 이전 값 유지 max 값들 구하기
			if (max < cnt) {
				idx = 0;
				max = cnt;
				ans[idx++] = i;
			} else if (max == cnt) {
				ans[idx++] = i;
			}
			
		}
		
		for(int i=0;i<idx;i++) {
			sb.append(ans[i] + " ");
		}
		
		System.out.println(sb.toString());
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