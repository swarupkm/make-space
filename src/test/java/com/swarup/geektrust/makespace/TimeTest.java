package com.swarup.geektrust.makespace;


import com.swarup.geektrust.makespace.errors.InvalidTime;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TimeTest {

    @Test
    void hoursAndMinutesShouldBeValid() {
        assertThatNoException().isThrownBy(() -> new Time("23:00"));
    }

    @Test
    void shouldThrowExceptionIfNotColonSeparated() {
        assertThatThrownBy(() -> new Time("2300")).isInstanceOf(InvalidTime.class);
    }

    @Test
    void shouldThrowExceptionForInvalidHours() {
        assertThatThrownBy(() -> new Time("33:00")).isInstanceOf(InvalidTime.class);
    }

    @Test
    void shouldThrowExceptionForInvalidMinutes() {
        assertThatThrownBy(() -> new Time("23:80")).isInstanceOf(InvalidTime.class);
    }

    @Test
    void shouldThrowExceptionForMinutesNotMultipleOf15() {
        assertThatThrownBy(() -> new Time("23:20")).isInstanceOf(InvalidTime.class);
    }

    @Test
    void shouldCheckIsAfter() {
        Time thisTime = new Time("23:45");
        Time thatTime = new Time("21:45");
        assertThat(thisTime.isAfter(thatTime)).isTrue();
    }

    @Test
    void shouldCompareTime() {
        Time thisTime = new Time("23:45");
        Time thatTime = new Time("23:45");
        assertThat(thisTime).isEqualTo(thatTime);
    }

    @Test
    void shouldGetMinutes() {
        Time thatTime = new Time("23:45");
        assertThat(thatTime.getMinutes()).isEqualTo(45);
    }

    @Test
    void shouldGetHours() {
        Time thatTime = new Time("23:45");
        assertThat(thatTime.getHours()).isEqualTo(23);
    }

    @Test
    void shouldGetTotalMinutes() {
        Time thatTime = new Time("01:45");
        assertThat(thatTime.getTotalMinutes()).isEqualTo(105);
    }

}