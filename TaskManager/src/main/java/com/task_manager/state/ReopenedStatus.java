package com.task_manager.state;

public class ReopenedStatus extends Status {

  public ReopenedStatus(Task task) {
    super(task);
  }

  @Override
  public String onInProgress() {
    task.changeStatus(new InProgressStatus(task));
    return "In progress!!";
  }

  @Override
  public String onReopen() {
    return "Already there!!!";
  }

  @Override
  public String toString() {
    return "Reopened";
  }
}
