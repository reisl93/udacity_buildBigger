package com.example;

public class GetJoke {

    private final String[] jokes = new String[]{
            "Actually this app is a joke",
            "A cool joke i told you",
            "What has 4 legs and no arms? A Table..."
    };

    public String getJoke(){
        return jokes[(int) ((Math.random() * jokes.length) % jokes.length)];
    }

}
