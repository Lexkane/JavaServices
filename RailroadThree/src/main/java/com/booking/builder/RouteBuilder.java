package com.booking.builder;

import com.booking.model.station_info.Route;

public class RouteBuilder implements IRouteBuilder {

  @Override
  public Route getResult() {
    return new Route();
  }
}
