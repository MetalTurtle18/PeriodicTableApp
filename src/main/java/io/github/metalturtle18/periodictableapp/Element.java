package io.github.metalturtle18.periodictableapp;

public enum Element {

    HYDROGEN("Hydrogen", "H", 1),
    HELIUM("Helium", "He", 2),
    LITHIUM("Lithium", "Li", 3),
    BERYLLIUM("Beryllium", "Be", 4),
    BORON("Boron", "B", 5),
    CARBON("Carbon", "C", 6),
    NITROGEN("Nitrogen", "N", 7),
    OXYGEN("Oxygen", "O", 8),
    FLUORINE("Fluorine", "F", 9),
    NEON("Neon", "Ne", 10);

    public final String name;
    public final String symbol;
    public final int atomicNumber;

    Element(String name, String symbol, int atomicNumber) {
        this.name = name;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
    }
}
