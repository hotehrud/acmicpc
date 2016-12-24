package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			char[] before = sc.readLine().toCharArray();
			char[] after = sc.readLine().toCharArray();
			int cnt = 0;
			
			for(int j=0;j<n;j++) {
				boolean flag = false;
				
				// 스왑을 우선 순위를 둔다.
				// 같지 않을 경우 다음 문자를 비교해서 두 배열의 다음 문자가 다르고, 전 배열 문자와 후 배열의 다음 문자가 다를 경우 스왑

				if (before[j] != after[j]) {
					
					for(int k=j+1;k<n;k++) {
						
						if (before[k] != after[k] && before[j] != before[k]) {
							flag = true;
							before[j] = after[j];
							before[k] = after[k];
							cnt++;
							break;
						}
						
					}
					
					if (!flag) {
						before[j] = after[j];
						cnt++;
					}	
				}
				
			}
			sb.append(cnt + "\n");
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