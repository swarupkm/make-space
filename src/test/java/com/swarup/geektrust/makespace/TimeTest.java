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
    void shouldCheckIsAfter() {
        Time thisTime = new Time("23:40");
        Time thatTime = new Time("21:45");
        assertThat(thisTime.isAfter(thatTime)).isTrue();
    }

    @Test
    void shouldCompareTime() {
        Time thisTime = new Time("23:40");
        Time thatTime = new Time("23:40");
        assertThat(thisTime).isEqualTo(thatTime);
    }
}