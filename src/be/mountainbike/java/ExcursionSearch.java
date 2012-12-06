package be.mountainbike.java;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import be.mountainbike.java.interfaces.IExcursionOverview;

public class ExcursionSearch  {
  private final static String BASE_URL = "http://www.mountainbike.be/";
  private final static boolean DEBUG = false;

  public static ArrayList<IExcursionOverview> getExcursions() {
    ArrayList<IExcursionOverview> fExcursionOverviewList = new ArrayList<IExcursionOverview>();
    Document doc;
    try {
      doc = Jsoup.connect(BASE_URL + "toertochten").get();
      fExcursionOverviewList = getExcursionOverwiew(doc);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return fExcursionOverviewList;
  }

  public static ArrayList<IExcursionOverview> getExcursions(int year, int weekNr) {
    ArrayList<IExcursionOverview> fExcursionOverviewList = new ArrayList<IExcursionOverview>();
    Document doc;
    try {
      doc = Jsoup.connect(BASE_URL + "toertochten?date=" + year + "-W" + weekNr).get();
      fExcursionOverviewList = getExcursionOverwiew(doc);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return fExcursionOverviewList;
  }

  private static ArrayList<IExcursionOverview> getExcursionOverwiew(Document doc) {
    ArrayList<IExcursionOverview> excursionOverviewList = new ArrayList<IExcursionOverview>();
    Element excursionsOverview = doc.getElementsByClass("excursions-overview").get(0);
    
    Elements excursionsOverviewsPerDate = excursionsOverview.getElementsByClass("exc_b");
    for (Element excursionOverviewsPerDate : excursionsOverviewsPerDate) {
      String date = excursionOverviewsPerDate.getElementsByClass("date-display-single").get(0).text();
      Elements viewRows = excursionsOverview.getElementsByClass("views-row");
  
      for (Element row : viewRows) {
        Element city = row.getElementsByClass("views-field-field-city").get(0);
        ExcursionOverview excursionOverview = new ExcursionOverview(date, city.text(),
            city.getElementsByTag("a").attr("href"));
  
        Element province = row.getElementsByClass("views-field-field-province").get(0);
        excursionOverview.setProvince(province.text());
  
        Element tourTitle = row.getElementsByClass("views-field-field-tour-title").get(0);
        excursionOverview.setTourTitle(tourTitle.text());
  
        Element country = row.getElementsByClass("views-field-nothing").get(0);
        excursionOverview.setCountry(country.getElementsByTag("img").attr("alt"));
  
        if (DEBUG) {
          System.out.println("Date: " + date);
          System.out.println("DetailsUrl: " + city.getElementsByTag("a").attr("href"));
          System.out.println("City: " + city.text());
          System.out.println("Province: " + province.text());
          System.out.println("TourTitle: " + tourTitle.text());
          System.out.println("Country: " + country.getElementsByTag("img").attr("alt"));
        }
  
        excursionOverviewList.add(excursionOverview);
      }
    }
    return excursionOverviewList;
  }
}
