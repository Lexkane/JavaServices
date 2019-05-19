package com.booking.view;

import com.booking.model.station_info.Route;
import com.booking.model.train.Coach;
import java.util.List;

public interface Viewer {

  default void show(List list) {
    System.out.println("default show(List list) method");
  }

  default void show() {
    System.out.println("default show(List list) method");
  }

  //This method have only Selector
  default List getListOfResult() {
    System.out.println("Default method getListOfResult()");
    return null;
  }

  //This method have only TableOfRoute and Type class in this moment
  default Route getRoute() {
    System.out.println("Default method for getRoute()");
    return null;
  }

  //This methods have only Type class in this moment

  default List<Coach> getCoaches() {
    System.out.println("Default method for getCoaches()");
    return null;
  }

  default void setCoachesByType(String type, List<Coach> list) {
    System.out.println("Default method for setCoachesByType()");
  }

}
