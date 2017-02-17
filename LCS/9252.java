package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		char[] A = sc.readLine().toCharArray();
		char[] B = sc.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();

		// Case 1:
		// String A: "ABCD", String B: "AEBD"
		// LCS("ABCD", "AEBD") = 1 + LCS("ABC", "AEB")
		//
		// Case 2:
		// String A: "ABCDE", String B: "AEBDF"
		// LCS("ABCDE", "AEBDF") = Max(LCS("ABCDE", "AEBD"), LCS("ABCD",
		// "AEBDF"))

		int[][] LCS = new int[A.length + 1][B.length + 1];
		String[][] solution = new String[A.length + 1][B.length + 1];

		for (int i = 1; i <= A.length; i++) {

			for (int j = 1; j <= B.length; j++) {

				if (A[i - 1] == B[j - 1]) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;

					solution[i][j] = "diagonal";
				} else {
					LCS[i][j] = Math.max(LCS[i][j - 1], LCS[i - 1][j]);

					if (LCS[i][j] == LCS[i - 1][j]) {
						solution[i][j] = "top";
					} else {
						solution[i][j] = "left";
					}
				}

			}

		}
		
		int a = A.length;
		int b = B.length;
		
		while(solution[a][b] != null) {
			
			if (solution[a][b] == "diagonal") {
				sb.append(A[a-1]);
				
				a--;
				b--;
			} else if (solution[a][b] == "top") {
				a--;
			} else if (solution[a][b] == "left") {
				b--;
			}
			
		}
		
		System.out.println(LCS[A.length][B.length]);
		System.out.println(sb.reverse().toString());
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
				String input = br.readLine();

				st = new StringTokenizer(input);

				return input;
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

		static boolean hasNext() {
			return st.hasMoreTokens();
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