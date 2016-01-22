package com.jonathan.sandbox;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Jonathan on 1/16/2016.
 */
public class ViewSandbox {
    //the view is what interacts with the user / client
    //the model and the view never interact directly with each other
    //the exception is "view helpers" which can interact with the model to help create the view based on stored data

    //the view in this sandbox will be a command line user interface
    public void intro(){
        //happy path present a view and take input from the user
        System.out.println("Welcome to the MVC Sandbox");
        System.out.println("If you input a double it will multiply by 5");
        System.out.println("If you input an int it will multiply by 2");

    }

    public String getNextLineFromUser(){
        Scanner input = new Scanner(System.in);
        String inputString;
        inputString = input.nextLine();

        return inputString;
    }

    public void displayInt(int number){
        System.out.println("You input an Integer and it was multiplied by 2: "+number);
    }

    public void displayDouble(double number){
        System.out.println("You input a Double and it was multiplied by 5: "+number);
    }

    public void displayError(String word) {
        System.out.println("You input neither an Integer or a Double: "+word);
    }

    public void displayUserInputHistory(List userInputHistoryList){
        System.out.println("program end, your input history is:");
        for(Object userInputHistoryItem : userInputHistoryList) {
            String item = (String) userInputHistoryItem;
            System.out.println(item);
        }
    }
}
