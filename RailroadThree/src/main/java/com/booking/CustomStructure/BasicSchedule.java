package com.booking.CustomStructure;


import java.time.LocalDate;
import java.util.Map;

public class BasicSchedule implements IBasicSchedule {

  // Map<String,String > where key it's LocaleDate in String and value it's path to file where we have Day which is serialized

  private static Map<LocalDate, IDay> basicSchedule;

  public BasicSchedule(Map<LocalDate, IDay> schedule) {
    basicSchedule = schedule;
  }

  @Override
  public void addDay(IDay iDay) {
    basicSchedule.put(iDay.getDate(), iDay);
  }

  @Override
  public void removeDay(LocalDate localDate) {
    basicSchedule.remove(localDate);
  }

  @Override
  public IDay getScheduleForCertainDay(LocalDate localDate) {
    return basicSchedule.get(localDate);
  }

  public static void setBasicSchedule(
      Map<LocalDate, IDay> basicSchedule) {
    BasicSchedule.basicSchedule = basicSchedule;
  }

  public static Map<LocalDate, IDay> getBasicSchedule() {
    return basicSchedule;
  }

}
