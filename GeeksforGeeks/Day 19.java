// Count Subarrays with given XOR
// Difficulty: MediumAccuracy: 58.86%Submissions: 17K+Points: 4
// Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

// Examples: 

// Input: arr[] = [4, 2, 2, 6, 4], k = 6
// Output: 4
// Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
// Input: arr[] = [5, 6, 7, 8, 9], k = 5
// Output: 2
// Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.
// Input: arr[] = [1, 1, 1, 1], k = 0
// Output: 4
// Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].
// Constraints:

// 1 ≤ arr.size() ≤ 105
// 0 ≤ arr[i] ≤105

class Solution 
{
    public long subarrayXor(int[] arr, int k) 
   {
     Map<Integer, Integer> prefixXorCount = new HashMap<>();
     prefixXorCount.put(0, 1);
     long count = 0;
     int xor = 0;
 
     for (int num : arr) 
     {
        xor ^= num; 
        int target = xor ^ k; 
        
        count += prefixXorCount.getOrDefault(target, 0);
        
        prefixXorCount.put(xor, prefixXorCount.getOrDefault(xor, 0) + 1);
     }
     return count;
    }


}
