package craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private void solve() {
		int n = sc.nextInt();
		
		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
		boolean[] c = new boolean[n];
		int[] parent = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i] = new ArrayList<>();
		}
		
		for(int i=0;i<n;i++) {
			int v = sc.nextInt();
			
			// 부모 저장.
			parent[i] = v;
			
		}
		
		int root = 0;
		for(int i=0;i<n;i++) {
			int v = parent[i];
			
			if (v == -1) {
				root = i;
				continue;
			}
			
			// 부모 배열을 통한 인접리스트 생성
			
			a[v].add(i);
			a[i].add(v);
			
		}
		
		int remove = sc.nextInt();
		
		// 한번 bfs를 통해 제거할 노드의 자식들 제거 (본인 포함)
		// 그 후 다시 bfs를 통해 리프노드 탐색 
		
		bfs(a,parent,c,remove);
		System.out.println(bfs(a,parent,c,root));
		
	}
	
	public static int bfs(ArrayList<Integer>[] a, int[] parent, boolean[] c, int remove) {
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;

		if (c[remove]) {
			return 0;
		}
		
		q.add(remove);
		c[remove] = true;
		
		while(!q.isEmpty()) {
			remove = q.poll();
			boolean flag = false;
			
			for(int v : a[remove]) {
				if (!c[v] && parent[remove] != v) {
					// 방문하지 않았고, 부모정점과 현재 정점이 같지 않다면 탐색
					// 방문했거나, 부모정점과 같다면 탐색할 필요가 없다
					flag = true;
					q.add(v);
					c[v] = true;
				}
				
			}
			
			// 정점을 기준으로 탐색을 하지 못했을 경우 리프노드.
			if (!flag) {
				cnt++;
			}
			
		}
		
		return cnt;
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