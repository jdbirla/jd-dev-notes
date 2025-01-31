package com.jd.interviewprep.corejava;

class Animal {
	public static void speak() {
		System.out.println("Animal speaks");
	}
}

class Dog extends Animal {
	public static void speak() {
		System.out.println("Dog barks");
	}
}

public class StaticOverride {
	public static void main(String[] args) {

		Animal.speak();// Animal speaks

		Dog.speak();// Dog barks

		Animal animal = new Animal();
		animal.speak(); // Output: Animal speaks

		Dog dog = new Dog();
		dog.speak(); // Output: Dog barks

		Animal animalDog = new Dog();
		animalDog.speak(); // Output: Animal speaks
	}
}