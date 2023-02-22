package io.ytvnr;

public class Palindrome {

    public boolean isPalindrome(String input) {
        if (input.length() == 0) {
            return true;
        } else {
            char firstChar = input.charAt(0);
            // Get the last char or self if input is one char long
            char lastChar = input.length() == 1 ? firstChar : input.charAt(input.length() - 1);
            // Remove the first and last char of the string.
            String mid = input.length() == 1 ? "" : input.substring(1, input.length() - 1);
            return (firstChar == lastChar) && isPalindrome(mid);
        }
    }
}
