package com.jonathan.sandbox;

import java.io.Serializable;

/**
 * Created by Jonathan on 2/9/2016.
 */
public class Polygon implements Serializable{

    private int numberOfSides;
    private double[] lengthsOfSides;

    public Polygon() {
        this.numberOfSides = 3;
        this.lengthsOfSides = new double[]{1,1,1};
    }

    public Polygon(int numberOfSides, double[] lengthsOfSides) {
        this.numberOfSides = numberOfSides;
        this.lengthsOfSides = lengthsOfSides;
    }

    public double[] getLengthsOfSides() {
        return lengthsOfSides;
    }

    public void setLengthsOfSides(double[] lengthsOfSides) {
        this.lengthsOfSides = lengthsOfSides;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

}
