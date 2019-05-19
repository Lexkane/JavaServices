package com.booking.CustomStructure;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IBasicSchedule extends Schedule {

  <T extends IDay> void addDay(T iDay);

  void removeDay(LocalDate localDate);

  IDay getScheduleForCertainDay(LocalDate localDate);


}
