package com.jonathan.sandbox;

import java.util.HashMap;

/**
 * Created by Jonathan on 2/16/2016.
 */
public class AddHandler implements Handler {
    @Override
    public void handleIt(HashMap<String, Object> data) {
        System.out.println("AddHandler Called");

        int first = Integer.parseInt(data.get("first").toString());
        int second = Integer.parseInt(data.get("second").toString());

        System.out.println(first+"+"+second+" = "+(first+second));
    }
}
