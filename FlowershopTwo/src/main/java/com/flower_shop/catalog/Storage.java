package com.flower_shop.catalog;

import java.util.Objects;

public class Storage {

  private String name;
  private int count;

  public Storage(String name, int count) {
    this.name = name;
    this.count = count;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Storage)) {
      return false;
    }
    Storage storage = (Storage) o;
    return count == storage.count &&
        Objects.equals(name, storage.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, count);
  }

  @Override
  public String toString() {
    return name + ", count=" + count;
  }
}
