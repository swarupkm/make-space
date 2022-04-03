package com.swarup.geektrust.makespace;

import com.swarup.geektrust.makespace.errors.InvalidBookingTimeRange;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BookingTimeRangeTest {

    @Test
    void shouldHaveValidTimeRange() {
        Time startTime = new Time("10:00");
        Time endTime = new Time("23:15");
        assertThatNoException().isThrownBy(() -> new BookingTimeRange(startTime, endTime));
    }

    @Test
    void shouldThrowExceptionWhenStartTimeIsAfterEndTime() {
        Time startTime = new Time("20:00");
        Time endTime = new Time("13:15");
        assertThatThrownBy(() -> new BookingTimeRange(startTime, endTime)).isInstanceOf(InvalidBookingTimeRange.class);
    }

    @Test
    void shouldBeTrueIfThisBookingTimeIsAfterAfterBookingTime() {
        BookingTimeRange thisTimeRange = new BookingTimeRange(new Time("12:15"), new Time("13:15"));
        BookingTimeRange thatTimeRange = new BookingTimeRange(new Time("10:15"), new Time("11:15"));
        assertThat(thisTimeRange.isAfter(thatTimeRange)).isTrue();
    }

}