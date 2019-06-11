package com.mycompany.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  // http://mygumi.tistory.com/196
  static ArrayList<String> list = new ArrayList<String>();
  static int[] newAlph;
  static int n, k, ans, temp, cnt;

  private void solve() {
    n = sc.nextInt();
    k = sc.nextInt();
    int start = 97;

    list = new ArrayList<String>();

    for (int i = 0; i < n; i++) {
      String input = sc.readLine();
      input = input.replaceAll("[antic]", "");
      list.add(input);
    }

    if (k < 5) {
      System.out.println(0);
      return;
    } else if (k == 26) {
      System.out.println(n);
      return;
    }

    for (int i = 0; i < 26; i++) {
      boolean[] teach = new boolean[26];
      teach[0] = true;
      teach[2] = true;
      teach[8] = true;
      teach[13] = true;
      teach[19] = true;
      cnt = 5;
      if (!teach[i]) {
        ++cnt;
      }
      backTracking(teach, start);
      start++;
    }
    System.out.println(ans);
  }

  public static void backTracking(boolean[] array, int start) {
    array[start - 97] = true;

    if (cnt == k) {
      temp = check(array);
      ans = Math.max(ans, temp);
    } else {
      for (int i = start + 1; i < 123; i++) {
        if (!array[i - 97]) {
          ++cnt;
          backTracking(array, i);
        }
      }
    }
    array[start - 97] = false;
    --cnt;
  }

  public static int check(boolean[] array) {
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      boolean flag = true;
      char[] word = list.get(i).toCharArray();
      for (int v : word) {
        if (!array[v - 97]) {
          flag = false;
          break;
        }
      }
      if (flag) {
        ++cnt;
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

    static boolean hasNext() {
      return st.hasMoreTokens();
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