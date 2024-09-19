// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character after integer input
        while (t > 0) {
            String s = sc.nextLine();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // Split the string by the dot delimiter
        String[] words = str.split("\\.");
        
        // Initialize a StringBuilder to store the result
        StringBuilder reversedStr = new StringBuilder();
        
        // Traverse the words array from the last word to the first word
        for (int i = words.length - 1; i >= 0; i--) {
            reversedStr.append(words[i]);
            // Append a dot between words, but not after the last word
            if (i != 0) {
                reversedStr.append(".");
            }
        }
        
        return reversedStr.toString();
    }
}
