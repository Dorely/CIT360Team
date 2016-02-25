package com.jonathan.servlet;


import json.JSONInputStream;
import json.JSONOutputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class JSONEchoClient {
    public static void main(String[] args) {
        JSONEchoClient theClient = new JSONEchoClient();
        theClient.go();
    }

    private void go() {
        while (true) {
            try {
                //take command line input
                Scanner systemInScanner = new Scanner(System.in);
                System.out.printf("Enter the message to send to the server.\n");
                String messageForServer = systemInScanner.nextLine();

                //open a connection to the servlet at /json
                URL url = new URL("http://localhost:8080/json");//define url
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();//open the connection
                connection.setDoOutput(true);//allows POST

                //setup output to servlet using QCJson library
                JSONOutputStream outToServer = new JSONOutputStream(connection.getOutputStream());

                //send a hashmap to the servlet
                HashMap<String, Object> request = new HashMap<String,Object>();
                request.put("command", "Speak");
                request.put("message", messageForServer);
                outToServer.writeObject(request);//send the hashmap

                //setup an input from the servlet
                JSONInputStream inFromServer = new JSONInputStream(connection.getInputStream());

                //get the hashmap response from servlet
                HashMap<String, Object> response = (HashMap<String, Object>) inFromServer.readObject();

                //print out the response
                if (response.get("command").equals("Done")) {
                    System.out.println("Sent request: " + request + "and got response " + response);
                } else {
                    System.out.println("Oops. got " + response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}