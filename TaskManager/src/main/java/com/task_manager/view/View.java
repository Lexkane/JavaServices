package com.task_manager.view;

import com.task_manager.state.Task;
import java.util.HashMap;
import java.util.LinkedHashMap;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;


public class View {

  private static Map<String, String> menu = new LinkedHashMap<>(3);
  private static Map<String, Runnable> commandMap = new HashMap<>(3);
  private static Map<String, String> statusMenu = new LinkedHashMap<>(5);
  private static Map<String, Consumer<Task>> statusCommandMap = new HashMap<>(5);

  private static Map<Integer, Task> taskMap = new LinkedHashMap<>();


  public static void main(String[] args) {
    new View().start();
  }


  private void start() {
    initMenu();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      menu.forEach((a, b) -> System.out.println(a + " " + b));
      commandMap.get(scanner.next()).run();
    }
  }

  private void initMenu() {

    menu.put("1", "Show tasks");
    menu.put("2", "Add task");
    menu.put("3", "Set new status for task");
    menu.put("4", "Exit");

    commandMap.put("1", this::showTask);
    commandMap.put("2", this::addTask);
    commandMap.put("3", this::setNewStatusForTask);
    commandMap.put("4", this::exit);

    statusMenu.put("1", "Open");
    statusMenu.put("2", "Progress");
    statusMenu.put("3", "Resolved");
    statusMenu.put("4", "Reopen");
    statusMenu.put("5", "Close");

    statusCommandMap.put("1", new TaskCommand()::setStatusOpen);
    statusCommandMap.put("2", new TaskCommand()::setStatusProgress);
    statusCommandMap.put("3", new TaskCommand()::setStatusResolved);
    statusCommandMap.put("4", new TaskCommand()::setStatusReopen);
    statusCommandMap.put("5", new TaskCommand()::setStatusClose);

  }

  private void showTask() {
    if (taskMap.size() == 0) {
      System.out.println("You don't have any task");
    } else {
      taskMap.forEach((a, b) -> System.out.println(a + " " + b));
    }
  }

  private void addTask() {
    System.out.println("Please write your task");
    taskMap.put(taskMap.size() + 1, new Task(new Scanner(System.in).nextLine()));
    System.out.println("Finish");
  }

  private void setNewStatusForTask() {
    System.out.println("Please choose task");
    taskMap.forEach((a, b) -> System.out.println(a + " " + b));

    Task temp = taskMap.get(new Scanner(System.in).nextInt());

    System.out.println("Please set new Status\n");
    statusMenu.forEach((a, b) -> System.out.println(a + " " + b));

    statusCommandMap.get(new Scanner(System.in).next()).accept(temp);

  }

  private void exit() {
    System.exit(0);
  }

}
