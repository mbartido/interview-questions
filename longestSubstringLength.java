// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// Given a string, find the length of the longest 
// substring without repeating characters.
// Examples:
// Given "abcabcbb", the answer is "abc", which the 
// length is 3.
// Given "bbbbb", the answer is "b", with the length of 1.
// Given "pwwkew", the answer is "wke", 
// with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.



// Unoptimal O(n^3)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        return longestSubstringLength(s);
    }
    
    public int longestSubstringLength(String s) {
        int length = s.length();
        int sum = 0;
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j <= length; j++){
                if (isUniqueSubstring(s, i, j)) {
                    sum = Math.max(sum, j - i);
                } 
            }
        }
        return sum;
    }
    
    
    // Returns true if all the characters are unique in substring
    public boolean isUniqueSubstring(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        // Go through string and check to see if all characters
        // were already in it
        for (int i = start; i < end; i++){
            if (set.contains(s.charAt(i))) return false;
            set.add(s.charAt(i));
        }
        return true;
    }
}

// Optimal O(n) solution
// Uses sliding window
class Solution2 {
  public int lengthOfLongestSubstring(String s) {
      Set<Character> set = new HashSet<>();
      int length = s.length();
      int i = 0;
      int j = 0;
      int ans = 0;
      
      while (i < length && j < length){
          // If set already has character at j
          // extend j's bounds
          if (!set.contains(s.charAt(j))){
              set.add(s.charAt(j));
              j++;
              ans = Math.max(ans, j - i);
          
          // If set doesn't have character at j
          // remove character at i and then extend i
          } else {
              set.remove(s.charAt(i));
              i++;
          }
      }
      return ans;
  }
    
}