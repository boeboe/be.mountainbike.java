/**
 * 
 */
package be.mountainbike.java;

import be.mountainbike.java.interfaces.IExcursionOverview;

public class ExcursionOverview implements IExcursionOverview {
  private String fCity;
  private String fDetailsUrl;
  private String fProvince;
  private String fTourTitle;
  private String fCountry;
  private String fDate;
  
  public ExcursionOverview(String date, String city, String detailsUrl) {
    fDate = date;
    fCity = city;
    fDetailsUrl = detailsUrl;
  }

  public void setProvince(String province) {
    fProvince = province;
  }

  public void setTourTitle(String tourTitle) {
    fTourTitle = tourTitle;
  }

  public void setCountry(String country) {
    fCountry = country;
  }

  @Override
  public String getDetailsUrl() {
    return fDetailsUrl;
  }

  @Override
  public String getCity() {
    return fCity;
  }

  @Override
  public String getProvince() {
    return fProvince;
  }

  @Override
  public String getTourTitle() {
    return fTourTitle;
  }

  @Override
  public String getCountry() {
    return fCountry;
  }

  @Override
  public String getDate() {
    return fDate;
  }

  @Override
  public String toString() {
    return "ExcursionOverview [fCity=" + fCity + ", fDetailsUrl=" + fDetailsUrl
        + ", fProvince=" + fProvince + ", fTourTitle=" + fTourTitle
        + ", fCountry=" + fCountry + ", fDate=" + fDate + "]";
  }
}
