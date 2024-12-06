// # Min Chars to Add for Palindrome
// Difficulty: HardAccuracy: 46.79%Submissions: 65K+Points: 8
// Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.

// Note: A palindrome string is a sequence of characters that reads the same forward and backward.

// Examples:

// Input: s = "abc"
// Output: 2
// Explanation: Add 'b' and 'c' at front of above string to make it palindrome : "cbabc"
// Input: s = "aacecaaaa"
// Output: 2
// Explanation: Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"
// Constraints:
// 1 <= s.size() <= 106

class Solution 
{
    public static int minChar(String s) 
    {
        int n=s.length();
        String new_str = s+"$"+(new StringBuilder(s).reverse().toString());
        int lps[] = new int[2*n+1];
        fill(lps,new_str,2*n+1);
        return n-lps[2*n];
    }
    static void fill(int a[],String s,int n)
    {
        int i=0, j=1;
        while(j<n)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                a[j]=i;
                j++;
            }
            else
            {
                if(i==0)    j++;
                else    i=a[i-1];
            }
        }
    }
}
