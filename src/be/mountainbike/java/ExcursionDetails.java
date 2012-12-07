package be.mountainbike.java;

import java.util.Date;

import be.mountainbike.java.interfaces.IExcursionDetails;

public class ExcursionDetails implements IExcursionDetails {
  private String fDetailsUrl;
  private String fStartLocation;
  private String fOrganization;
  private Date fDate;
  private String fStartTime;
  private String fDistance;
  
  public ExcursionDetails(String detailsUrl) {
    fDetailsUrl = detailsUrl;
  }

  @Override
  public String getStartLocation() {
    return fStartLocation;
  }

  public void setStartLocation(String startLocation) {
    fStartLocation = startLocation;
  }

  public void setOrganization(String organization) {
    fOrganization = organization;
  }

  public void setDate(Date date) {
    fDate = date;
  }

  public void setStartTime(String startTime) {
    fStartTime = startTime;
  }

  public void setDistance(String distance) {
    fDistance = distance;
  }

  @Override
  public String getOrganization() {
    return fOrganization;
  }

  @Override
  public Date getDate() {
    return fDate;
  }

  @Override
  public String getStartTime() {
    return fStartTime;
  }

  @Override
  public String getDistance() {
    return fDistance;
  }

  @Override
  public String toString() {
    return "ExcursionDetails [fDetailsUrl=" + fDetailsUrl + ", fStartLocation="
        + fStartLocation + ", fOrganization=" + fOrganization + ", fDate="
        + fDate + ", fStartTime=" + fStartTime + ", fDistance=" + fDistance
        + "]";
  }
}
