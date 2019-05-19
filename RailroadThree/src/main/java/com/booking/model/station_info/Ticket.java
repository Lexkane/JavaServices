package com.booking.model.station_info;

import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Stream;


public class Ticket {

    private int id;
    private String departure;
    private String destination;
    private LocalDate date;
    private int seat;
    private double price;
    private int coach_id;
    private int train_id;

    public Ticket(int id, String departure, String destination, LocalDate date, int seat, double price,
                  int coach_id, int train_id) {
        Stream.of(id, departure, destination, date).forEach(Objects::requireNonNull);
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.date = date;
        this.seat = seat;
        this.price = price;
        this.coach_id = coach_id;
        this.train_id = train_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }


    @Override
    public String toString() {
        return "Ticket №" + id + "\n" +
                "From  " + departure +
                " to " + destination + '\n' +
                "Date " + date +
                "\n\tSeat \t\t\t" + seat +
                "\n\tCoach number\t" + coach_id +
                "\n\tTrain \t\t\t" + train_id +
                "\n\n\t\tPrice=" + price + "\n\n";
    }
}
