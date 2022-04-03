package com.swarup.geektrust.makespace;

import com.swarup.geektrust.makespace.errors.InvalidBooking;

public class DaySlots {
    private static final int SLOT_SIZE_IN_MINUTES = 15;
    private static final int MINUTES_IN_A_DAY = 24 * 60;
    private static final int SLOTS_IN_A_DAY = MINUTES_IN_A_DAY / SLOT_SIZE_IN_MINUTES ;
    private boolean[] slot = new boolean[SLOTS_IN_A_DAY];

    public DaySlots() {
        initializeSlots();
    }

    private void initializeSlots() {
        for (int i = 0; i < SLOTS_IN_A_DAY; i++) {
            slot[i] = false;
        }
    }

    public void bookSlotForTime(BookingTimeRange timeRange){
        if (checkIfAvailable(timeRange)) {
            book(timeRange);
        } else {
            throw new InvalidBooking();
        }
    }

    private void book(BookingTimeRange timeRange) {
        Time startTime = timeRange.getStartTime();
        Time endTime = timeRange.getEndTime();
        Integer startTimeTotalMinutes = startTime.getTotalMinutes();
        Integer endTimeTotalMinutes = endTime.getTotalMinutes();
        for (int i = (startTimeTotalMinutes/SLOT_SIZE_IN_MINUTES); i < (endTimeTotalMinutes/SLOT_SIZE_IN_MINUTES); i++) {
            slot[i] = true;
        }
    }

    public boolean checkIfAvailable(BookingTimeRange timeRange) {
        Time startTime = timeRange.getStartTime();
        Time endTime = timeRange.getEndTime();
        Integer startTimeTotalMinutes = startTime.getTotalMinutes();
        Integer endTimeTotalMinutes = endTime.getTotalMinutes();
        for (int i = (startTimeTotalMinutes/SLOT_SIZE_IN_MINUTES); i < (endTimeTotalMinutes/SLOT_SIZE_IN_MINUTES); i++) {
            if (slot[i]) {
                return false;
            }
        }
        return true;
    }
}
