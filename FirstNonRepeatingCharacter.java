import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "aabbcdddefg";
        char firstNonRepeatingChar = getFirstNonRepeatingChar(str);
        System.out.println("String: " + str);
        System.out.println("First non-repeating character: " + firstNonRepeatingChar);
    }
    
    public static char getFirstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }
}
