package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private void solve() {

		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		// 예제로 주어지는 문자열들을 통해 맵핑되는 문자를 찾는다.
		// 주어지는 문자열에는 q,z가 존재하지 않기 때문에 따로 넣어준다. 
		
		String Googlerese = "ejp mysljylc kd kxveddknmc re jsicpdrysi rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd de kr kd eoya kw aej tysr re ujdr lkgc jv";
		String string = "our language is impossible to understandthere are twenty six factorial possibilitiesso it is okay if you want to just giveup";
		
		Googlerese = Googlerese.replaceAll(" ", "");
		string = string.replaceAll(" ", "");
		
		char[] ans = new char[26];
		
		for(int i=0;i<Googlerese.length();i++) {
			ans[Googlerese.charAt(i) - 'a'] = string.charAt(i);
		}
		
		ans[25] = 'q';
		ans[16] = 'z';

		for(int i=1;i<=t;i++) {
			
			String s = sc.readLine();
			
			sb.append("Case #" + i + ": ");
			
			for(int j=0;j<s.length();j++) {
				
				if (s.charAt(j) == ' ') {
					sb.append(" ");
					continue;
				}
				
				sb.append(ans[s.charAt(j) - 'a']);
			}
			
			sb.append("\n");
			
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