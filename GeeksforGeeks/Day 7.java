// Non-overlapping Intervals
// Difficulty: MediumAccuracy: 53.11%Submissions: 10K+Points: 4
// Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ]. Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

// Examples:

// Input: intervals[][] = [[1, 2], [2, 3], [3, 4], [1, 3]]
// Output: 1
// Explanation: [1, 3] can be removed and the rest of the intervals are non-overlapping.
// Input: intervals[][] = [[1, 3], [1, 3], [1, 3]]
// Output: 2
// Explanation: You need to remove two [1, 3] to make the rest of the intervals non-overlapping.
// Input: intervals[][] = [[1, 2], [5, 10], [18, 35], [40, 45]]
// Output: 0
// Explanation: All ranges are already non overlapping.
// Constraints:
// 1 ≤ intervals.size() ≤  105
// |intervalsi| == 2
// 0 ≤ starti < endi <=5*104

class Solution 
{
    static int minRemoval(int intervals[][]) 
    {
        // code here
        if(intervals==null || intervals.length==1)
        {
            return 0;
        }
        
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        
        int[] currentInterval = intervals[0];
        int count=0;
        
        for(int i=1;i<intervals.length;i++)
        {
            if(currentInterval[1]>intervals[i][0])
            {
                count++;
            }
            else
            {
                currentInterval=intervals[i];
            }
        }
        return count;
    }
}
