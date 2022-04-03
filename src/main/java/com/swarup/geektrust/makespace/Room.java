package com.swarup.geektrust.makespace;

import com.swarup.geektrust.makespace.support.Generated;

import java.util.Objects;

public class Room {
    private final DaySlots slots;
    private String name;
    private int capacity;

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.slots = new DaySlots();
    }

    public void book(BookingTimeRange timeRange) {
        this.slots.bookSlotForTime(timeRange);
    }

    public boolean checkAvailability(BookingTimeRange timeRange) {
        return this.slots.checkIfAvailable(timeRange);
    }

    @Generated
    public int getCapacity() {
        return capacity;
    }

    @Generated
    public String getName() {
        return name;
    }

    @Override
    @Generated
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return Objects.equals(name, room.name);
    }

    @Override
    @Generated
    public int hashCode() {
        return Objects.hash(name);
    }
}
