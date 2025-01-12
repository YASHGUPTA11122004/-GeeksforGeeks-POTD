// Trapping Rain Water
// Difficulty: HardAccuracy: 33.14%Submissions: 449K+Points: 8
// Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 

// Examples:

// Input: arr[] = [3, 0, 1, 0, 4, 0 2]
// Output: 10
// Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.

// Input: arr[] = [3, 0, 2, 0, 4]
// Output: 7
// Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.
// Input: arr[] = [1, 2, 3, 4]
// Output: 0
// Explanation: We cannot trap water as there is no height bound on both sides.
// Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
// Output: 9
// Explanation: Total water trapped = 0 + 1 + 0 + 1 + 3 + 4 + 0 = 9 units.
// Constraints:
// 1 < arr.size() < 105
// 0 < arr[i] < 103


  
class Solution {
    public int maxWater(int arr[]) {
        // code here
         int n = arr.length;
        // calculate left maximum boundary
        int leftmaxBoundary[] = new int[n];
        leftmaxBoundary[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftmaxBoundary[i] = Math.max(arr[i], leftmaxBoundary[i - 1]);
        }
        // calculate right max boundary
        int rightMaxBoundary[] = new int[n];
        rightMaxBoundary[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxBoundary[i] = Math.max(arr[i], rightMaxBoundary[i + 1]);

        }
        int trappedwater = 0;
        // loop
        // water level=minimum(leftmaximum boundary,right max boundary)
        for (int i = 0; i < n; i++) {
            // to find the water level
            int waterLevel = Math.min(leftmaxBoundary[i], rightMaxBoundary[i]);
            // trapped water=====(Water level-height)*width
            trappedwater += (waterLevel - arr[i]) * 1;

        }
        return trappedwater;
    }
}
