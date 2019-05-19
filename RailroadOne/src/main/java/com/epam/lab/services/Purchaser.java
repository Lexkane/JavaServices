package com.epam.lab.services;

import com.epam.lab.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class Purchaser {
    private static final double MIN_TARIFF = 50.0;

    public void bookSeat(Train train, Station start, Station end, int wagonNumber, int seat) {
        int startIndex = findIndex(train, start);
        int endIndex = findIndex(train, end);

        if (startIndex < endIndex) {
            for (int i = startIndex; i < endIndex; i++) {
                if (train.getTrainData().get(train.getStationList().get(i)).
                        get(wagonNumber).getSeatList().get(i)) {
                    System.out.println("=== SEAT NUMBER " + (i + 1) + " IS NOT AVAILABLE. THE STATION IS CLOSED. COME AGAIN LATER");
                    System.exit(0); // this must be somehow resolved...
                } else {
                    train.getTrainData().get(train.getStationList().get(i)).
                            get(wagonNumber).getSeatList().set(seat, true);
                }
            }
        }
    }

    //book seats in two trains in case of indirect route
    public void bookSeatsInIndirectTrains(int userChoice, Map<Integer, List<Train>> indirectListMap, Station start, Station end, int wagonNumber, int seat) {
        Train train1 = indirectListMap.get(userChoice).get(0);
        for (int i = findIndex(train1, start); i < train1.getStationList().size(); i++) {
            train1.getTrainData().get(train1.getStationList().get(i)).
                    get(wagonNumber).getSeatList().set(seat, true);
        }

        Train train2 = indirectListMap.get(userChoice).get(1);
        for (int i = 0; i < findIndex(train1, end); i++) {
            train2.getTrainData().get(train2.getStationList().get(i)).
                    get(wagonNumber).getSeatList().set(seat, true);
        }
    }

    private int findIndex(Train train, Station station) {
        for (int i = 0; i < train.getStationList().size(); i++) {
            if (train.getStationList().get(i) == station) {
                return i;
            }
        }
        return 0;
    }

    // finds appropriate trains
    public List<Train> findAppropriateTrains(List<Train> allTrains, Station start, Station end) {
        List<Train> appropriateTrainsList = new ArrayList<>();

        for (Train train : allTrains) {
            if (train.getStationList().contains(start) && train.getStationList().contains(end)) {
                appropriateTrainsList.add(train);
            }
        }
        return appropriateTrainsList;
    }

    // search for indirect trains with changes
    public Map<Integer, List<Train>> findIndirectTrains(List<Train> allTrains, Station start, Station end) {
        Map<Integer, List<Train>> indirectTrainsMap = new TreeMap<>();
        int count = 0;

        List<Train> trainsWithStartStation = allTrains.stream()
                .filter(a -> a.getStationList().contains(start))
                .collect(Collectors.toList()); // trains that contains start station
        List<Train> trainsWithEndStation = allTrains.stream()
                .filter(a -> a.getStationList().contains(end))
                .collect(Collectors.toList()); // trains that contains end station

        for (Train trainStart : trainsWithStartStation) {
            List<Station> tempList1 = trainStart.getStationList().stream()
                    .skip(trainStart.getStationList().indexOf(start))
                    .collect(Collectors.toList()); // stream of stations from start station to the last element of the list
            for (Station station : tempList1) {
                for (Train trainEnd : trainsWithEndStation) {
                    if (trainEnd.getStationList().stream()
                            .limit(trainEnd.getStationList().indexOf(end) + 1)
                            .collect(Collectors.toList()).contains(station)) { // stream of stations from the 0 index to the end station
                        indirectTrainsMap.put(count++, List.of(trainStart, trainEnd));

                        // system.out mustn't be here
                        System.out.println(count + " - " + trainStart.getName()
                                + " ===> " + station.toString()
                                + " ===> " + trainEnd.getName()
                                + " ===> " + end.toString());
                    }
                }
            }
        }

        // just test (user always choose the first first train, first wagon and first seat)
//        bookSeatsInIndirectTrains(0, indirectTrainsMap, start, end, 1,1);
//        System.out.println("=== CONGRATULATIONS! You have booked seats in both trains!");
        System.exit(0);

        return indirectTrainsMap;
    }

    public Set<Integer> findEmptySeats(Train train, Station start, Station end, int wagonNumber) {
        int startIndex = findIndex(train, start);
        int endIndex = findIndex(train, end);
        Set<Integer> emptySeats = new HashSet<>();

        for (int i = startIndex; i < endIndex; i++) {
            List<Boolean> allSeats =
                    train.getTrainData().get(train.getStationList().get(i)).get(wagonNumber).getSeatList();

            for (int j = 0; j < allSeats.size(); j++) {
                if (!allSeats.get(j)) {
                    emptySeats.add(j);
                } else emptySeats.remove(j);
            }
        }

        return emptySeats;
    }

    public double calculatePrice(List<Station> stations, WagonType wagonType) {
        return stations.size() * MIN_TARIFF * wagonType.getCoefficient();
    }

    public void printPlaces(Train train, int wagonNum) {
        int i = 0;
        for (boolean b :
                train.getTrainData()
                        .get(train.getStationList().get(0))
                        .get(wagonNum)
                        .getSeatList()) {
            if (b) {
                ++i;
                System.out.print("[X] ");
            } else {
                System.out.print("[" + ++i + "] ");
            }
        }
    }
}
