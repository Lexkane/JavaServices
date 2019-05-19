package com.booking.builder;


import com.booking.model.station_info.Station;

public class StationBuilder implements IStationBuilder{


  @Override
  public Station getResult() {
    return new Station(0L,null);
  }
}
