package com.booking.model.station_info;

import com.booking.model.train.Train;

import java.time.LocalDate;
import java.util.List;

public class Route {

    private int route_Id;
    private List<Station> stations;
    private Train train;
    private LocalDate date;

    public Route(int route_Id,List<Station> stations, Train train, LocalDate date) {
        this.route_Id = route_Id;
        this.stations = stations;
        this.train = train;
        this.date = date;
    }

    public Route() {
    }

    public int getRoute_Id() {
        return route_Id;
    }

    public void setRoute_Id(int route_Id) {
        this.route_Id = route_Id;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Route№ " + route_Id +
                "\n\tTrain№" + train.getTrainId() +
                "\n\tDate =" + date +"\n";
    }
}
