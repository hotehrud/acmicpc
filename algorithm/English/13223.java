package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		// same - https://www.acmicpc.net/problem/3029
		
		String[] current = sc.readLine().split(":");
		String[] explosion = sc.readLine().split(":");
		
		int currentTime = Integer.parseInt(current[0]) * 3600 + Integer.parseInt(current[1]) * 60 +  Integer.parseInt(current[2]);  
		int explosionTime = Integer.parseInt(explosion[0]) * 3600 + Integer.parseInt(explosion[1]) * 60 +  Integer.parseInt(explosion[2]);  
	
		int desireTime = currentTime < explosionTime ? explosionTime - currentTime : 86400 - currentTime + explosionTime;
		
		System.out.print(String.format("%02d:", desireTime / 3600));
		System.out.print(String.format("%02d:", (desireTime % 3600) / 60));
		System.out.print(String.format("%02d", (desireTime % 3600) % 60));
		
	}

	public static int getCount(int[] count, int x, int y) {
		int max = 0;

		for (int i = x; i <= y; i++) {

			if (count[i] >= max) {
				max = count[i];
			}

		}
		return max;
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