package com.swarup.geektrust.makespace;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.swarup.geektrust.makespace.support.CONSOLE_STRINGS.NO_VACANT_ROOM;

public class RoomBookingService {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<BookingTimeRange> buffers = new ArrayList<>();

    public RoomBookingService() {
        loadBuffers();
    }

    public void registerRoom(String name, int capacity) {
        Room room = new Room(name, capacity);
        buffers.forEach(room::book);
        this.rooms.add(room);
        this.rooms.sort((Comparator.comparingInt(Room::getCapacity)));
    }

    public String checkVacancy(BookingTimeRange timeRange){
        List<String> list = rooms.stream()
                .filter(room -> room.checkAvailability(timeRange))
                .map(Room::getName)
                .collect(Collectors.toList());

        return  list.isEmpty() ? NO_VACANT_ROOM : String.join(" ",list);
    }

    public String book(BookingTimeRange timeRange, int personCount){
        for (Room room: rooms){
            if (room.getCapacity() < personCount) continue;
            if (room.checkAvailability(timeRange)) {
                room.book(timeRange);
                return room.getName();
            }
        }
        return NO_VACANT_ROOM;
    }

    private void loadBuffers() {
        buffers.add(new BookingTimeRange(new Time("09:00"),new Time("09:15")));
        buffers.add(new BookingTimeRange(new Time("13:15"),new Time("13:45")));
        buffers.add(new BookingTimeRange(new Time("18:45"),new Time("19:00")));
    }


}
