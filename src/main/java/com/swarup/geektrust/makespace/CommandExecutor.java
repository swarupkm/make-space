package com.swarup.geektrust.makespace;

import com.swarup.geektrust.makespace.errors.InvalidBookingTimeRange;
import com.swarup.geektrust.makespace.errors.InvalidTime;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import static com.swarup.geektrust.makespace.support.CONSOLE_STRINGS.INCORRECT_INPUT;

public class CommandExecutor {
    private RoomBookingService service;
    private HashMap<String, Function<List<String>, String>> stringBlahHashMap = new HashMap<>();


    public CommandExecutor(RoomBookingService roomBookingService) {

        this.service = roomBookingService;
        registerCommands();
    }

    private void registerCommands() {
        stringBlahHashMap.put("VACANCY", this::vacancy);
        stringBlahHashMap.put("BOOK", this::book);
    }

    public void execute(String[] data) {
        try {
            String command = data[0];
            String res = stringBlahHashMap.get(command).apply(List.of(data));
            System.out.println(res);
        }catch (InvalidTime | InvalidBookingTimeRange t) {
            System.out.println(INCORRECT_INPUT);
        }
    }

    private String vacancy(List<String> data) {
        return service.checkVacancy(new BookingTimeRange(new Time(data.get(1)), new Time(data.get(2))));
    }

    private String book(List<String> data) {
        return service.book(new BookingTimeRange(new Time(data.get(1)), new Time(data.get(2))), Integer.parseInt(data.get(3)));
    }

}
