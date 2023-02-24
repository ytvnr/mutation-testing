package io.ytvnr;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeTest {

    @Test
    void shouldBePalindromeEven() {
        assertThat(new Palindrome().isPalindrome("radar")).isTrue();
    }

    @Test
    void shouldBePalindromeOdd() {
        assertThat(new Palindrome().isPalindrome("raar")).isTrue();
    }

    @Test
    void shouldNotBePalindromeEven() {
        assertThat(new Palindrome().isPalindrome("neoon")).isFalse();
    }

    @Test
    void shouldNotBePalindromeOdd() {
        assertThat(new Palindrome().isPalindrome("neon")).isFalse();
    }
}