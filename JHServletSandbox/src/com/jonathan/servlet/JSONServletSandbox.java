package com.jonathan.servlet;


import json.JSONInputStream;
import json.JSONOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Jonathan on 2/22/2016.
 */
@WebServlet(name="JSONServletSandbox", urlPatterns="/json")
public class JSONServletSandbox extends HttpServlet {


    @Override
    public void init() throws ServletException {
        System.out.println("Entered init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entered doPost");

        //declare json in and out streams using request and response arguments
        JSONInputStream inFromClient = new JSONInputStream(request.getInputStream());
        JSONOutputStream outToClient = new JSONOutputStream(response.getOutputStream());
        try{
            System.out.println("Waiting for a message from the client.");
            HashMap aRequest = (HashMap) inFromClient.readObject();//get hashmap from client
            System.out.println("Just got:" + aRequest + " from client");
            aRequest.put("command", "Done");//add Done to hashmap
            outToClient.writeObject(aRequest); //send it back to client
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entered doGet");
        // Set response content type

    }
}
