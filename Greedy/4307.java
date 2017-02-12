package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		
		// 그리디
		// 가장 느린 시간은 양쪽 끝
		// 가장 빠른 시간은 방향별로 비교하면서 최대값
		
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		
		while(t-->0) {
			
			int l = sc.nextInt();
			int n = sc.nextInt();
			int fast = 0, slow = 0;
			
			int[] array = new int[n];
			
			for(int i=0;i<n;i++) {
				
				array[i] = sc.nextInt();
				
			}
			
			Arrays.sort(array);
			
			slow = (l - array[0]) > array[n-1] ? (l - array[0]) : array[n-1];
			
			for (int pos : array) {
				int tmp = (l - pos) > pos ? pos : (l - pos);
				
				if (tmp > fast) {
					fast = tmp;
				}
			}
			
			sb.append(fast + " " + slow + "\n");
			
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