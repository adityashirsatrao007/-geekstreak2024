//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static int rotateDelete(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int k = 1; k <= n / 2; k++) {
            // Rotate the array by 1 (right rotation)
            int last = arr.remove(arr.size() - 1);  // Remove last element
            arr.add(0, last);                       // Add it to the front

            // Delete the (n - k + 1)th element
            int deleteIndex = arr.size() - k;       // Calculate the index for (n-k+1)th element
            arr.remove(deleteIndex);                // Remove the element at (n-k+1)th position
        }
        return arr.get(0); // Return the first element
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> arr = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr.add(Integer.parseInt(token));
            }

            Solution obj = new Solution();
            int res = obj.rotateDelete(arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends