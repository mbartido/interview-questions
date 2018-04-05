// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

// For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
// the contiguous subarray [4,-1,2,1] has the largest sum = 6.

import java.lang.*;

class Solution {
    public int maxSubArray(int[] nums) {
        int[] DP = new int[nums.length];
        DP[0] = nums[0];
        int max = DP[0];
        int l = 0, r = 0;
        
        for (int i = 1; i < DP.length; i++) {
            DP[i] = nums[i] + (DP[i-1] > 0? DP[i-1] : 0);
            if (DP[i-1] > 0) r += 1;
            else l = i;
            max = Math.max(DP[i], max);
        }
        System.out.println("l: " + l);
        System.out.println("r: " + r);
        return max;
        
    }
}