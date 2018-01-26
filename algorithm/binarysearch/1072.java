package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		String s = "";
		StringBuilder sb = new StringBuilder();
		
		while((s = sc.readLine()) != null) {
			String[] input = s.split(" ");
			long x = Integer.parseInt(input[0]);
			long y = Integer.parseInt(input[1]);
			
			int target = (int)(y*100/x);
			int first=0,last=1000000001,mid=0;
			int temp;
	
			if (target >= 99) {
				sb.append("-1\n");
			} else {
				while(first <= last) {
					mid = (first+last)/2;
				
					temp = (int) ((y+mid)*100/(x+mid));
					
					if (temp > target) {
						last = mid - 1;
					} else {
						first = mid + 1;
					}
					
				}
			
				sb.append(first + "\n");	
			}
			
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