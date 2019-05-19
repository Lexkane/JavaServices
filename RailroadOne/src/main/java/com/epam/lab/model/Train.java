package com.epam.lab.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Train {

  private String name;
  private List<Station> stationList; // this is list of stations for a specific train, in other words its route

  private List<WagonAndSeats> wagonList = new ArrayList<>(); // list of wagons (with their seats) for a specific train
  private Map<Station, List<WagonAndSeats>> trainData = new HashMap<>(); // map for booking processing; it stores all the information about the train movement grouped by stations

  public Train(String name, List<Station> stationList) {
    this.name = name;
    this.stationList = stationList;
  }

  public void setWagonList(List<WagonAndSeats> wagonList) {
    this.wagonList = wagonList;
  }

  public List<WagonAndSeats> getWagonList() {
    return wagonList;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Station> getStationList() {
    return stationList;
  }

  public void setStationList(List<Station> stationList) {
    this.stationList = stationList;
  }

  public Map<Station, List<WagonAndSeats>> getTrainData() {
    return trainData;
  }

  public void setTrainData(Map<Station, List<WagonAndSeats>> train) {
    this.trainData = train;
  }


  @Override
  public String toString() {
    return "Train{" +
            "name='" + name + '\'' +
            ", stationList=" + stationList +
            ", train=" + trainData +
            '}';
  }
}

