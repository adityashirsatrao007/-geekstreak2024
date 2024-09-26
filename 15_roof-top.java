//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String st[] = read.readLine().trim().split("\\s+");
            int n = st.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[(int)i] = Integer.parseInt(st[(int)i]);

            System.out.println(new Solution().maxStep(arr));
        }
    }
}

// } Driver Code Ends





class Solution {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        int maxSteps = 0; // To store the maximum number of steps
        int currentSteps = 0; // To store the current number of consecutive steps

        // Traverse the array to find consecutive buildings with increasing heights
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                // If the current building is taller than the previous, increment currentSteps
                currentSteps++;
                // Update maxSteps if currentSteps is greater
                maxSteps = Math.max(maxSteps, currentSteps);
            } else {
                // Reset currentSteps if there's no increase in altitude
                currentSteps = 0;
            }
        }

        return maxSteps;
    }
}
