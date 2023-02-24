import java.util.HashSet;
import java.util.Set;

public class StringDuplicatesRemoval {
    public static void main(String[] args) {
        String str = "hello world";
        String strWithoutDuplicates = removeDuplicates(str);
        System.out.println("Original string: " + str);
        System.out.println("String without duplicates: " + strWithoutDuplicates);
    }
    
    public static String removeDuplicates(String str) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
           
