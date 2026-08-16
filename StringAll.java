import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StringAll {
    //1.Reverse the String 
    public static void reverse(String s) {  // 2 pointer Approach
        // Convert string to character array for in-place operations
        char word[] = s.toCharArray();
        int first = 0;
        int end = s.length() - 1;

        while (first < end) {
            char temp = word[first];
            word[first] = word[end];
            word[end] = temp;
            
            first++;  // incresing the index
            end--;  // decrising the index
        }
        // Convert char array back to string
        String reversed = new String(word);
        System.out.println(reversed);
    }

    //2.reverse words in a sentence
    public static void reverseSentence(String s) {
        String word[] = s.split(" ");

        StringBuilder reverseSentence = new StringBuilder();
        for (int i = word.length - 1; i >= 0; i--) {
            reverseSentence.append(word[i]).append(" "); // also used " " for append(" ")
        }
        System.out.println(reverseSentence.toString());
    }

    //3.palindrome
    public static void isPalindrome(String s) {
        boolean isPalindrome = true;
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                isPalindrome = false;
                break;
            }
            else{
                isPalindrome = true;
            }
        }
        if (isPalindrome == true) {
            System.out.println("it is Palindrome");
        }
        else {
            System.out.println("it is not Palindrome");
        }
    }

    //4. Vowel Consonant Counter
    public static void VowelConsonantCounter(String s) {
        s = s.toLowerCase(); // change into lower case

        int vowel = 0;
        int consonant = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowel++;
            }
            else {
                consonant++;
            }
        }
        System.out.println("Vowel = " + vowel);
        System.out.println("Consonant = " + consonant);

    }

    //5.Anagram 
    public static void anagram(String s, String p) {
        int letter[] = new int[26];

        if (s.length() != p.length()) {
            System.out.println("Not Anagram");
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a']++;
            letter[p.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letter[i] != 0) {
                System.out.println("Not Anagram");
                return;
            }
        }
        System.out.println("It is Anagram");
    }

    // 6. Count the Frequency
    public static void countFrequency(String s) {
        s = s.toLowerCase(); // change into lowercase 

        int freq[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                freq[ch - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                char ch = (char)(i + 'a');
                System.out.println(ch + " = " + freq[i]);
            }
        }
    }

    // 7. Remove Duplicate
    public static void removeDuplicate(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (result.indexOf(ch) == -1) {
                result += ch;
            }
        }
        System.out.println(result);
    }

    // 8. Captical First letter
    public static void CapticalFirstLetter(String s) {
        String result = "";

        String words[] = s.split(" "); // java  is a => "java" "is" "a"

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (!word.isEmpty()) {
                result += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
            }
        }
        System.out.println(result);
    }

    // 9. Longest word in the sentence 
    public static void longestWord(String s) {
        String words[] = s.split(" ");
        String longest = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }
        System.out.println(longest);
        System.out.println("length = " + longest.length());
    }

    //10. First Non-Repeating Character
    public static void FirstNonRepeatingChar(String s) {
        char result = '\0';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                result = ch;
                break;
            }
        }
        if (result == '\0') {
            System.out.println("None");
        }
        else {
            System.out.println("First repetaing char = " + result);
        }
    }

    // 11 Maximum Nesting Depth of the Parentheses
    public static int maxDepth(String s) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                count++;
                max = Math.max(max, count);
            }
            else {
                count--;
            }
        }
        return max;
    }

    // 12 Reverse Words in a String
    public static void reverseWords(String s) {
        String word[] = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (int i = word.length - 1; i >= 0; i--) {
            sb.append(word[i]);

            if (i > 0) {
                sb.append(" ");
            }
        }

        String reverse = sb.toString();
        
        System.out.println(reverse);
    }

    //  13. Longest Substring Without Repeating Characters
    public static void lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
            else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        System.out.println(maxLength);
    }

    // 14. Removing Stars From a String
    public static void removeStar(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ans: stack) {
            sb.append(ans);
        }

        String result = sb.toString();
        System.out.println(result);
    }

    // 15 Maximum Number of Balloons (Balloon aana chahiye character me)
    public static int countBalloons(String balloons) {
        int min = Integer.MAX_VALUE;

        int freq[] = new int[26];

        for (int i = 0; i < balloons.length(); i++) {
            freq[balloons.charAt(i) - 'a']++;
        }

        min = Math.min(min, freq['b' - 'a'] / 1);
        min = Math.min(min, freq['a' - 'a'] / 1);
        min = Math.min(min, freq['l' - 'a'] / 1);
        min = Math.min(min, freq['l' - 'a'] / 1);
        min = Math.min(min, freq['o' - 'a'] / 1);
        min = Math.min(min, freq['o' - 'a'] / 1);
        min = Math.min(min, freq['n' - 'a'] / 1);
        
        return min;
    }
    public static void main(String[] args) {
        // String s = "satyam";
        // reverse(s); // maytas

        // String reverseSentence = "Java is awesome";
        // reverseSentence(reverseSentence); //awesome is Java 

        // isPalindrome("madam");  // true

        // VowelConsonantCounter(s);// Vowel = 2  Consonant = 4
        // anagram(s, "tyaams"); //It is Anagram
        // countFrequency("satyam");  //a = 2, m = 1, s = 1, t = 1, y = 1
        // removeDuplicate("programming"); // progamin
        // CapticalFirstLetter("java is a programming language"); // Java Is A Programming Language 
        // longestWord("java is a programming language");  // programming, length = 11
        // FirstNonRepeatingChar("aabcbadssdfcfde");  // First repetaing char = e

        // String s = "(1+(2*3)+((8)/4))+1";
        // System.out.println(maxDepth(s));

        // String str = "leet**cod*e";
        // removeStar(str);
        
        String str = "loonbalxballpoon";
        System.out.println(countBalloons(str));

    }
}