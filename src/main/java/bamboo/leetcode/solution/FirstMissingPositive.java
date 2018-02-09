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

public class FirstMissingPositive {

  public static int firstMissingPositive(int[] nums) {
    int i=0;
    int len = nums.length;
    while (i < len) {
      if (nums[i] != i+1 && nums[i] > 0 && nums[i] <= len && nums[nums[i]-1] != nums[i]) {
        int tmp = nums[nums[i]-1];
        nums[nums[i]-1] = nums[i];
        nums[i] = tmp;
      } else {
        i++;
      }
    }

    for (int j=0; j<len; j++) {
      if (nums[j] != j+1)
        return j+1;
    }
    return len+1;
  }

  public static void main(String[] args) {
    System.out.println(firstMissingPositive(new int[]{0}));
    System.out.println(firstMissingPositive(new int[]{1}));
    System.out.println(firstMissingPositive(new int[]{2}));
    System.out.println(firstMissingPositive(new int[]{1, 4, 5, 2, 0, -1}));
  }
}
