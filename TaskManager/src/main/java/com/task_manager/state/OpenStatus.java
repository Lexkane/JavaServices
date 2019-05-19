package com.task_manager.state;

public class OpenStatus extends Status {

  public OpenStatus(Task task) {
    super(task);
  }

  @Override
  public String onOpen() {
    return "Already opened!!";
  }

  @Override
  public String onInProgress() {
    task.changeStatus(new InProgressStatus(task));
    return "Now task is InProgress";
  }

  @Override
  public String onClose() {
    task.changeStatus(new ClosedStatus(task));
    return "Task was closed!!!";
  }

  @Override
  public String toString() {
    return "Open";
  }
}
