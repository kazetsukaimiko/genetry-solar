package com.genetrysolar.inverter;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface InverterModel {
    String getVersionString();

    LocalDate getReleaseDate();

    boolean isSplitPhase();

    // TODO: kaze.math Power
    BigDecimal getContinuousRating();

    BigDecimal getSurgeRating();
}
