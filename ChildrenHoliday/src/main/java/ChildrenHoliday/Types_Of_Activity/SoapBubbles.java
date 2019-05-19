package ChildrenHoliday.Types_Of_Activity;

import ChildrenHoliday.Elements.Place;

public class SoapBubbles implements Activity {

  private final double price = 50;
  private final Place place = Place.INSIDE;
  private final double time = 1.0;

  @Override
  public void startOfActivity() {
    System.out.println("Welcome to our soup bubble trip!!!");
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
    return "SoapBubbles:" +
        " price=" + price +
        " place=" + place +
        " time=" + time;
  }

}
