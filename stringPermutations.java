import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
    public static void main(String[] args) {
        String str = "abc";
        Set<String> permutations = getPermutations(str);
        System.out.println("Permutations of " + str + ": " + permutations);
    }
    
    public static Set<String> getPermutations(String str) {
        Set<String> set = new HashSet<>();
        if (str == null || str.isEmpty()) {
            set.add("");
            return set;
        }
        char firstChar = str.charAt(0);
        String restOfStr = str.substring(1);
        Set<String> words = getPermutations(restOfStr);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                set.add(word.substring(0, i) + firstChar + word.substring(i));
            }
        }
        return set;
    }
}
