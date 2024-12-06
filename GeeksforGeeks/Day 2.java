// Strings Rotations of Each Other
// You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.

// Note: The characters in the strings are in lowercase.

// Examples :
// Input: s1 = "abcd", s2 = "cdab"
// Output: true
// Explanation: After 2 right rotations, s1 will become equal to s2.

// Input: s1 = "aab", s2 = "aba"
// Output: true
// Explanation: After 1 left rotation, s1 will become equal to s2.

// Input: s1 = "abcd", s2 = "acbd"
// Output: false
// Explanation: Strings are not rotations of each other.

// Constraints:
// 1 <= s1.size(), s2.size() <= 105


Solution:
class Solution 
{
    public static boolean areRotations(String s1, String s2) 
    {
        StringBuilder obj = new StringBuilder(s2);
        int m = s2.length();
        obj.append('$');
        obj.append(s1);
        obj.append(s1);
        s1 = new String(obj);
        int n = s1.length();
        int lps[] = new int[n];
        int len = 0;
        int i =1;
        while(i<n)
        {
            if(s1.charAt(i) ==s1.charAt(len))
            {
                len++;
                if(len==m)
                {
                    return true;
                }
                lps[i] =len;
                i++;
            }
            else
            {
                if(len>0)
                {
                    len =lps[len-1];
                }
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return false;
    }
}
