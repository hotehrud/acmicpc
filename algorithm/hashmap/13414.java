package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
	
	private void solve() {
		int k = sc.nextInt();
		int l = sc.nextInt();
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		LinkedHashMap<String, Boolean> hm = new LinkedHashMap<>();
		
		// 순서를 유지하는 LinkedHashMap을 사용하되 중복 시 제거 후 다시 삽입.
		
		for(int i=0;i<l;i++) {
			String uid = sc.readLine();
			
			if (hm.containsKey(uid)) {
				hm.remove(uid);
			}
			
			hm.put(uid, false);
		}
		
		for( String key : hm.keySet() ){
			if (!key.isEmpty()) {
				sb.append(key + "\n");
				cnt++;
				if (k == cnt) {
					break;
				}
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