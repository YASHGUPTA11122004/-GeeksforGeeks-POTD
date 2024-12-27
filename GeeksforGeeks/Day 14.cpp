// Count pairs with given sum
// Difficulty: EasyAccuracy: 50.11%Submissions: 24K+Points: 2
// Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.

// Examples:

// Input: arr[] = [1, 5, 7, -1, 5], target = 6 
// Output: 3
// Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5). 
// Input: arr[] = [1, 1, 1, 1], target = 2 
// Output: 6
// Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1), (1, 1).
// Input: arr[] = [10, 12, 10, 15, -1], target = 125
// Output: 0
// Constraints:
// 1 <= arr.size() <= 105
// -104 <= arr[i] <= 104
// 1 <= target <= 104

class Solution {
public:
    int countPairs(vector<int> &arr, int target) {
        // Hash map to store the frequency of elements encountered
        unordered_map<int, int> mp;  
        int cnt = 0; // Counter to keep track of pair count

        // Traverse the array
        for (int i = 0; i < arr.size(); ++i) {
            // Required value to form a pair with arr[i]
            int req = target - arr[i];

            // Check if the required value exists in the map
            if (mp.find(req) != mp.end()) {
                cnt += mp[req]; // Add the frequency of the required value
            }

            // Increment the frequency of the current value in the map
            mp[arr[i]]++;
        }

        return cnt; // Return the total number of pairs
    }
};
