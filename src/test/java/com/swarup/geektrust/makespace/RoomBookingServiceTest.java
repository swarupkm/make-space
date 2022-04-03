package com.swarup.geektrust.makespace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.swarup.geektrust.makespace.support.CONSOLE_STRINGS.NO_VACANT_ROOM;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RoomBookingServiceTest {
    public static final String ROOM_NAME_1 = "RRRRR";
    private static final String ROOM_NAME_2 = "LLLLL";
    public static final BookingTimeRange BUFFER_TIME = new BookingTimeRange(new Time("09:00"), new Time("09:15"));
    private RoomBookingService service;

    @BeforeEach
    void setUp() {
        service = new RoomBookingService();
        service.registerRoom(ROOM_NAME_1,2);
        service.registerRoom(ROOM_NAME_2,10);

    }

    @Test
    void shouldCheckVacancy() {
        String vacancy = service.checkVacancy(new BookingTimeRange(new Time("11:00"), new Time("12:00")));
        assertThat(vacancy).isEqualTo(String.format("%s %s",ROOM_NAME_1,ROOM_NAME_2));
    }

    @Test
    void shouldCheckForNoVacancy() {
        String vacancy = service.checkVacancy(BUFFER_TIME);
        assertThat(vacancy).isEqualTo(NO_VACANT_ROOM);
    }

    @Test
    void shouldBeAbleToBookRoom() {
        String booking = service.book(new BookingTimeRange(new Time("11:00"), new Time("12:00")), 5);
        assertThat(booking).isEqualTo(ROOM_NAME_2);
    }

    @Test
    void shouldNotBeAbleToBookRoomInBufferTime() {
        String booking = service.book(BUFFER_TIME, 5);
        assertThat(booking).isEqualTo(NO_VACANT_ROOM);
    }


}