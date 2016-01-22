package com.jonathan.sandbox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 1/16/2016.
 */
public class ModelSandbox {
    //the model is what interacts with data
    //the model and the view never interact directly with eachother

    //moved multiplication to controller, making model a data storage center
    //model should have to do with data storage and retrieval
    private List userInputHistory = new ArrayList();

    public void addToHistory(String input){
        userInputHistory.add(input);
    }

    public List retrieveInputHistory(){
        return userInputHistory;
    }

}
