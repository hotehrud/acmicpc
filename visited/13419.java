package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		int t = sc.nextInt();
		StringBuilder result = new StringBuilder();
		
		for(int i=0;i<t;i++) {
			String s = sc.next();
			int len = s.length();
			boolean[] visited = new boolean[len];
			StringBuilder sb = new StringBuilder();
			int j = 0;
			
			// visited 배열을 통해 방문했다면 스톱
			
			while(true) {
				if (visited[j]) {
					break;
				}
				
				sb.append(s.charAt(j));
				
				visited[j] = true;
				j+=2;
				
				if (j >= len) {
					j %= len;
				}
			}
			
			sb.append("\n");
			j = 1;
			
			if (j == len) {
				sb.append(s.charAt(0) + "\n");
				result.append(sb.toString());
				continue;
			}
			
			Arrays.fill(visited, false);
			
			while(true) {
				if (visited[j]) {
					break;
				}
				
				sb.append(s.charAt(j));
				
				visited[j] = true;
				j+=2;
				
				if (j >= len) {
					j %= len;
				}
			}
			sb.append("\n");
			
			result.append(sb.toString());
		}
		System.out.println(result.toString());
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