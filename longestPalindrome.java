public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        String longestPalindrome = getLongestPalindrome(str);
        System.out.println("Longest palindrome in " + str + ": " + longestPalindrome);
    }
    
    public static String getLongestPalindrome(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        String longestPalindrome = "";
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == str.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLength) {
                        maxLength = i - j + 1;
                        longestPalindrome = str.substring(j, i+1);
                    }
                }
            }
        }
        return longestPalindrome;
    }
}
