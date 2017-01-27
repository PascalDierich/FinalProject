package com.example;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MyClass {

    private ArrayList<String> jokesCollection = new ArrayList<>();

    public MyClass() {
        addJokes();
    }

    public String getJoke() {
        String joke;
        int randomPosition = ThreadLocalRandom.current().nextInt(0, jokesCollection.size());

        try {
            joke = jokesCollection.get(randomPosition);
        } catch (NullPointerException e) {
            return getJoke();
        }
        return joke;
    }

    private void addJokes() {
        // Chuck Norris <3
        jokesCollection.add("Chuck Norris makes fire by rubbing 2 ice cubes together");
        jokesCollection.add("Chuck Norris can drift on a horse");
        jokesCollection.add("Chuck Norris once heard that nothing can kill him, so he tracked down nothing and killed it");
        jokesCollection.add("Obama said, \"Yes we can.\" Chuck Norris says, \"I already did\"");
        // I think thats enough :)
    }
}
