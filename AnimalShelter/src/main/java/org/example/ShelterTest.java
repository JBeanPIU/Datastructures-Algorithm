// Class: ShelterTest.java, putting the shelter system to work
// By: Cameron Beanland
// Date: Feb 20th, 2025

package org.example;

// Running three separate tests to make sure the lists are working and animals get dequeued properly
public class ShelterTest {
    public static void main(String[] args) {
        Shelter shelter = new Shelter();

        // Let's add a few animals, two cats and dogs
        shelter.enqueue(new Dog("Invincible"));
        shelter.enqueue(new Cat("Omniman"));
        shelter.enqueue(new Dog("Atom Eve"));
        shelter.enqueue(new Cat("Debbie"));

        // Dequeue any animal (should select Invincible since he's first, making him the oldest
        Animal oldestAnimal = shelter.dequeueAny();
        System.out.println("Adopted: " + oldestAnimal.getName());

        // Dequeue the dog, now should retrieve Atom Eve
        Dog oldestDog = shelter.dequeueDog();
        System.out.println("Adopted dog: " + oldestDog.getName());

        // Dequeue a cat, Omniman should pull through
        Cat oldestCat = shelter.dequeueCat();
        System.out.println("Adopted cat: " + oldestCat.getName());


        /* ============================== */
        // SECOND BATCH OF TESTS!

        // One new dog and cat
        shelter.enqueue(new Dog("Lunala"));
        shelter.enqueue(new Cat("Solgaleo"));

        // Dequeue either of them, should select Debbie
        oldestAnimal = shelter.dequeueAny();
        System.out.println("Adopted: " + oldestAnimal.getName());


        /* ============================== */
        // LAST BATCH OF TESTS!

        // More!!!
        shelter.enqueue(new Dog("Finn"));
        shelter.enqueue(new Cat("Jake"));
        shelter.enqueue(new Dog("PB"));
        shelter.enqueue(new Cat("Marceline"));

        // Dequeue dog, goodbye Lunala
        oldestDog = shelter.dequeueDog();
        System.out.println("Adopted dog: " + oldestDog.getName());

        // Dequeue cat, returns Solgaleo
        oldestCat = shelter.dequeueCat();
        System.out.println("Adopted cat: " + oldestCat.getName());

        // Dequeue the oldest, which of the last four remaning would be Finn
        oldestAnimal = shelter.dequeueAny();
        System.out.println("Adopted: " + oldestAnimal.getName());

        // Dequeue remaining animals in order, so Jake, PB, and Marceline
        while ((oldestAnimal = shelter.dequeueAny()) != null) {
            System.out.println("Adopted: " + oldestAnimal.getName());
        }
    }
}


