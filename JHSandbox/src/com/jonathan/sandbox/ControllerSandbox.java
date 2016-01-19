package com.jonathan.sandbox;

/**
 * Created by Jonathan on 1/16/2016.
 */
public class ControllerSandbox {
    //the controller is what interacts with the the model and the view
    //the model and the view never interact directly with eachother
    public void runTimeControl(){

        ViewSandbox view = new ViewSandbox();
        ModelSandbox model = new ModelSandbox();
        String userInput;

        //work with the view to prompt the user
        view.intro();
        userInput = view.getInput();
        System.out.println("Controller: "+userInput);

        //handle the user input and send it to the model for processing

        //this block will determine if it is a int or a double or something else
        //logic like this goes in the controller
        //it then sends the data to the model for processing
        int intNumber;
        double doubNumber;
        try{
            intNumber = Integer.parseInt(userInput);
            //send the number to the correct method in the model
            intNumber = model.multiplyNumber(intNumber);
            //send the number to the correct method in the view
            view.displayInt(intNumber);
        }catch (NumberFormatException e){
            try{
                doubNumber = Double.parseDouble(userInput);
                //send the number to the correct method in the model
                doubNumber = model.multiplyNumber(doubNumber);
                //send it to the view
                view.displayDouble(doubNumber);
            }catch (NumberFormatException ex){
                //display the error message
                view.displayError(userInput);
            }
        }




    }
}
