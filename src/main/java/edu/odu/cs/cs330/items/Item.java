package edu.odu.cs.cs330.items;

import java.util.Scanner;

public abstract class Item implements Cloneable {

    protected String name;

    /**
     * Default constructor.
     */
    protected Item() {
        this("Air");
    }

    /**
     * Constructor with name.
     */
    protected Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean isStackable();

    public abstract void read(Scanner snr);

    @Override
    public abstract Item clone();

    @Override
    public abstract boolean equals(Object rhs);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}
