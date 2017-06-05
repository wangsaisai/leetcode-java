package bamboo.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @url https://leetcode.com/problems/trapping-rain-water
 *
 * @desc Given n non-negative integers representing an elevation map where the width of each bar is 1,
 *       compute how much water it is able to trap after raining.
 *
 * @example Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {

  public int trap(int[] height) {
    int len = height.length;
    if (len == 0)
      return 0;
    Map<Integer, Integer> tailMax = new HashMap<>(len);

    int max = height[len-1];
    tailMax.put(len-1, max);
    for (int i=len-2; i>=0; i--) {
      max = max > height[i] ? max : height[i];
      tailMax.put(i, max);
    }

    int count = 0;
    int preMax = height[0];
    for (int i=1; i<len; i++) {
      if (height[i] < preMax && height[i] < tailMax.get(i)) {
        preMax = preMax < tailMax.get(i) ? preMax : tailMax.get(i);
        while(i < len && height[i] < preMax) {
          count += preMax - height[i];
          i++;
        }
      }

      if (i < len)
        preMax = height[i];

    }
    return count;

  }

  public static void main(String[] args) {
    TrappingRainWater t = new TrappingRainWater();
    System.out.println(t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    System.out.println(t.trap(new int[]{4,2,3}));
  }

}
