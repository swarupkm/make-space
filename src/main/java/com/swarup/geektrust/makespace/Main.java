package com.swarup.geektrust.makespace;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        RoomBookingService roomBookingService = new RoomBookingService();
        registerRooms(roomBookingService);
        CommandExecutor commandExecutor = new CommandExecutor(roomBookingService);

        String filePath = args[0];
        File myObj = new File(filePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String[] data = myReader.nextLine().split(" ");
            commandExecutor.execute(data);
        }
        myReader.close();
    }

    private static void registerRooms(RoomBookingService service) {
        service.registerRoom("C-Cave",3);
        service.registerRoom("D-Tower",7);
        service.registerRoom("G-Mansion",20);
    }
}
