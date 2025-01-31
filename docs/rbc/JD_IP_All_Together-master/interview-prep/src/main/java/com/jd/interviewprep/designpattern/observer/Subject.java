package com.jd.interviewprep.designpattern.observer;

public interface Subject {
	  void register(Observer obj);
	  void unregister(Observer obj);
	  void notifyObservers();

}
