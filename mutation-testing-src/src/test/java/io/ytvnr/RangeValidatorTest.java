package io.ytvnr;

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
        cut.isInRange(50);
    }

    @Test
    void twoHundredShouldNotBeInRange() {
        cut.isInRange(200);
    }

    @Test
    void minusTenShouldNotBeInRange() {
        cut.isInRange(-10);
    }
}