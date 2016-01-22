package com.jonathan.sandbox;

/**
 * Created by Jonathan on 1/16/2016.
 */
public class ControllerSandbox {
    //the controller is what interacts with the the model and the view
    //the model and the view never interact directly with eachother
    ViewSandbox view = new ViewSandbox();
    ModelSandbox model = new ModelSandbox();

    public void runTimeControl(){

        String userInput;

        //work with the view to prompt the user
        view.intro();
        userInput = view.getNextLineFromUser(); //rename getInput to something better
        System.out.println("Controller: "+userInput);

        //handle the user input and send it to the model for processing
        //the model will store a history of user input
        model.addToHistory(userInput);

        //this block will determine if it is a int or a double or something else
        //logic like this goes in the controller
        int intNumber;
        double doubNumber;
        try{
            intNumber = Integer.parseInt(userInput);
            intNumber = multiplyNumber(intNumber);//send the number to the correct method in the model
            view.displayInt(intNumber);//send the number to the correct method in the view
        }catch (NumberFormatException e){
            try{
                doubNumber = Double.parseDouble(userInput);
                doubNumber = multiplyNumber(doubNumber);//send the number to the correct method in the model
                view.displayDouble(doubNumber);//send it to the view
            }catch (NumberFormatException ex){
                view.displayError(userInput);//display the error message
            }
        }

        int sizeOfHistory = model.retrieveInputHistory().size();
        if(sizeOfHistory >3){
            view.displayUserInputHistory(model.retrieveInputHistory());
        }

    }

    public double multiplyNumber(double number){
        return number*5;
    }

    public int multiplyNumber(int number){
        return number*2;
    }


}
