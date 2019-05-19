package com.booking.view;

import com.booking.Application;
import com.booking.model.station_info.Route;
import com.booking.model.station_info.Ticket;
import com.booking.builder.TicketBuilder;
import com.booking.model.train.Coach;
import com.booking.model.train.Seat;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class TableOfTicket {

  public TableOfTicket(Viewer viewer) {

    Route route = viewer.getRoute();

    Application.tickets = new LinkedList<>();
    List<Ticket> AvailableTickets = new LinkedList<>();

    for (Coach coach : viewer.getCoaches()) {
      for (Seat seat : coach.getSeats()) {
        if (isFreeSeat(seat, route)) {
          AvailableTickets.add(
              new TicketBuilder(
                  route, route.getDate(),
                  coach.getCoachId(),
                  seat.getSeatId()
              ).getResult()
          );
        }
      }
    }

    for (Ticket ticket : AvailableTickets) {
      System.out.println(ticket);
    }

    System.out.println("Please select place :");
    Scanner scanner = new Scanner(System.in);
    int numberOfSeat = scanner.nextInt();
    System.out.println("Thank you for buying!!\n\nYour ticket: "
        + AvailableTickets.get(numberOfSeat - 1));
    Application.tickets.add(AvailableTickets.get(numberOfSeat - 1));
  }

  //this method in development
  public boolean isFreeSeat(Seat seat, Route route) {
    List<Ticket> tickets = Application.tickets.stream().
        filter(a -> a.getDate().equals(route.getDate())).collect(Collectors.toList());

    return tickets.isEmpty();
  }
}
