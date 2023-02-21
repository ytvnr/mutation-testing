package io.ytvnr;

import org.junit.jupiter.api.Test;

import static io.ytvnr.Palindrome.*;
import static org.assertj.core.api.Assertions.assertThat;

class PalindromeTest {

    @Test
    void shouldBePalindrome() {
        assertThat(isPalindrome("noon")).isTrue();
    }
}