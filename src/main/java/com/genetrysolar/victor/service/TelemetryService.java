package com.genetrysolar.victor.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TelemetryService {
    private int uses;

    public int inc() {
        return uses++;
    }
}
