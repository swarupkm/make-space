package com.swarup.geektrust.makespace;

import com.swarup.geektrust.makespace.errors.InvalidBookingTimeRange;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BookingTimeRangeTest {

    @Test
    void shouldHaveValidTimeRange() {
        Time startTime = new Time("10:20");
        Time endTime = new Time("23:22");
        assertThatNoException().isThrownBy(() -> new BookingTimeRange(startTime, endTime));
    }

    @Test
    void shouldThrowExceptionWhenStartTimeIsAfterEndTime() {
        Time startTime = new Time("20:20");
        Time endTime = new Time("13:22");
        assertThatThrownBy(() -> new BookingTimeRange(startTime, endTime)).isInstanceOf(InvalidBookingTimeRange.class);
    }

    @Test
    void shouldBeTrueIfThisBookingTimeIsAfterAfterBookingTime() {
        BookingTimeRange thisTimeRange = new BookingTimeRange(new Time("12:20"), new Time("13:20"));
        BookingTimeRange thatTimeRange = new BookingTimeRange(new Time("10:20"), new Time("11:20"));
        assertThat(thisTimeRange.isAfter(thatTimeRange)).isTrue();
    }

}