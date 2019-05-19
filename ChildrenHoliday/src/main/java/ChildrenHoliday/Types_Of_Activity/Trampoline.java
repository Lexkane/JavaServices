package ChildrenHoliday.Types_Of_Activity;

import ChildrenHoliday.Elements.Place;

public class Trampoline implements Activity {

  private final double price = 50;
  private final Place place = Place.OUTSIDE;
  private final double time = 0.5;

  @Override
  public void startOfActivity() {
    System.out.println("start jump on trampoline !!!");
  }

  @Override
  public void endOfActivity() {
    System.out.println("End jumping !");
  }

  @Override
  public Place getPlace() {
    return place;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public double getTime() {
    return time;
  }

  @Override
  public String toString() {
    return "Trampoline:" +
        " price=" + price +
        " place=" + place +
        " time=" + time;
  }

}
