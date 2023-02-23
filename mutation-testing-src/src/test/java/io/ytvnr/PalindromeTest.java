package io.ytvnr;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeTest {

    @Test
    void shouldBePalindrome() {
        assertThat(new Palindrome().isPalindrome("radar")).isTrue();
    }
}