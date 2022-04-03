package com.swarup.geektrust.makespace;

import com.swarup.geektrust.makespace.errors.InvalidTime;
import com.swarup.geektrust.makespace.support.Generated;

import java.time.LocalTime;
import java.util.Objects;
import java.util.regex.Pattern;

public class Time {

    private LocalTime localTime;

    public Time(String expression) {
        validateExpression(expression);
        assignTimeAndHours(expression);
    }

    private void assignTimeAndHours(String expression) {
        String[] split = expression.split(":");
        int hours = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);
        localTime = LocalTime.of(hours, minutes);
    }

    private void validateExpression(String expression) {
        if (!Pattern.matches("[0-2][0-9]:[0-5][0-9]", expression)) {
            throw new InvalidTime();
        }
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public boolean isAfter(Time thatTime) {
        return this.getLocalTime().isAfter(thatTime.getLocalTime());
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
        Time time = (Time) o;
        return Objects.equals(localTime, time.localTime);
    }

    @Override
    @Generated
    public int hashCode() {
        return Objects.hash(localTime);
    }
}
