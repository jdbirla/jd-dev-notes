package com.jd.interviewprep.corejava;


class Animal1 {
    public void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog1 extends Animal1 {
    public void speak() {
        System.out.println("Dog barks");
    }
}


public class NormalOverride {
	 public static void main(String[] args) {
	        Animal1 animal = new Animal1();
	        animal.speak(); // Output: Animal speaks

	        Dog1 dog = new Dog1();
	        dog.speak(); // Output: Dog barks

	        Animal1 animalDog = new Dog1();
	        animalDog.speak(); // Output: Dog barks
	    }

}
