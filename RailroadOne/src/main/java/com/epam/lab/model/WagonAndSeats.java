package com.epam.lab.model;

import java.util.ArrayList;
import java.util.List;


public class WagonAndSeats {
  // just wagon number
  private int wagonNumber;
  // list of seats are predefined and is initialized by 'initSeatList' method
  private List<Boolean> seatList;

  public WagonAndSeats(int wagonNumber) {
    this.wagonNumber = wagonNumber;
    this.seatList = initSeatList(); // seatList is initialized here
  }

  // seatList size always equals 20 (it can be changed by setting a new value for seatQuantity)
  private List<Boolean> initSeatList() {
    int seatQuantity = 20;
    List<Boolean> tempSeatList = new ArrayList<>();
    for (int i = 1; i<=seatQuantity; i++) {
      tempSeatList.add(false); // by default all seats are available; i use 'false' to mark it as available
    }
    return tempSeatList;
  }

  public int getWagonNumber() {
    return wagonNumber;
  }

  public void setWagonNumber(int wagonNumber) {
    this.wagonNumber = wagonNumber;
  }

  public List<Boolean> getSeatList() {
    return seatList;
  }

  public void setSeatList(List<Boolean> seatList) {
    this.seatList = seatList;
  }

  @Override
  public String toString() {
    return "WagonAndSeats {" +

        "wagonNumber = " + wagonNumber +
        ", seatQuantity = " + seatList.size() +
        '}';

  }
}

