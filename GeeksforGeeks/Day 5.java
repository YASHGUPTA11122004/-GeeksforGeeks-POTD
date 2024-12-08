// Overlapping Intervals
// Difficulty: MediumAccuracy: 57.41%Submissions: 79K+Points: 4
// Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

// Examples:

// Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
// Output: [[1,4], [6,8], [9,10]]
// Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which on merging will become [1,4]. Therefore we will return [[1,4], [6,8], [9,10]].
// Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
// Output: [[1,9]]
// Explanation: In the given intervals all the intervals overlap with the interval [1,9]. Therefore we will return [1,9].
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 0 ≤ starti ≤ endi ≤ 105




class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        
        List<int[]>ans=new ArrayList<>();
        int n=arr.length;
        
        for(int i=0;i<n;i++){
            int start=arr[i][0];
            int end=arr[i][1];
            
            if(!ans.isEmpty() && ans.get(ans.size()-1)[1]>=start){
                int []last=ans.get(ans.size()-1);
                last[1]=Math.max(last[1],end);
            }
            else{
                ans.add(new int[]{start,end});
            }
        }
        return ans;
    }
}

