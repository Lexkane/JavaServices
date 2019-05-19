package com.booking.builder;

import com.booking.model.station_info.Route;
import com.booking.model.station_info.Station;
import com.booking.model.train.Train;
import java.time.LocalDate;


public interface ITicketBuilder extends Builder {

  void createID();

  void setDeparture(Station stationFrom);

  void setDestination(Station stationTo);

  void setDate(LocalDate date);

  void setSeat(int seat);

  void setPrice(Route route);

  void setCoachId(int coachId);

  void setTrainID(Train train);



}
