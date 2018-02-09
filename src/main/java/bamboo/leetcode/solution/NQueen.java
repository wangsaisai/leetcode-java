/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bamboo.leetcode.solution;

import java.util.*;

public class NQueen {

  static List<int[]> result = new ArrayList<>();

  static void record(int a[]) {
    int[] tmp = Arrays.copyOf(a, a.length);
    result.add(tmp);
  }

  static boolean valid(int a[], int index) {
    for (int i=0; i<index; i++) {
      if (a[index] == a[i] || a[index]-a[i] == index-i || a[index]-a[i] == i-index) {
        return false;
      }
    }

    return true;
  }

  public static List<List<String>> solveNQueens(int n) {
    int a[] = new int[n];
    traverse(a, n, 0);
    List<List<String>> list = new ArrayList<>(result.size());

    for (int[] r : result) {
      List<String> strList = new ArrayList<>();
      for (int i=0; i<n; i++) {
        char[] tmp = new char[n];
        for (int j=0; j<n; j++) {
          tmp[j] = '.';
        }
        tmp[r[i]-1] = 'Q';
        strList.add(new String(tmp));
      }
      list.add(strList);
    }

    return list;
  }

  static Set<Integer> chooseValue(int a[], int n, int index) {
    Set<Integer> set = new HashSet<>();
    for (int i=1; i<=n; i++) {
      set.add(i);
    }

    for (int j=0; j<index; j++) {
      set.remove(a[j]);
    }
    return set;
  }

  static void traverse(int a[], int n, int index) {
    if (index >= n) {
      record(a);
      return;
    }

    for(Integer v : chooseValue(a, n, index)) {
      a[index] = v;
      if (valid(a, index)) {
        traverse(a, n, index+1);
      }
    }
  }

  public static void main(String[] args) {
    for (int n=1; n<20; n++) {
      int a[] = new int[n];
      traverse(a, n, 0);

      System.out.println("num: " + n + " size: " + result.size());
//      for (int[] r : result) {
//        System.out.println(Arrays.toString(r));
//      }
      result.clear();
    }


    List<List<String>> result = solveNQueens(4);
    System.out.println("[");
    for (List<String> r : result) {
      System.out.println("  [");
      for (String tmp: r) {
        System.out.println("    " + tmp);
      }
      System.out.println("  ]");
    }
    System.out.println("]");

  }

}
