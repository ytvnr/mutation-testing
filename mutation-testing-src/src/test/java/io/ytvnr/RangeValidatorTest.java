package io.ytvnr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RangeValidatorTest {

    private RangeValidator cut;

    @BeforeEach
    void setUp() {
        cut = new RangeValidator();
    }

    @Test
    void fiftyShouldBeInRange() {
        assertThat(cut.isInRange(50)).isTrue();
    }

    @Test
    void twoHundredShouldNotBeInRange() {
        assertThat(cut.isInRange(200)).isFalse();
    }

    @Test
    void minusTenShouldNotBeInRange() {
        assertThat(cut.isInRange(-10)).isFalse();
    }
}