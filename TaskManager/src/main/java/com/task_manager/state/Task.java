package com.task_manager.state;

public class Task {

  private Status status;
  private String name;

  public Task(String name) {
    this.name = name;
    this.status = new OpenStatus(this);
  }

  protected void changeStatus(Status status) {
    this.status = status;
  }

  public void changeStatusToOpen() {
    System.out.println(status.onOpen());
  }

  public void changeStatusToProgress() {
    System.out.println(status.onInProgress());
  }

  public void changeStatusToResolved() {
    System.out.println(status.onResolved());
  }

  public void changeStatusToReopen() {
    System.out.println(status.onReopen());
  }

  public void changeStatusToClose() {
    System.out.println(status.onClose());
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Task - " + name
        + "\nstatus: " + status.toString();
  }
}