package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		
		// 자신보다 왼쪽에 있는 사람의 수에 대해 키가 작은 사람순으로 먼저 자리를 채운다
		
		int n = sc.nextInt();
		int[] ans = new int[n+1];
		int[][] array = new int[n+1][1];
		boolean[] visited = new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			array[i][0] = sc.nextInt();
		}
		
		Arrays.fill(ans, 10);
		
		for(int i=1;i<=n;i++) {
			
			int k = array[i][0];
			int idx = 1;
			
			while(k > 0) {
				
				// 5 => 2 1 0 1 0
				if (idx == n) {
					break;
				}
				
				if (ans[idx] > i) {
					k--;
				}
				
				idx++;				
				
			}
			
			// 채워져있는 곳을 덮어쓰기 방지
			if (visited[idx] && idx < n) {
				while(visited[++idx]) {}				
			}
			
			ans[idx] = i;
			visited[idx] = true;
		}
		
		for(int i=1;i<=n;i++) {
			System.out.print(ans[i] + " ");
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