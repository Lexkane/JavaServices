package ChildrenHoliday.Types_Of_Activity;

import ChildrenHoliday.Elements.Place;

public class AnimatorShow implements Activity {

  private final double price = 200;
  private final Place place = Place.OUTSIDE;
  private final double time = 2.5;

  @Override
  public void startOfActivity() {
    System.out.println("Welcome to our animator show !!!");
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
    return "AnimatorShow:" +
        " price=" + price +
        " place=" + place +
        " time=" + time;
  }

}