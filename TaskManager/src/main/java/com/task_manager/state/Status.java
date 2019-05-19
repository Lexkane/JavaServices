package com.task_manager.state;

import java.util.Objects;

public abstract class Status {

  protected Task task;

  public Status(Task task) {
    this.task = task;
  }

  public String onOpen() {
    return "We can`t do this!!";
  }

  public String onInProgress() {
    return "We can`t do this!!";
  }

  public String onResolved() {
    return "We can`t do this!!";
  }

  public String onReopen() {
    return "We can`t do this!!";
  }

  public String onClose() {
    return "We can`t do this!!";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Status)) {
      return false;
    }
    Status status = (Status) o;
    return task.equals(status.task);
  }

  @Override
  public int hashCode() {
    return Objects.hash(task);
  }
}
