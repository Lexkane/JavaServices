package com.epam.lab.menu;


import com.epam.lab.creator.TrainCreator;
import com.epam.lab.model.Station;
import com.epam.lab.model.Train;
import com.epam.lab.services.Purchaser;
import com.epam.lab.view.View;

import java.util.List;
import java.util.stream.Collectors;

public class Menu {

    private List<Station> stations;
    private List<String> dates;
    private KeyReader keyReader;
    private static Purchaser purchaser = new Purchaser();
    private View view = new View();
    private static List<Train> allTrains = new TrainCreator().createTrains();
    private static Train lvivKharkiv = allTrains.get(0);


    public Menu(List<Station> stations, List<String> dates) {
        this.stations = stations;
        this.dates = dates;
        this.keyReader = new KeyReader();
    }

    public void show() {
        System.out.println("▒█▀▀█ ░█▀▀█ ▀█▀ ▒█░░░ ▒█░░▒█ ░█▀▀█ ▒█░░▒█ \n"
                + "▒█▄▄▀ ▒█▄▄█ ▒█░ ▒█░░░ ▒█▒█▒█ ▒█▄▄█ ▒█▄▄▄█ \n"
                + "▒█░▒█ ▒█░▒█ ▄█▄ ▒█▄▄█ ▒█▄▀▄█ ▒█░▒█ ░░▒█░░ ");

        view.showDepartureStations();
        int departureNum = keyReader.readKey(stations.size() + 1);
        Station startStation = view.determineStation(departureNum);

        view.showDestinationStations();
        int arrivalNum = keyReader.readKey(stations.size() + 1);
        if (departureNum == arrivalNum) {
            System.out.println("You're already at your destination point!)");
            return;
        }
        Station destinationStation = view.determineStation(arrivalNum);

        System.out.println("\n=== CHOOSE DATE FOR ROUTE \"" + stations.get(departureNum) +
                " - " + stations.get(arrivalNum) + "\":");
        showList(dates);
        int dateNum = keyReader.readKey(dates.size() + 1);

        List<Train> appropriateTrains = purchaser.findAppropriateTrains(
                allTrains, startStation, destinationStation);

        if (appropriateTrains.isEmpty()) {

            System.out.println("=== THERE ARE NO AVAILABLE DIRECT TRAINS. \n" +
                    "    CHOOSE ONE OF THE INDIRECT ROUTES BELOW:");

            purchaser.findIndirectTrains(allTrains, startStation, destinationStation);
//                    .forEach((a,b) -> System.out.println(a + " - " + b.get(0).getName()
//                            + " ===> " + b.get(1).getName()));

            System.exit(0); // here must be some logic
        }

        view.showTrains(appropriateTrains);
        int train = keyReader.readKey(3);

        Train chosenTrain = null;
        if (train == 0) {
            chosenTrain = allTrains.get(0);
        } else if (train == 1) {
            chosenTrain = allTrains.get(1);
        }

        System.out.println("\n=== SELECT WAGON NUMBER: ");
        view.showWagonsOrSeats(5);

        int wagonNumber = keyReader.readKey(5); //amount of wagons is passed;

        System.out.println("\n=== SELECT SEAT: ");
        purchaser.printPlaces(chosenTrain, wagonNumber);

        int seatNumber = keyReader.readKey(10); //amount of seats is passed;

        // seat booking
        purchaser.bookSeat(chosenTrain, startStation, destinationStation, wagonNumber, seatNumber);

        // here we make sure of successful booking processing
        System.out.println("\n***** You have successfully bought a ticket! *****");
        purchaser.printPlaces(chosenTrain, wagonNumber);

        System.out.println("\n\n\n=== DO YOU WANT TO BUY ONE MORE TICKET? \n"
                + "1 - Yes! Buy one more ticket \n"
                + "2 - Exit");
        int oneOrExit = keyReader.readKey(3);

        if (oneOrExit == 0) {
            show();
        } else if (oneOrExit == 1) {
            System.exit(0);
        } else {
            System.out.println("THANK YOU! HAVE A GOOD JOURNEY!");
        }


    }

    private void showList(List<?> dates) {
        for (int i = 0; i < dates.size(); i++) {
            System.out.println((i + 1) + " - " + dates.get(i));
        }
    }


}

