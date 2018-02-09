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

public class MinDistance {

  int min(int x1 , int x2) {
    return x1 < x2 ? x1 : x2;
  }

  int min(int x1, int x2, int x3) {
    return min(min(x1, x2), x3);
  }

  public int minDistance(String word1, String word2) {
    char[] c1 = word1.toCharArray();
    char[] c2 = word2.toCharArray();

    int l1 = c1.length;
    int l2 = c2.length;

    int[][] result = new int[l1+1][l2+1];

    for (int i=0; i<=l1; i++) {
      result[i][0] = i;
    }

    for (int j=0; j<=l2; j++) {
      result[0][j] = j;
    }

    for (int i=0; i<l1; i++) {
      for (int j=0; j<l2; j++) {
        if (c1[i] == c2[j]) {
          result[i+1][j+1] = result[i][j];
        } else {
          result[i+1][j+1] = min(result[i+1][j], result[i][j+1], result[i][j]) + 1;
        }
      }
    }

    return result[l1][l2];
  }

  public static void main(String[] args) {
    MinDistance md = new MinDistance();
    System.out.println(md.minDistance("abcde", "abc"));
    System.out.println(md.minDistance("abc", "abcde"));
    System.out.println(md.minDistance("abced", "abcde"));
    System.out.println(md.minDistance("a", "b"));
    System.out.println(md.minDistance("", ""));
    System.out.println(md.minDistance("a", ""));
    System.out.println(md.minDistance("", "a"));
  }

}
