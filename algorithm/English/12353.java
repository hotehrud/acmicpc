package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		// http://mygumi.tistory.com/119
		
		for (int i=1;i<=t;i++) {

			String[] s = sc.readLine().split(" ");

			int sex = s[0].charAt(0);
			double inches = 4.0;

			if (sex == 'B') {
				sex = 5;
			} else {
				sex = -5;
			}

			double height = getHeight(s[1], s[2], sex);
			
			if (height != (int) height) {
				inches = 3.5;
			}
			
			sb.append("Case #" + i + ": " + output((int) (height-inches)) + " to " + output((int) (height+inches)) + "\n"); 
			
			
		}
		System.out.println(sb.toString());
	}

	public static String output(int height) {

		int feet = height / 12;
		int inches = height % 12;

		return feet + "'" + inches + '"';
	}

	public static double getHeight(String mother, String father, int inches) {

		return (toInches(mother) + toInches(father) + inches) / 2.0;

	}

	public static double toInches(String s) {
		String[] split = s.split("'");
		double feet = Double.parseDouble(split[0]);
		double inches = Double.parseDouble(split[1].substring(0, split[1].length() - 1));

		return (feet * 12.0 + inches);
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