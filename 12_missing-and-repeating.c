//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends

class Solution {
  public:
    vector<int> findTwoElement(vector<int>& arr) {
        int n = arr.size();
        vector<int> result(2); // result[0] = repeating, result[1] = missing
        
        // Step 1: Use index marking to find the repeating number
        for (int i = 0; i < n; i++) {
            int absVal = abs(arr[i]);
            if (arr[absVal - 1] > 0) {
                arr[absVal - 1] = -arr[absVal - 1]; // Mark the index as visited
            } else {
                result[0] = absVal; // Repeating number found
            }
        }

        // Step 2: Find the missing number
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) { // The index that was never visited (i.e., positive value)
                result[1] = i + 1; // Missing number found
                break;
            }
        }

        return result;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> a(n);
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        auto ans = ob.findTwoElement(a);
        cout << ans[0] << " " << ans[1] << "\n";
    }
    return 0;
}
// } Driver Code Ends