package com.jonathan.sandbox;

import java.io.Serializable;

/**
 * Created by Jonathan on 2/5/2016.
 */
public class TestCase implements Serializable {

    private int number;
    private String name;
    private boolean state;
    private double decimalNumber;
    private int[] intArray;
    private String nameTwo;

    public TestCase(){
        this.number = 1;
        this.name = "No Name";
        this.state = false;
        this.decimalNumber = 1.0;
        this.intArray = new int[]{0,1,2,3,4,5};
        this.nameTwo = null;
    }

    public TestCase(int number, String name, boolean state, double decimalNumber, int[] intArray, String nameTwo) {
        this.number = number;
        this.name = name;
        this.state = state;
        this.decimalNumber = decimalNumber;
        this.intArray = intArray;
        this.nameTwo = nameTwo;
    }

    public int doubleTheNumber(){
        return this.number *2;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public double getDecimalNumber() {
        return decimalNumber;
    }

    public void setDecimalNumber(double decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    public String getNameTwo() {
        return nameTwo;
    }

    public void setNameTwo(String nameTwo) {
        this.nameTwo = nameTwo;
    }

    public void exceptionThrower() throws Exception{

        throw new Exception("Exception was thrown");

    }
}
