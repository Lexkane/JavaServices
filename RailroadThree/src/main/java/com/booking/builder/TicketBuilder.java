package com.booking.builder;

import com.booking.model.station_info.Route;
import com.booking.model.station_info.Station;
import com.booking.model.station_info.Ticket;
import com.booking.model.train.Train;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;


public class TicketBuilder implements ITicketBuilder{

    private static int id;
    private String departure;
    private String destination;
    private LocalDate date;
    private int seat;
    private double price;
    private int coachId;
    private int trainId;

    public TicketBuilder(Route route, LocalDate date, int coach_id, int seat_id) {
        createID();
        setDeparture(route.getStations().get(0));
        setDestination(route.getStations().
                get(route.getStations().size() - 1));
        setDate(date);
        setSeat(seat_id);
        setPrice(route);
        setCoachId(coach_id);
        setTrainID(route.getTrain());
    }

    @Override
    public void createID() {
        id++;
    }

    @Override
    public void setDeparture(Station stationFrom) {
        departure = stationFrom.getStationName();
    }

    @Override
    public void setDestination(Station stationTo) {
        destination = stationTo.getStationName();
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public void setPrice(Route route) {
        final int PRICE_COEFFICIENT = 60;
        price = PRICE_COEFFICIENT +
                route.getStations().size() +
                route.getTrain().getType().getBasicPrice() +
                route.getTrain().getCoaches().get(coachId).getCoachType().getBasicPrice();
    }

    @Override
    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    @Override
    public void setTrainID(Train train) {
        this.trainId = train.getTrainId();
    }

    @Override
    public Ticket getResult() {
        return new Ticket(id, departure, destination, date, seat, price, coachId, trainId);
    }


}
