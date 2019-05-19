package com.booking.CustomStructure;

import com.booking.model.station_info.Route;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class WeekDay implements IWeekDay, Serializable {

  private LocalDate localDate;
  private List<Route> routes;

  @Override
  public void setDate(LocalDate localDate) {
    this.localDate = localDate;
  }

  @Override
  public LocalDate getDate() {
    return localDate;
  }

  @Override
  public void setRoutes(List<Route> list) {
    routes = list;
  }

  @Override
  public List<Route> getRoutes() {
    return routes;
  }

  @Override
  public String toString() {
    return "WeekDay{" +
        "localDate=" + localDate +
        ", routes=" + routes +
        '}';
  }
}
