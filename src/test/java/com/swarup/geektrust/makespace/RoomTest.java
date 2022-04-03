package com.swarup.geektrust.makespace;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RoomTest {

    @Test
    void shouldCreateRoomForBooking() {
        int capacity = 4;
        Room room = new Room("C-Cave", capacity);
        BookingTimeRange timeRange = new BookingTimeRange(new Time("10:00"), new Time("11:00"));
        room.book(timeRange);
        assertThat(room.checkAvailability(timeRange)).isFalse();
    }

}