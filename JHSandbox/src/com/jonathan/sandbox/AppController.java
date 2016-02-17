package com.jonathan.sandbox;

import java.util.HashMap;

/**
 * Created by Jonathan on 2/16/2016.
 */
public class AppController {

    private HashMap<String,Handler> handlerMap = new HashMap();

    //default constructor initializes commands
    AppController(){
        initializeCommands();
    }

    public void handleRequest(String command, HashMap<String,Object> data){
        Handler aCommandHandler = handlerMap.get(command);
        if (aCommandHandler != null){
            aCommandHandler.handleIt(data);
        }
    }

    //this method maps the command, it is only called internally by initializeCommands()
    private void mapCommand(String aCommand, Handler acHandler){
        handlerMap.put(aCommand,acHandler);
    }

    //this method is what will be expanded when new commands are added
    private void initializeCommands(){
        mapCommand("subtract",new SubtractHandler());
        mapCommand("add",new AddHandler());
    }
}
