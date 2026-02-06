import java.util.*;

public class StringAll{

    // 1. Reverse The String
    public static void reverseString(String s){

        char arr[] = s.toCharArray(); 
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;

            i++;
            j--;
        }

        String reversed = new String(arr);
        System.out.println(reversed);
    }

    // 2. CheckPalindrome 
    public static boolean isPalindrome(String str) {
        // int i = 0;
        // int j = str.length() - 1;

        // while (i < j) {
        //     if (str.charAt(i) != str.charAt(j)) {
        //         return false;
        //     }
        //     i++;
        //     j--;
        // }
        // return true;

        // or 

        int n = str.length() - 1;

        for (int i = 0; i < n/2; i++) {
            if (str.charAt(i) != str.charAt(n - i)) {
                return false;
            }
        }
        return true;
    }

    // 3. Count vowels & consonants
    public static void countVowelsConsonants(String str) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch =='e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                }
                else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels = " + vowels + " Consonants = " + consonants);
    }

    // 4. remove duplicate characters
    public static void removeDuplicateString(String str) {
        HashSet<Character> set = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!set.contains(ch)) {
                set.add(ch);
                result.append(ch);
            }
        }
        System.out.println(result.toString());
    }
    
    // 5. Anagram 
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int freq[] = new int[26];
        
        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            freq[str2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    // 6. find first non-repeating character
    public static char firstNonReapting(String str) {
        int freq[] = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return '0';
    }

    // 7. count frequency of character
    public static void countFrequency(String str) {
        int freq[] = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] != 0) {
                System.out.println(str.charAt(i) + " -> " + freq[str.charAt(i)]);
                freq[str.charAt(i)] = 0;
            }
        }
    }

    // 8 Reverse words in string
    public static void reverseWord(String str) {
        String word[] = str.split(" ");
        String result = " ";

        for (int i = word.length - 1; i >= 0; i--) {
            result = result + word[i] + " ";
        }

        System.out.println(result.trim());
    }

    // 9. Longest word in string 
    public static void longestWord(String str) {
        String word[] = str.split(" ");
        String longest = " ";

        for (int i = 0; i < word.length; i++) {
            if (word[i].length() > longest.length()) {
                longest = word[i];
            }
        }
        System.out.println(longest);
    }

    // 10. Check valid shuffle of string
    public static boolean validShuffle(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int i = 0; // for s1
        int j = 0; // for s2
        int k = 0; //for s3

        while (k < s3.length()) {
            if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
                i++;
                k++;
            }
            else if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
                j++;
                k++;
            }
            else {
                return false;
            }

            // k++;
        }
        return true;
    }

    // 11 Convert Upper case to Lowercase
    public static void upperToLower(String str) {
        char arr[] = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = (char)(arr[i] + 32);
            }
        }
        System.out.println(new String(arr));
    }

    // 12 Convert Lowercase to Upper case
    public static void lowerToUpper(String str) {
        char arr[] = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = (char)(arr[i] - 32);
            }
        }
        System.out.println(new String(arr));
    }

    // 13 Find subString
    public static void subString(String str, String sub) {
        if (str.contains(sub)) {
            System.out.println("This is SubString!");
        }
        else {
            System.out.println("Not SubString!");
        }
    }

    // 14. check String rotate
    public static boolean  rotateString(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            String rotate = str1.substring(i) + str1.substring(0, i);
            if (rotate.equals(str2)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        // String s = "hello";
        // reverseString(s); //olleh

        // String s = "madam";
        // if (isPalindrome(s)) {
        //     System.out.println("Palindrome");
        // } else {
        //     System.out.println("Not Palindrome");
        // }

        // String str = "hello world";
        // countVowelsConsonants(str);  // v = 3, con = 7

        // String str = "programming";
        // removeDuplicateString(str);  //progamin 

        // String s1 = "listen";
        // String s2 = "silent";
        // System.out.println(isAnagram(s1, s2)); //true

        // String str = "aabbcdd";
        // System.out.println(firstNonReapting(str));

        // String str = "aabbcdd";
        // countFrequency(str);

        // String str = "i love java";
        // reverseWord(str);

        // String str = "i love java language";
        // longestWord(str);

        // String s1 = "ab";
        // String s2 = "cd";
        // String s3 = "adbc";
        // System.out.println(validShuffle(s1, s2, s3));

        // String str = "I LOVE JAVA";
        // upperToLower(str);

        // String str = "i love java";
        // lowerToUpper(str);

        // subString("i love java", "java"); // true

        System.out.println(rotateString("abcd", "cbad")); // false
    }
}