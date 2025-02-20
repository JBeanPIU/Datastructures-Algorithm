// Class: Animal.java, used to set up name of animal, order and age
// By: Cameron Beanland
// Date: Feb 20th, 2025

package org.example;

// An abstract class to be extended by Dog and Cat, meaning they inherit the properties/methods shown below
public abstract class Animal {
    // Nabs the name of animal / Order of which animal arrived at the shelter
    private String name;
    private int order;

    // Constructor (only one for this entire class)
    public Animal(String name) {
        this.name = name;
    }

    /* ================== */
    // Accessor/Mutator methods
    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    /* ================== */
    // Method comparing age of one animal to another, it'll return true if animal IS in fact, older.
    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder(); // refers back to getOrder five lines above
    }

    // Method for getting name of animal, mostly to be used in the ShelterTest class
    public String getName() {
        return name;
    }
}
