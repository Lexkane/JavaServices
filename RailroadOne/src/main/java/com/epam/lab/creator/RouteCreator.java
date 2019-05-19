package com.epam.lab.creator;

import com.epam.lab.model.Station;
import com.epam.lab.model.Train;

import com.epam.lab.model.WagonAndSeats;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteCreator {

  private List<Station> stations;
  private Map<Station, List<WagonAndSeats>> trainData = new HashMap<>();
  private List<WagonAndSeats> wagonList;

  public RouteCreator() {
    stations = new ArrayList<>();
  }

  public List<Station> createLvivKharkivStations() {
    return Arrays.asList(Station.LVIV, Station.LUTSK, Station.KYIV, Station.KHARKIV);
  }

  public List<Station> createLvivDniproStations() {
    return Arrays.asList(Station.LVIV, Station.TERNOPIL, Station.KYIV, Station.POLTAVA, Station.DNIPRO);
  }

  public List<Station> createIvanoFrankivskLutskStations() {
    return Arrays.asList(Station.IVANO_FRANKIVSK, Station.TERNOPIL, Station.LUTSK);
  }

  public List<Station> createIvanoFrankivskKharkivStations() {
    return Arrays.asList(Station.IVANO_FRANKIVSK, Station.LUTSK, Station.KYIV, Station.DNIPRO, Station.KHARKIV);
  }

  Map<Station, List<WagonAndSeats>> initlvivKharkivMap(List<WagonAndSeats> wagonList) {
    Map<Station, List<WagonAndSeats>> lvivKharkivMap = new HashMap<>();

    lvivKharkivMap.put(Station.LVIV, wagonList);
    lvivKharkivMap.put(Station.LUTSK, wagonList);
    lvivKharkivMap.put(Station.KYIV, wagonList);
    lvivKharkivMap.put(Station.KHARKIV, wagonList);

    return lvivKharkivMap;
  }

  Map<Station, List<WagonAndSeats>> initlvivDniproMap(List<WagonAndSeats> wagonList) {
    Map<Station, List<WagonAndSeats>> ivanoFrankivskLutskMap = new HashMap<>();

    ivanoFrankivskLutskMap.put(Station.IVANO_FRANKIVSK, wagonList);
    ivanoFrankivskLutskMap.put(Station.TERNOPIL, wagonList);
    ivanoFrankivskLutskMap.put(Station.LUTSK, wagonList);

    return ivanoFrankivskLutskMap;
  }

  Map<Station, List<WagonAndSeats>> initIvanoFrankivskLutskMap(List<WagonAndSeats> wagonList) {
    Map<Station, List<WagonAndSeats>> lvivDniproMap = new HashMap<>();

    lvivDniproMap.put(Station.LVIV, wagonList);
    lvivDniproMap.put(Station.TERNOPIL, wagonList);
    lvivDniproMap.put(Station.KYIV, wagonList);
    lvivDniproMap.put(Station.POLTAVA, wagonList);
    lvivDniproMap.put(Station.DNIPRO, wagonList);

    return lvivDniproMap;
  }

  Map<Station, List<WagonAndSeats>> initIvanoFrankivskKharkivMap(List<WagonAndSeats> wagonList) {
    Map<Station, List<WagonAndSeats>> ivanoFrankivskKharkivMap = new HashMap<>();

    ivanoFrankivskKharkivMap.put(Station.IVANO_FRANKIVSK, wagonList);
    ivanoFrankivskKharkivMap.put(Station.LUTSK, wagonList);
    ivanoFrankivskKharkivMap.put(Station.KYIV, wagonList);
    ivanoFrankivskKharkivMap.put(Station.DNIPRO, wagonList);
    ivanoFrankivskKharkivMap.put(Station.KHARKIV, wagonList);

    return ivanoFrankivskKharkivMap;
  }

  public List<Station> getStations() {
    stations = createLvivKharkivStations();
    return stations;
  }

}
