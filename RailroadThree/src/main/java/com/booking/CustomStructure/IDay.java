package com.booking.CustomStructure;

import com.booking.model.station_info.Route;
import java.time.LocalDate;
import java.util.List;

public interface IDay {

  void setDate(LocalDate localDate);

  LocalDate getDate();

  void setRoutes(List<Route> list);

  List<Route> getRoutes();
}
