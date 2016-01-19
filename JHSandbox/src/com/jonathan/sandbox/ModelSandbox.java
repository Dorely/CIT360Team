package com.jonathan.sandbox;

/**
 * Created by Jonathan on 1/16/2016.
 */
public class ModelSandbox {
    //the model is what interacts with data
    //the model and the view never interact directly with eachother
    public double multiplyNumber(double number){
        return number*5;
    }

    public int multiplyNumber(int number){
        return number*2;
    }

}
