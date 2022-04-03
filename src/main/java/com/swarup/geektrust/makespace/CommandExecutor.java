package com.swarup.geektrust.makespace;

import com.swarup.geektrust.makespace.errors.InvalidBookingTimeRange;
import com.swarup.geektrust.makespace.errors.InvalidTime;

import static com.swarup.geektrust.makespace.support.CONSOLE_STRINGS.INCORRECT_INPUT;

public class CommandExecutor {
    private RoomBookingService service;

    public CommandExecutor(RoomBookingService roomBookingService) {

        this.service = roomBookingService;
    }

    public void execute(String[] data) {
        try {
            executeCommands(data);
        }catch (InvalidTime | InvalidBookingTimeRange t) {
            System.out.println(INCORRECT_INPUT);
        }
    }

    private void executeCommands(String[] data) {
        String command = data[0];
        if (command.equals("VACANCY")){
            String result = service.checkVacancy(new BookingTimeRange(new Time(data[1]), new Time(data[2])));
            System.out.println(result);
        }
        if (command.equals("BOOK")){
            String result = service.book(new BookingTimeRange(new Time(data[1]), new Time(data[2])),Integer.parseInt(data[3]));
            System.out.println(result);
        }
    }
}
