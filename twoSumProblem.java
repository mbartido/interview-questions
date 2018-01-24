// https://leetcode.com/problems/two-sum/description/
// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
// You may assume that each input would have exactly one solution, 
// and you may not use the same element twice.
// Example:
// Given nums = [2, 7, 11, 15], target = 9,
// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

import java.util.Hashtable;
import java.util.Arrays;

public class twoSumProblem {
    public static int[] twoSum(int[] nums, int target) {
        // Make hashtable
        Hashtable<Integer, Integer> holder = new Hashtable<Integer, Integer>();
        int[] retValue = new int[2];
        
        // Put in hashtable
        // Key is array value, value is array index
        for (int i = 0; i < nums.length; i++){
            holder.put(nums[i], i);
        }
        
        // Look up in hashtable
        for (int i = 0; i < nums.length; i++){
            if (holder.containsKey(target - nums[i])){
                int j = holder.get(target - nums[i]);
                retValue[1] = i;
                retValue[0] = j;
            }
        }
        return retValue;
    }

    public static void main(String[] args){
        int[] testArr = {1, 5, 6};
        int target = 7;
        int[] answer = {0, 2};
        int[] twoSumAnswer = twoSum(testArr, target);
        boolean retval = Arrays.equals(twoSumAnswer, answer);
        System.out.println(Arrays.toString(twoSumAnswer));
        System.out.println(retval);

    }
}


