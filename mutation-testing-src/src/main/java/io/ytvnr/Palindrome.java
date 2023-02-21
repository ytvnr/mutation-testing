package io.ytvnr;

public class Palindrome {

    private Palindrome() {
        // Nothing to do
    }

    public static boolean isPalindrome(String input) {
        if (input.length() == 0) {
            return true;
        } else {
            char firstChar = input.charAt(0);
            char lastChar = input.charAt(input.length() - 1);
            String mid = input.substring(1, input.length() - 1);
            return (firstChar == lastChar) && isPalindrome(mid);
        }
    }
}
