package com.genetrysolar.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CLIInputTest {

    // Pretend this list is what the user enters.
    List<String> responses = new ArrayList<>(Arrays.asList(
            "megan", // User enters megan
            "nancy", // User enters nancy
            "", // User just hits enter
            "something after" // We shouldn't get here because user just hit enter.
    ));

    @Test
    public void readInput() {
        String input = null;
        while (!(input = readLine()).isEmpty()) {
            System.out.println("User entered " + input);
        }
        System.out.println("User stopped entering stuff.");
    }

    // Pretend I read from CLI
    private String readLine() {
        String input = responses.remove(0).trim();
        System.out.println("Please enter a server name or press enter to stop: " + input);
        return input;
    }

}
