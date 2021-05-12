package io.github.metalturtle18.periodictableapp;

public enum Element {

    HYDROGEN("Hydrogen", "H", 1, 1, 1, 1.008, 2.20, MatterState.GAS, MetalType.NONMETAL),
    HELIUM("Helium", "He", 2, 18, 1, 4.003, -1, MatterState.GAS, MetalType.NONMETAL),
    LITHIUM("Lithium", "Li", 3, 1, 2, 6.94, 0.98),
    BERYLLIUM("Beryllium", "Be", 4, 2, 2, 9.012, 1.57),
    BORON("Boron", "B", 5, 13, 2, 10.81, 2.04, MetalType.METALLOID),
    CARBON("Carbon", "C", 6, 14, 2, 12.01, 2.55, MetalType.NONMETAL),
    NITROGEN("Nitrogen", "N", 7, 15, 2, 14.01, 3.04, MatterState.GAS, MetalType.NONMETAL),
    OXYGEN("Oxygen", "O", 8, 16, 2, 16.00, 3.44, MatterState.GAS, MetalType.NONMETAL),
    FLUORINE("Fluorine", "F", 9, 17, 2, 19.00, 3.98, MatterState.GAS, MetalType.NONMETAL),
    NEON("Neon", "Ne", 10, 18, 2, 20.18, -1, MatterState.GAS, MetalType.NONMETAL),
    SODIUM("Sodium", "Na", 11, 1, 3, 22.99, 0.93),
    MAGNESIUM("Magnesium", "Mg", 12, 2, 3, 24.30, 1.31),
    ALUMINUM("Aluminum", "Al", 13, 13, 3, 26.98, 1.61),
    SILICON("Silicon", "Si", 14, 14, 3, 28.09, 1.90, MetalType.METALLOID),
    PHOSPHORUS("Phosphorus", "P", 15, 15, 3, 30.97, 2.19, MetalType.NONMETAL),
    SULFUR("Sulfur", "S", 16, 16, 3, 32.06, 2.58, MetalType.NONMETAL),
    CHLORINE("Chlorine", "Cl", 17, 17, 3, 35.45, 3.16, MatterState.GAS, MetalType.NONMETAL),
    ARGON("Argon", "Ar", 18, 18, 3, 39.95, -1, MatterState.GAS, MetalType.NONMETAL),
    POTASSIUM("Potassium", "K", 19, 1, 4, 39.10, 0.82),
    CALCIUM("Calcium", "Ca", 20, 2, 4, 40.08, 1.00),
    SCANDIUM("Scandium", "Sc", 21, 3, 4, 44.96, 1.36),
    TITANIUM("Titanium", "Ti", 22, 4, 4, 47.87, 1.54),
    VANADIUM("Vanadium", "V", 23, 5, 4, 50.94, 1.63),
    CHROMIUM("Chromium", "Cr", 24, 6, 4, 52.00, 1.66),
    MANGANESE("Manganese", "Mn", 25, 7, 4, 54.94, 1.55),
    IRON("Iron", "Fe", 26, 8, 4, 55.85, 1.83),
    COBALT("Cobalt", "Co", 27, 9, 4, 58.93, 1.88),
    NICKEL("Nickel", "Ni", 28, 10, 4, 58.69, 1.91),
    COPPER("Copper", "Cu", 29, 11, 4, 63.55, 1.90),
    ZINC("Zinc", "Zn", 30, 12, 4, 65.38, 1.65),
    GALLIUM("Gallium", "Ga", 31, 13, 4, 69.72, 1.81),
    GERMANIUM("Germanium", "Ge", 32, 14, 4, 72.63, 2.01, MetalType.METALLOID),
    ARSENIC("Arsenic", "As", 33, 15, 4, 74.92, 2.18, MetalType.METALLOID),
    SELENIUM("Selenium", "Se", 34, 16, 4, 78.97, 2.55, MetalType.NONMETAL),
    BROMINE("Bromine", "Br", 35, 17, 4, 79.90, 2.96, MatterState.LIQUID, MetalType.NONMETAL),
    KRYPTON("Krypton", "Kr", 36, 18, 4, 83.80, 3.00, MatterState.GAS, MetalType.NONMETAL),
    RUBIDIUM("Rubidium", "Rb", 37, 1, 5, 85.47, 0.82),
    STRONTIUM("Strontium", "Sr", 38, 2, 5, 87.62, 0.95),
    YTTRIUM("Yttrium", "Y", 39, 3, 5, 88.91, 1.22),
    ZIRCONIUM("Zirconium", "Zr", 40, 4, 5, 91.22, 1.33),
    NIOBIUM("Niobium", "Nb", 41, 5, 5, 92.91, 1.6),
    MOLYBDENUM("Molybdenum", "Mo", 42, 6, 5, 95.95, 2.16),
    TECHNETIUM("Technetium", "Tc", 43, 7, 5, 98, 1.9),
    RUTHENIUM("Ruthenium", "Ru", 44, 8, 5, 101.1, 2.2),
    RHODIUM("Rhodium", "Rh", 45, 9, 5, 102.9, 2.28),
    PALLADIUM("Palladium", "Pd", 46, 10, 5, 106.4, 2.20),
    SILVER("Silver", "Ag", 47, 11, 5, 107.9, 1.93),
    CADMIUM("Cadmium", "Cd", 48, 12, 5, 112.4, 1.69),
    INDIUM("Indium", "In", 49, 13, 5, 114.8, 1.78),
    TIN("Tin", "Sn", 50, 14, 5, 118.7, 1.96),
    ANTIMONY("Antimony", "Sb", 51, 15, 5, 121.8, 2.05, MetalType.METALLOID),
    TELLURIUM("Tellurium", "Te", 52, 16, 5, 127.6, 2.1, MetalType.METALLOID),
    IODINE("Iodine", "I", 53, 17, 5, 126.9, 2.66, MetalType.NONMETAL),
    XENON("Xenon", "Xe", 54, 18, 5, 131.3, 2.60, MatterState.GAS, MetalType.NONMETAL),
    CAESIUM("Caesium", "Cs", 55, 1, 6, 132.9, 0.79),
    BARIUM("Barium", "Ba", 56, 2, 6, 137.3, 0.89),
    LANTHANUM("Lanthanum", "La", 57, -1, 6, 138.9, 1.1),
    CERIUM("Cerium", "Ce", 58, -1, 6, 140.1, 1.12),
    PRASEODYMIUM("Praseodymium", "Pr", 59, -1, 6, 140.9, 1.13),
    NEODYMIUM("Neodymium", "Nd", 60, -1, 6, 144.2, 1.14),
    PROMETHIUM("Promethium", "Pm", 61, -1, 6, 145, 1.13),
    SAMARIUM("Samarium", "Sm", 62, -1, 6, 150.4, 1.17),
    EUROPIUM("Europium", "Eu", 63, -1, 6, 152.0, 1.2),
    GADOLINIUM("Gadolinium", "Gd", 64, -1, 6, 157.2, 1.2),
    TERBIUM("Terbium", "Tb", 65, -1, 6, 158.9, 1.2),
    DYSPROSIUM("Dysprosium", "Dy", 66, -1, 6, 163.0, 1.22),
    HOLMIUM("Holmium", "Ho", 67, -1, 6, 164.9, 1.23),
    ERBIUM("Erbium", "Er", 68, -1, 6, 167.3, 1.24),
    THULIUM("Thulium", "Tm", 69, -1, 6, 168.9, 1.25),
    YTTERBIUM("Ytterbium", "Yb", 70, -1, 6, 173.1, 1.1),
    LUTETIUM("Lutetium", "Lu", 71, 3, 6, 175.0, 1.27),
    HAFNIUM("Hafnium", "Hf", 72, 4, 6, 178.5, 1.3),
    TANTALUM("Tantalum", "Ta", 73, 5, 6, 180.9, 1.5),
    TUNGSTEN("Tungsten", "W", 74, 6, 6, 183.8, 2.36),
    RHENIUM("Rhenium", "Re", 75, 7, 6, 186.2, 1.9),
    OSMIUM("Osmium", "Os", 76, 8, 6, 190.2, 2.2),
    IRIDIUM("Iridium", "Ir", 77, 9, 6, 192.2, 2.20),
    PLATINUM("Platinum", "Pt", 78, 10, 6, 195.1, 2.28),
    GOLD("Gold", "Au", 79, 11, 6, 197.0, 2.54),
    MERCURY("Mercury", "Hg", 80, 12, 6, 200.6, 2.00, MatterState.LIQUID),
    THALLIUM("Thallium", "Tl", 81, 13, 6, 204.4, 1.62),
    LEAD("Lead", "Pb", 82, 14, 6, 207.2, 1.87),
    BISMUTH("Bismuth", "Bi", 83, 15, 6, 209.0, 2.02),
    POLONIUM("Polonium", "Po", 84, 16, 6, 209, 2.0),
    ASTATINE("Astatine", "At", 85, 17, 6, 210, 2.2, MetalType.METALLOID),
    RADON("Radon", "Rn", 86, 18, 6, 222, 2.2, MatterState.GAS, MetalType.NONMETAL),
    FRANCIUM("Francium", "Fr", 87, 1, 7, 223, 0.79),
    RADIUM("Radium", "Ra", 88, 2, 7, 226, 0.9),
    ACTINIUM("Actinium", "Ac", 89, -1, 7, 227, 1.1),
    THORIUM("Thorium", "Th", 90, -1, 7, 232.0, 1.3),
    PROTACTINIUM("Protactinium", "Pa", 91, -1, 7, 231.0, 1.5),
    URANIUM("Uranium", "U", 92, -1, 7, 238.0, 1.38),
    NEPTUNIUM("Neptunium", "Np", 93, -1, 7, 237, 1.36),
    PLUTONIUM("Plutonium", "Pu", 94, -1, 7, 244, 1.28),
    AMERICIUM("Americium", "Am", 95, -1, 7, 243, 1.13),
    CURIUM("Curium", "Cm", 96, -1, 7, 247, 1.28),
    BERKELIUM("Berkelium", "Bk", 97, -1, 7, 247, 1.3),
    CALIFORNIUM("Californium", "Cf", 98, -1, 7, 251, 1.3),
    EINSTEINIUM("Einsteinium", "Es", 99, -1, 7, 252, 1.3),
    FERMIUM("Fermium", "Fm", 100, -1, 7, 257, 1.3),
    MENDELEVIUM("Mendelevium", "Md", 101, -1, 7, 258, 1.3),
    NOBELIUM("Nobelium", "No", 102, -1, 7, 259, 1.3),
    LAWRENCIUM("Lawrencium", "Lr", 103, 3, 7, 266, 1.3),
    RUTHERFORDIUM("Rutherfordium", "Rf", 104, 4, 7, 267, -1),
    DUBNIUM("Dubnium", "Db", 105, 5, 7, 268, -1),
    SEABORGIUM("Seaborgium", "Sg", 106, 6, 7, 269, -1),
    BOHRIUM("Bohrium", "Bh", 107, 7, 7, 270, -1),
    HASSIUM("Hassium", "Hs", 108, 8, 7, 270, -1),
    MEITNERIUM("Meitnerium", "Mt", 109, 9, 7, 278, -1, MetalType.OTHER),
    DARMSTADTIUM("Darmstadtium", "Ds", 110, 10, 7, 281, -1, MetalType.OTHER),
    ROENTGENIUM("Roentgenium", "Rg", 111, 11, 7, 282, -1, MetalType.OTHER),
    COPERNICIUM("Copernicium", "Cn", 112, 12, 7, 285, -1),
    NIHONIUM("Nihonium", "Nh", 113, 13, 7, 286, -1, MetalType.OTHER),
    FLEROVIUM("Flerovium", "Fl", 114, 14, 7, 289, -1, MetalType.OTHER),
    MOSCOVIUM("Moscovium", "Mc", 115, 15, 7, 290 ,-1, MetalType.OTHER),
    LIVERMORIUM("Livermorium", "Lv", 116, 16, 7, 293, -1, MetalType.OTHER),
    TENNESSINE("Tennessine", "Ts", 117, 17, 7, 294, -1, MetalType.OTHER),
    OGANESSON("Oganesson", "Og", 118, 18, 7, 294, -1, MetalType.OTHER);

    /**
     * States of matter
     */
    enum MatterState {
        SOLID,
        LIQUID,
        GAS
    }

    /**
     * Metal types of elements
     */
    enum MetalType {
        METAL,
        NONMETAL,
        METALLOID,
        OTHER
    }

    /**
     * These are the properties of each element. If any property is -1 that means it does not exist
     */
    public final String name;
    public final String symbol;
    public final int atomicNumber;
    public final int group;
    public final int period;
    public final double atomicWeight;
    public final double electronegativity;
    public final MatterState stateAtRoomTemperature;
    public final MetalType metalType;

    Element(String name, String symbol, int atomicNumber, int group, int period, double atomicWeight, double electronegativity, MatterState stateAtRoomTemperature, MetalType metalType) {
        this.name = name;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.group = group;
        this.period = period;
        this.atomicWeight = atomicWeight;
        this.electronegativity = electronegativity;
        this.stateAtRoomTemperature = stateAtRoomTemperature;
        this.metalType = metalType;
    }

    /**
     * Different constructors with defaults because a lot of the elements are solid metals
     */

    Element(String name, String symbol, int atomicNumber, int group, int period, double atomicWeight, double electronegativity) {
        this(name, symbol, atomicNumber, group, period, atomicWeight, electronegativity, MatterState.SOLID, MetalType.METAL);
    }

    Element(String name, String symbol, int atomicNumber, int group, int period, double atomicWeight, double electronegativity, MatterState stateAtRoomTemperature) {
        this(name, symbol, atomicNumber, group, period, atomicWeight, electronegativity, stateAtRoomTemperature, MetalType.METAL);
    }

    Element(String name, String symbol, int atomicNumber, int group, int period, double atomicWeight, double electronegativity, MetalType metalType) {
        this(name, symbol, atomicNumber, group, period, atomicWeight, electronegativity, MatterState.SOLID, metalType);
    }
}
