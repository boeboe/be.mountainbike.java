package be.mountainbike.java;

import java.util.ArrayList;

import be.mountainbike.java.interfaces.IExcursionDetails;
import be.mountainbike.java.interfaces.IExcursionOverview;

public class TestMountainbike {

  /**
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("--- Searching excursion list from today onwards ---");
    ArrayList<IExcursionOverview> excursionOverviewList = ExcursionSearch.getExcursions();
    ArrayList<IExcursionDetails> excursionDetailsList = new ArrayList<IExcursionDetails>();
    for (IExcursionOverview res: excursionOverviewList) {
      System.out.println(res.toString());
      ExcursionDetails details = (ExcursionDetails) ExcursionSearch.getExcursionDetails(res.getDetailsUrl());
      System.out.println(details.toString());
      excursionDetailsList.add(details);
    }

    System.out.println("--- Searching excursion list from WK10-2013 ---");
    ArrayList<IExcursionOverview> excursionOverviewListFuture = ExcursionSearch.getExcursions(2013,10);
    ArrayList<IExcursionDetails> excursionDetailsListFuture = new ArrayList<IExcursionDetails>();
    for (IExcursionOverview res: excursionOverviewListFuture) {
      System.out.println(res.toString());
      IExcursionDetails details = ExcursionSearch.getExcursionDetails(res.getDetailsUrl());
      System.out.println(details.toString());
      excursionDetailsListFuture.add(details);
    }
  }
}
