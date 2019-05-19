package com.epam.lab.creator;

import com.epam.lab.model.Station;
import com.epam.lab.model.Train;
import com.epam.lab.model.WagonAndSeats;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrainCreator {

  public List<Train> createTrains() {

    List<Train> trains = new ArrayList<>();
    RouteCreator routeCreator = new RouteCreator();

    // Lviv-Kharkiv (Lviv-Lutsk-Kyiv-Kharkiv)
    Train lvivKharkiv = new Train("Lviv-Kharkiv LK123", routeCreator.createLvivKharkivStations());
    List<WagonAndSeats> lvivKharkivWagonAndSeats = initWagonList();
    Map<Station, List<WagonAndSeats>> trainData = routeCreator.initlvivKharkivMap(lvivKharkivWagonAndSeats);
    lvivKharkiv.setTrainData(trainData);
    lvivKharkiv.setWagonList(lvivKharkivWagonAndSeats);
    trains.add(lvivKharkiv);

    // Lviv-Dnipro (Lviv-Ternopil-Kyiv-Poltava-Dnipro)
    Train lvivDnipro = new Train("Lviv-Dnipro LD234", routeCreator.createLvivDniproStations());
    List<WagonAndSeats> lvivDniproWagonAndSeats = initWagonList();
    trainData = routeCreator.initlvivDniproMap(lvivDniproWagonAndSeats);
    lvivDnipro.setTrainData(trainData);
    lvivDnipro.setWagonList(lvivDniproWagonAndSeats);
    trains.add(lvivDnipro);

    // IvanoFrankivsk-Lutsk (IvanoFrankivsk-Ternopil-Lutsk)
    Train ivanoFrankivskLutsk = new Train("IvanoFrankivsk-Lutsk IFL345", routeCreator.createIvanoFrankivskLutskStations());
    List<WagonAndSeats> ivanoFrankivskLutskWagonAndSeats = initWagonList();
    trainData = routeCreator.initIvanoFrankivskLutskMap(ivanoFrankivskLutskWagonAndSeats);
    ivanoFrankivskLutsk.setTrainData(trainData);
    ivanoFrankivskLutsk.setWagonList(ivanoFrankivskLutskWagonAndSeats);
    trains.add(ivanoFrankivskLutsk);

    // IvanoFrankivsk-Kharkiv (IvanoFrankivsk-Lutsk-Kyiv-Dnipro-Kharkiv)
    Train ivanoFrankivskKharkiv = new Train("IvanoFrankivsk-Kharkiv IFK456", routeCreator.createIvanoFrankivskKharkivStations());
    List<WagonAndSeats> ivanoFrankivskKharkivWagonAndSeats = initWagonList();
    trainData = routeCreator.initIvanoFrankivskKharkivMap(ivanoFrankivskKharkivWagonAndSeats);
    ivanoFrankivskKharkiv.setTrainData(trainData);
    ivanoFrankivskKharkiv.setWagonList(ivanoFrankivskKharkivWagonAndSeats);
    trains.add(ivanoFrankivskKharkiv);

    return trains;
  }

  private List<WagonAndSeats> initWagonList() {
    List<WagonAndSeats> wagonList = new ArrayList<>();
    int wagonQuantity = 5;
    for (int i = 1; i <= wagonQuantity; i++) {
      wagonList.add(new WagonAndSeats(i));
    }
    return wagonList;
  }


}
