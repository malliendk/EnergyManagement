package org.example;

public class Dog extends Animal {

   public String breed;
    public String name;

    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Dog(int age, double weight){
        super(age, weight);
    }

    public Dog(String name, int age, double weight, String breed) {
        super(age, weight);
        this.name = name;
        this.breed = breed;
    }

    // Overriding the makeSound method
    @Override
    public String makeSound() {
        return "Bark";
    }

    // Overriding the displayInfo method to include breed
    @Override
    public void displayInfo() {
        // This will demonstrate method hiding by calling the superclass's method
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }
}
