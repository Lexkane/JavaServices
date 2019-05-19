package ChildrenHoliday.Types_Of_Activity;

import ChildrenHoliday.Elements.Place;

public class Painting implements Activity {

  private final double price = 150;
  private final Place place = Place.INSIDE;
  private final double time = 1.5;

  @Override
  public void startOfActivity() {
    System.out.println("Welcome to our painting masterclass!!!");
  }

  @Override
  public void endOfActivity() {
    System.out.println("Thank you for your attention !");
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
    return "Painting:" +
        " price=" + price +
        " place=" + place +
        " time=" + time;
  }

}

