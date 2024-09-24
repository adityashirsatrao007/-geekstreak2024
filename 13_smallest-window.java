//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        if (s.length() < p.length()) return "-1";

        // Frequency map for the pattern string
        int[] patFreq = new int[26];
        for (char c : p.toCharArray()) {
            patFreq[c - 'a']++;
        }

        int[] strFreq = new int[26];
        int start = 0, minLen = Integer.MAX_VALUE, count = 0;
        int startIdx = -1;

        for (int end = 0; end < s.length(); end++) {
            // Include current character in the window
            char currChar = s.charAt(end);
            strFreq[currChar - 'a']++;

            // If this character is part of the pattern and count is valid
            if (patFreq[currChar - 'a'] != 0 && strFreq[currChar - 'a'] <= patFreq[currChar - 'a']) {
                count++;
            }

            // When all characters from the pattern are included in the window
            while (count == p.length()) {
                // Update minimum length and start index
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    startIdx = start;
                }

                // Try to shrink the window from the left
                char leftChar = s.charAt(start);
                strFreq[leftChar - 'a']--;

                // If we remove a valid character, reduce count
                if (patFreq[leftChar - 'a'] != 0 && strFreq[leftChar - 'a'] < patFreq[leftChar - 'a']) {
                    count--;
                }
                start++;
            }
        }

        // If no window found
        if (startIdx == -1) return "-1";

        // Return the smallest window
        return s.substring(startIdx, startIdx + minLen);
    }
}