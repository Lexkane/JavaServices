package com.booking.view;

import com.booking.model.station_info.Route;
import com.booking.model.station_info.Station;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Selector implements Viewer {

  private List listOfRoutes;

  public Selector(List list) {
    show(list);
  }

  @Override
  public void show(List list) {
    String from = null;
    String to = null;
    LocalDate date = null;

    ////Here should be while)))

    Scanner scanner = new Scanner(System.in);
    System.out.println("From : ");
    from = scanner.nextLine();
    System.out.println("To");
    to = scanner.nextLine();
    System.out.println("Date (format: \"yyyy-mm-dd\")");

    date = LocalDate.parse(scanner.nextLine());

    listOfRoutes = findRouts(from, to, date, list);
    if (!listOfRoutes.isEmpty()) {
      new TableOfRoute(this);
    } else {
      System.out.println("There aren't such listOfRoutes.");
    }
  }

  private List<Route> findRouts(String from, String to, LocalDate date, List<Route> list) {
    return list
        .stream()
        .filter(a -> a.getDate().equals(date))
        .filter(
            a -> {
              int i = 0;
              for (Station station : a.getStations()) {
                if (station.getStationName().equalsIgnoreCase(from) && i == 0) {
                  i = 1;
                }
                if (station.getStationName().equalsIgnoreCase(to) && i == 1) {
                  return true;
                }
              }
              return false;
            }
        ).collect(Collectors.toList());
  }

  @Override
  public List getListOfResult() {
    return listOfRoutes;
  }

}

