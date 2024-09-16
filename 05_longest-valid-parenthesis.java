//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        // Stack to store the indices of parentheses
        Stack<Integer> stack = new Stack<>();
        // Push -1 as an initial index to handle edge cases
        stack.push(-1);
        int maxLength = 0;

        // Iterate through the string
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // If an opening parenthesis is found, push its index
            if (c == '(') {
                stack.push(i);
            } 
            // If a closing parenthesis is found
            else {
                stack.pop();

                // If the stack is empty, push the current index as a new base
                if (stack.isEmpty()) {
                    stack.push(i);
                } 
                // Calculate the length of the valid substring
                else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}