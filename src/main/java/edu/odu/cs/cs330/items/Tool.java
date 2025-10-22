package edu.odu.cs.cs330.items;

import java.util.Scanner;
import java.util.Objects;

public class Tool extends Item implements Cloneable {

    private int durability;
    private int speed;
    private String material;
    private String modifier;
    private int modifierLevel;

    // Default constructor
    public Tool() {
        super("Generic Tool");
        this.durability = 1;
        this.speed = 1;
        this.material = "Wood";
        this.modifier = "None";
        this.modifierLevel = 0;
    }

    // Copy constructor
    public Tool(Tool other) {
        super(other.getName());
        this.durability = other.durability;
        this.speed = other.speed;
        this.material = other.material;
        this.modifier = other.modifier;
        this.modifierLevel = other.modifierLevel;
    }

    public int getDurability() { return durability; }
    public void setDurability(int durability) { this.durability = durability; }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getModifier() { return modifier; }
    public void setModifier(String modifier) { this.modifier = modifier; }

    public int getModifierLevel() { return modifierLevel; }
    public void setModifierLevel(int modifierLevel) { this.modifierLevel = modifierLevel; }

    @Override
    public boolean isStackable() {
        return false;
    }

    @Override
    public void read(Scanner snr) {
        if (snr.hasNext()) setName(snr.next());
        if (snr.hasNext()) setMaterial(snr.next());
        if (snr.hasNextInt()) setDurability(snr.nextInt());
        if (snr.hasNextInt()) setSpeed(snr.nextInt());
        if (snr.hasNext()) setModifier(snr.next());
        if (snr.hasNextInt()) setModifierLevel(snr.nextInt());
    }

    @Override
    public Tool clone() {
        return new Tool(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Tool)) return false;
        
        Tool other = (Tool) obj;
        return Objects.equals(name, other.name) &&
               Objects.equals(material, other.material) &&
               Objects.equals(modifier, other.modifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, material, modifier);
    }

    @Override
    public String toString() {
        return String.join(
            System.lineSeparator(),
            "  Nme: " + name,
            "  Dur: " + durability,
            "  Spd: " + speed,
            "  Mtl: " + material,
            "  Mdr: " + modifier + " (Lvl " + modifierLevel + ")",
            ""
        );
    }
}