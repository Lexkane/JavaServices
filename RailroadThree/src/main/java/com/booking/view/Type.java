package com.booking.view;

import com.booking.model.station_info.Route;
import com.booking.model.train.Coach;
import com.booking.model.train.CoachType;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Type implements Viewer {

  private List<Coach> coachList;
  private Viewer viewer;

  public Type(Viewer viewer) {
    this.viewer = viewer;
    show();
  }


  @Override
  public void show() {

    System.out.println("Please select type of coach :\n");

    for (CoachType coachType : CoachType.values()) {
      System.out.print(coachType + "\t");
    }

    Scanner scanner = new Scanner(System.in);
    String type = scanner.nextLine();

    setCoachesByType(type, viewer.getRoute().getTrain().getCoaches());

    new TableOfTicket(this);

  }

  @Override
  public void setCoachesByType(String type, List<Coach> list) {
    coachList = list.stream()
        .filter(a -> a.getCoachType()
            .toString()
            .trim()
            .equalsIgnoreCase(type)
        )
        .collect(Collectors.toList());
  }

  @Override
  public List<Coach> getCoaches() {
    return coachList;
  }


  @Override
  public Route getRoute() {
    return viewer.getRoute();
  }
}
