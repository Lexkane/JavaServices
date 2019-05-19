package com.task_manager.view;

import com.task_manager.state.Task;

final class TaskCommand {

  protected void setStatusOpen(Task task) {
    task.changeStatusToOpen();
  }
  protected void setStatusProgress(Task task) {
    task.changeStatusToProgress();
  }

  protected void setStatusResolved(Task task) {
    task.changeStatusToResolved();
  }

  protected void setStatusReopen(Task task) {
    task.changeStatusToReopen();
  }

  protected void setStatusClose(Task task) {
    task.changeStatusToClose();
  }


}
