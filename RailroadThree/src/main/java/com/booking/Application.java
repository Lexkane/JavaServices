package com.booking;

import com.booking.CustomStructure.BasicSchedule;
import com.booking.CustomStructure.IDay;
import com.booking.CustomStructure.IWeekDay;
import com.booking.CustomStructure.Schedule;
import com.booking.CustomStructure.WeekDay;
import com.booking.model.station_info.Route;
import com.booking.model.station_info.Station;
import com.booking.model.station_info.Ticket;
import com.booking.model.train.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Application {

  //Observed pattern
  public static List<Ticket> tickets;

  public static void main(String[] args) {
    init();
    BasicSchedule.getBasicSchedule().forEach((a, b) -> System.out.println(a + " " + b));
  }

  private static void init() {

    List<Route> routes = new LinkedList<>();
    List<Station> stations = new LinkedList<>();
    stations.add(new Station(1, "Lviv"));
    stations.add(new Station(2, "Ternopil"));
    stations.add(new Station(3, "Vinnitsya"));
    stations.add(new Station(4, "Kyiv"));

    List<Seat> seats = new LinkedList<>();
    seats.add(new Seat(1));
    seats.add(new Seat(2));
    seats.add(new Seat(3));
    seats.add(new Seat(4));
    seats.add(new Seat(5));

    List<Coach> coaches = new LinkedList<>();
    coaches.add(new Coach(1, seats, CoachType.BERTH));
    coaches.add(new Coach(2, seats, CoachType.COMPT));
    coaches.add(new Coach(3, seats, CoachType.DELUXE));

    Train train = new Train(123, TrainType.SPEED_TRAIN, coaches);
    LocalDate date = LocalDate.of(2019, 2, 1);
    routes.add(new Route(1, stations, train, date));
    IWeekDay weekDay = new WeekDay();
    weekDay.setDate(date);
    weekDay.setRoutes(routes);

    Map<LocalDate, IDay> basicSchedule = new HashMap<>();
    basicSchedule.put(weekDay.getDate(), weekDay);

    BasicSchedule.setBasicSchedule(basicSchedule);


  }
}
