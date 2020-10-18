package com.genetrysolar.enumerations;

public enum TemperatureRadix {
    F("F", "Fahrenheit"),
    C("C", "Celsuius"),
    K("K", "Kelvin"),
    ;

    private final String symbol;
    private final String description;

    TemperatureRadix(String symbol, String description) {
        this.symbol = symbol;
        this.description = description;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDescription() {
        return description;
    }
}
