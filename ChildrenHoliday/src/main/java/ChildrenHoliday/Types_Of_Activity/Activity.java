 package ChildrenHoliday.Types_Of_Activity;

import ChildrenHoliday.Elements.Place;


public interface Activity {

  Place getPlace();

  double getPrice();

  double getTime();

  void startOfActivity();

  void endOfActivity();


}