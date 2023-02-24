public static String shortestSubstring(String str, String chars) {
    int[] charCount = new int[256];
    for (int i = 0; i < chars.length(); i++) {
        charCount[chars.charAt(i)]++;
    }
    int left = 0;
    int right = 0;
    int count = chars.length();
    int minLen = Integer.MAX_VALUE;
    String result = "";
    while (right < str.length()) {
        if (charCount[str.charAt(right)] > 0) {
            count--;
        }
        charCount[str.charAt(right)]--;
        right++;
        while (count == 0) {
            if (right - left < minLen) {
                minLen = right - left;
                result = str.substring(left, right);
            }
            if (charCount[str.charAt(left)] == 0) {
                count++;
            }
            charCount[str.charAt(left)]++;
            left++;
        }
    }
    return result;
}
