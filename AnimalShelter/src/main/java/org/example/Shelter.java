// Class: Shelter.java, uses an adoption system based on a 'first in, first out' basis
// By: Cameron Beanland
// Date: Feb 20th, 2025

package org.example;

import java.util.LinkedList;

// Class to manage the shelter system, used in the ShelterTest class (no options to select what animal you get)
public class Shelter {
    // Linked lists to help store the dogs and cats separately
    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0; // this acts as a timestamp, helps track arrival order of animals

    /* ===================================== */
    // Adds new animal to the shelter
    public void enqueue(Animal animal) {
        animal.setOrder(order); // Bases the animals' set order by its arrival
        order++; // Increment order for next animal

        // Adds animal to the proper list based on type, (dog to dog list, cat to cat)
        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
    }

    /* ===================================== */
    //
    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCat(); // Will adopt a cat if no dogs are available
        } else if (cats.isEmpty()) {
            return dequeueDog(); // Adopts a dog if no cats are available
        }

        // Compares both the oldest dog and cat, then adopts the eldest of the two
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dogs.poll();
        } else {
            return cats.poll();
        }
    }

    /* ===================================== */
    // Adopts either oldest dog or cat in the shelter
    public Dog dequeueDog() {
        if (!dogs.isEmpty()) {
            return dogs.poll();
        }
        return null;
    }

    public Cat dequeueCat() {
        if (!cats.isEmpty()) {
            return cats.poll();
        }
        return null;
    }
}

