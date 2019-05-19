package com.task_manager.state;

public class ClosedStatus extends Status {

  public ClosedStatus(Task task) {
    super(task);
  }

  @Override
  public String onOpen() {
    task.changeStatus(new OpenStatus(task));
    return "Open!!";
  }

  @Override
  public String onClose() {
    return "Already there!!!";
  }

  @Override
  public String toString() {
    return "Closed";
  }
}
