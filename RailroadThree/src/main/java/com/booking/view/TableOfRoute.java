package com.booking.view;

import com.booking.model.station_info.Route;

import java.util.List;
import java.util.Scanner;

class TableOfRoute implements Viewer{

  private Route route;

  public TableOfRoute(Viewer viewer) {

    show(viewer.getListOfResult());
  }

  @Override
  public void show(List list) {
    list.forEach(System.out::println);
    System.out.println("Please select route:");

    Scanner scanner = new Scanner(System.in);
    int check = scanner.nextInt();
    route = (Route) list.get(check - 1);
    new Type(this);

  }

  @Override
  public Route getRoute() {
    return route;
  }
}
