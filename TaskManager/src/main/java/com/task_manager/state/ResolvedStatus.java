package com.task_manager.state;

public class ResolvedStatus extends Status {

  public ResolvedStatus(Task task) {
    super(task);
  }

  @Override
  public String onResolved() {
    return "Already there!!!";
  }

  @Override
  public String onReopen() {
    task.changeStatus(new ReopenedStatus(task));
    return "Reopen!!";
  }

  @Override
  public String onClose() {
    task.changeStatus(new ClosedStatus(task));
    return "Task was closed";
  }

  @Override
  public String toString() {
    return "Resolved";
  }
}
