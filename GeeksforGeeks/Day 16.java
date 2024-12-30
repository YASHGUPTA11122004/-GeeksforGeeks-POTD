// Longest Consecutive Subsequence
// Difficulty: MediumAccuracy: 33.0%Submissions: 314K+Points: 4
// Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

// Examples:

// Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
// Output: 6
// Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.
// Input: arr[] = [1, 9, 3, 10, 4, 20, 2]
// Output: 4
// Explanation: 1, 2, 3, 4 is the longest consecutive subsequence.
// Input: arr[] = [15, 13, 12, 14, 11, 10, 9]
// Output: 7
// Explanation: The longest consecutive subsequence is 9, 10, 11, 12, 13, 14, 15, which has a length of 7.
// Constraints:
// 1 <= arr.size() <= 105
// 0 <= arr[i] <= 105

class Solution 
{
    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        Arrays.sort(arr);
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i=0;i<arr.length;i++)
            set.add(arr[i]);
        int m=1;
        int count=1;
        
        Integer[] tempArray = set.toArray(new Integer[0]);
        
        int a[] = new int[tempArray.length];
        
        for (int i = 0; i < tempArray.length; i++)
            a[i] = tempArray[i];
   
        for(int i=0;i<a.length-1;i++)
            if(a[i+1]==(a[i]+1))
                count++;
            else {
                m = Math.max(m, count);
                count=1;}
                
        
        m = Math.max(m, count);

        return m;
    }
}
