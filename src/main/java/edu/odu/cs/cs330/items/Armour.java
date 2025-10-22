package edu.odu.cs.cs330.items;

import java.util.Objects;

public class Armour extends Item implements Cloneable {

    private int durability;
    private int defense;
    private String material;
    private String modifier;
    private int modifierLevel;
    private String element;

    // Default constructor
    public Armour() {
        super();
        this.durability = 0;
        this.defense = 0;
        this.material = "";
        this.modifier = "";
        this.modifierLevel = 0;
        this.element = "";
    }

    // Copy constructor
    public Armour(Armour other) {
        super(other.getName());
        this.durability = other.durability;
        this.defense = other.defense;
        this.material = other.material;
        this.modifier = other.modifier;
        this.modifierLevel = other.modifierLevel;
        this.element = other.element;
    }

    // Getters and Setters
    public int getDurability() { return durability; }
    public void setDurability(int durability) { this.durability = durability; }

    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getModifier() { return modifier; }
    public void setModifier(String modifier) { this.modifier = modifier; }

    public int getModifierLevel() { return modifierLevel; }
    public void setModifierLevel(int level) { this.modifierLevel = level; }

    public String getElement() { return element; }
    public void setElement(String element) { this.element = element; }

    @Override
    public boolean isStackable() {
        return false;
    }

    @Override
    public Armour clone() {
        return new Armour(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Armour)) return false;
        
        Armour other = (Armour) obj;
        return Objects.equals(getName(), other.getName()) &&
               Objects.equals(material, other.material) &&
               Objects.equals(modifier, other.modifier) &&
               Objects.equals(element, other.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), material, modifier, element);
    }

    @Override
    public void read(java.util.Scanner ins) {
        setName(ins.next());
        material = ins.next();
        durability = ins.nextInt();
        defense = ins.nextInt();
        modifier = ins.next();
        modifierLevel = ins.nextInt();
        element = ins.next();
    }

    @Override
    public String toString() {
        return String.join(
            System.lineSeparator(),
            "  Nme: " + getName(),
            "  Dur: " + durability,
            "  Def: " + defense,
            "  Mtl: " + material,
            "  Mdr: " + modifier + " (Lvl " + modifierLevel + ")",
            "  Emt: " + element,
            ""
        );
    }
}