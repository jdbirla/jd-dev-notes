package com.jd.interviewprep.designpattern.observer;

public class Seller implements Observer {
	  private String location;
	  
	  @Override
	  public void update(String location) {
	    this.location = location;
	    showLocation();
	  }

	  public void showLocation() {
	    System.out.println("Notification at Seller - Current Location: " + location);
	  }
	}