package edu.odu.cs.cs330.items;

import java.util.Scanner;

public class Consumable extends Item implements Cloneable {

    private String effect;
    private int numberOfUses;

    // Default constructor
    public Consumable() {
        super("Generic Consumable");
        this.effect = "None";
        this.numberOfUses = 1;
    }

    // Copy constructor
    public Consumable(Consumable other) {
        super(other.getName());  // Use getName() instead of direct field access
        this.effect = other.effect;
        this.numberOfUses = other.numberOfUses;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getNumberOfUses() {
        return numberOfUses;
    }

    public void setNumberOfUses(int numberOfUses) {
        this.numberOfUses = numberOfUses;
    }

    @Override
    public boolean isStackable() {
        return true;
    }

    @Override
    public void read(Scanner snr) {
        if (snr.hasNext()) setName(snr.next());
        if (snr.hasNext()) setEffect(snr.next());
        if (snr.hasNextInt()) setNumberOfUses(snr.nextInt());
    }

    @Override
    public Consumable clone() {
        return new Consumable(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Consumable)) return false;
        
        Consumable other = (Consumable) obj;
        return this.name.equals(other.name)
            && this.effect.equals(other.effect);
        // numberOfUses does NOT affect equality per tests
    }

    @Override
    public int hashCode() {
        return name.hashCode() + effect.hashCode();
    }

    @Override
    public String toString() {
        return String.join(
            System.lineSeparator(),
            "  Nme: " + name,
            "  Eft: " + effect,
            "  Use: " + numberOfUses,
            ""
        );
    }
}