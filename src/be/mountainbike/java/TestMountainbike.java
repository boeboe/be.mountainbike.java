package be.mountainbike.java;

import java.util.ArrayList;

import be.mountainbike.java.interfaces.IExcursionOverview;

public class TestMountainbike {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ArrayList<IExcursionOverview> excursionOverviewList = ExcursionSearch.getExcursions();
    for (IExcursionOverview res: excursionOverviewList) {
      System.out.println("Searching excursion list from today onwards...");
      System.out.println(res.toString());
    }

    ArrayList<IExcursionOverview> excursionOverviewListFuture = ExcursionSearch.getExcursions(2013,10);
    for (IExcursionOverview res: excursionOverviewListFuture) {
      System.out.println("Searching excursion list from WK10-2013");
      System.out.println(res.toString());
    }
  }
}
