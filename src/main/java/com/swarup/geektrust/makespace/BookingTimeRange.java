package com.swarup.geektrust.makespace;

import com.swarup.geektrust.makespace.errors.InvalidBookingTimeRange;

public class BookingTimeRange {

    private Time startTime;
    private Time endTime;

    public BookingTimeRange(Time startTime, Time endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        validateTimeRange(startTime, endTime);
    }

    private void validateTimeRange(Time startTime, Time endTime) {
        if (startTime.isAfter(endTime)) {
            throw new InvalidBookingTimeRange();
        }
    }

    public boolean isAfter(BookingTimeRange thatTimeRange) {
        return this.getStartTime().isAfter(thatTimeRange.getEndTime());
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }
}
