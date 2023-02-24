import java.util.HashMap;
import java.util.Map;

public class SecondMostFrequentCharacter {
    public static void main(String[] args) {
        String str = "aabbcddddeee";
        char secondMostFrequentChar = getSecondMostFrequentChar(str);
        System.out.println("String: " + str);
        System.out.println("Second most frequent character: " + secondMostFrequentChar);
    }
    
    public static char getSecondMostFrequentChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int maxFreq = 0;
        int secondMaxFreq = 0;
        char secondMostFrequentChar = ' ';
        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (freq > maxFreq) {
                secondMaxFreq = maxFreq;
                maxFreq = freq;
                secondMostFrequentChar = c;
            } else if (freq > secondMaxFreq && freq != maxFreq) {
                secondMaxFreq = freq;
                secondMostFrequentChar = c;
            }
        }
        return secondMostFrequentChar;
    }
}
