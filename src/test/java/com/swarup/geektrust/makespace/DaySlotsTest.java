package com.swarup.geektrust.makespace;

import com.swarup.geektrust.makespace.errors.InvalidBooking;
import com.swarup.geektrust.makespace.errors.InvalidTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DaySlotsTest {
    private DaySlots daySlots;

    @BeforeEach
    void setUp() {
        daySlots = new DaySlots();
    }

    @Test
    void shouldBookForTimeSlot() {
        BookingTimeRange timeRange = new BookingTimeRange(new Time("10:00"), new Time("11:00"));
        daySlots.bookSlotForTime(timeRange);
        assertThat(daySlots.checkIfAvailable(timeRange)).isFalse();
    }

    @Test
    void shouldThrowErrorIfAlreadyBooked() {
        BookingTimeRange timeRange = new BookingTimeRange(new Time("10:00"), new Time("11:00"));
        daySlots.bookSlotForTime(timeRange);
        BookingTimeRange anotherTimeRange = new BookingTimeRange(new Time("09:30"), new Time("10:30"));
        assertThatThrownBy(() -> daySlots.bookSlotForTime(anotherTimeRange)).isInstanceOf(InvalidBooking.class);
    }

    @Test
    void shouldBookOnBorderTimeAlreadyBooked() {
        BookingTimeRange timeRange = new BookingTimeRange(new Time("10:00"), new Time("11:00"));
        daySlots.bookSlotForTime(timeRange);
        BookingTimeRange anotherTimeRange = new BookingTimeRange(new Time("09:00"), new Time("10:00"));
        assertThatNoException().isThrownBy(() -> daySlots.bookSlotForTime(anotherTimeRange));
    }
}