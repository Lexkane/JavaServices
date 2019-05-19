package ChildrenHoliday;

import ChildrenHoliday.Types_Of_Activity.Activity;
import ChildrenHoliday.Types_Of_Activity.AnimatorShow;
import ChildrenHoliday.Types_Of_Activity.Painting;
import ChildrenHoliday.Types_Of_Activity.SoapBubbles;
import ChildrenHoliday.Types_Of_Activity.Trampoline;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StartParty {

  public static void main(String[] args) {
    System.out.println("Our price list:");
    List<Activity> list = new ArrayList<>();
    list.add(new AnimatorShow());
    list.add(new Trampoline());
    list.add(new SoapBubbles());
    list.add(new Painting());

    System.out.println("\nSorted by price:");
    list.stream()
        .sorted(Comparator.comparing(Activity::getPrice))
        .forEach(System.out::println);

    System.out.println("\nSorted by time:");
    list.stream()
        .sorted(Comparator.comparing(Activity::getTime))
        .forEach(System.out::println);
  }
}
