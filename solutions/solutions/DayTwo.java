package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class DayTwo {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int l=0,r=0,max=0;
        while(r < s.length()){
            char curr = s.charAt(r);
            if(!charSet.contains(curr)){
                charSet.add(curr);
                r++;
                max = Math.max(max, charSet.size());
            }else{
                charSet.remove(s.charAt(l));
                l++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        DayTwo d2 = new DayTwo();
        System.out.println(d2.lengthOfLongestSubstring("pwwkew"));
    }
}
