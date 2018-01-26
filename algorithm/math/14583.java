package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private void solve() {
		// http://mygumi.tistory.com/166
		double h = sc.nextDouble();
		double v = sc.nextDouble();

		double d = Math.sqrt(h * h + v * v);

		// 각의 이등분선의 성질 a : b = h : d
		
		double a = v * (h / (h + d));
		double b = v * (d / (h + d));
		
		double c = Math.sqrt(a * a + h * h);
		
		// c * k = 평행사변형의 넓이
		// 평행사변형의 높이 = (b * h) / c
		
		System.out.format("%.2f", c / 2);
		System.out.print(" ");
		System.out.format("%.2f", (b * h) / c);
		
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

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}