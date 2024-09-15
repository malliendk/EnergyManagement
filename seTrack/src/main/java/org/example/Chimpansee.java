package org.example;

public class Chimpansee extends Primate {
    public int age = 30;

    public void printAge() {
        System.out.println("driving electric car");
    }

    public static void main(String[] args) {
        Primate primate = new Chimpansee();
        primate.printAge();
        System.out.println(primate.age);

        Chimpansee chimp2 = new Chimpansee();
        Primate primate2 = chimp2;
        System.out.println(primate2.age);

        Chimpansee chimpansee = (Chimpansee) primate;

        int[] array = {1, 2,3,4,5};
        for (int t: array){
            System.out.println(t);
        }

    }
}