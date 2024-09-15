package org.example;


public class Animal {
    // Properties typical to animals
    public String name;
    protected int age;
    protected double weight;

    public Animal(int age, double weight) {}

    // Constructor
    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {}

    // Getter for age
    public int getAge() {
        return age;
    }

    // Getter for weight
    public double getWeight() {
        return weight;
    }

    // Method to get the animal's sound
    public String makeSound() {
        return "Some generic animal sound";
    }

    // Method to display animal's info
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight + " kg");
    }
}
