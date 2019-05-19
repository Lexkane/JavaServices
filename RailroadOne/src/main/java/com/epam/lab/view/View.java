package com.epam.lab.view;

import com.epam.lab.model.Station;
import com.epam.lab.model.Train;

import java.util.Arrays;
import java.util.List;

import com.epam.lab.menu.Menu;
import com.epam.lab.model.*;
import com.epam.lab.services.Purchaser;

import java.util.ArrayList;
import java.util.List;

public class View {

  private Menu menu;

  public void showTrains(List<Train> trains) {
    System.out.println("\n=== HERE ARE AVAILABLE TRAINS: ");
    for (int i = 0; i < trains.size(); i++) {
      Train train = trains.get(i);
      List<Station> stations = train.getStationList();
      System.out.println((i + 1) + " - " +
              stations.get(0).name() + " - "
              + stations.get(stations.size() - 1));
    }
  }
  public void showStartMenu() {
    List<String> dates = new ArrayList<>();
    dates.add("21.02");
    dates.add("22.02");
    dates.add("23.02");

    List<Station> stations = Arrays.asList(Station.values());

    menu = new Menu(stations, dates);
    menu.show();
  }

  public void showAllStations() {

    List<Station> stations = Arrays.asList(Station.values());

    for (int i = 0; i < stations.size(); i++) {
      System.out.println((i + 1) + " - " + stations.get(i));
    }
  }

  public void showDestinationStations() {
    System.out.println("\n=== ARRIVAL TO: ");
    showAllStations();
  }

  public void showDepartureStations() {
    System.out.println("\n=== DEPARTURE FROM: ");
    showAllStations();
  }

  public void showWagonsOrSeats(int n) {
    for (int i = 1; i  <= n; i++) {
      System.out.print("[" + i + "] ");
    }
    System.out.println();
  }

  public Station determineStation(int choosedNumber){
    List<Station> stations = Arrays.asList(Station.values());
    return stations.get(choosedNumber);

  }

}
