package com.task_manager.state;

public class InProgressStatus extends Status {

  public InProgressStatus(Task task) {
    super(task);
  }

  @Override
  public String onOpen() {
    task.changeStatus(new OpenStatus(task));
    return "Open!!!";
  }

  @Override
  public String onInProgress() {
    return "Already there!!";
  }

  @Override
  public String onResolved() {
    task.changeStatus(new ResolvedStatus(task));
    return "Resolved!!!";
  }

  @Override
  public String toString() {
    return "In progress";
  }
}
