package com.jonathan.sandbox;

import org.quickconnectfamily.json.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jonathan on 2/9/2016.
 */
public class QCJsonSandbox {

    private Polygon polygon = new Polygon();
    private String jsonString;

    //happy path stringify an object
    public void stringifySandbox(){
        try{
            jsonString = JSONUtilities.stringify(polygon);
            System.out.println(jsonString);
        }catch(JSONException e){
            System.out.println(e.toString());
        }
    }

    //happy path parse a json string
    public void parseSandbox(){
        String jsonString = "{\"numberOfSides\":4,\"lengthsOfSides\":[2.0,2.0,2.0,2.0]}";

        HashMap fromJson = new HashMap();
        Polygon square;

        try{
            //parse the JSON
            fromJson  = (HashMap) JSONUtilities.parse(jsonString); //Parse returns a hashmap of objects
            System.out.println(fromJson);

            //parse the integer value from the toString of the object from the hashmap
            // HashMap["numberOfSides"]->Object->String->Int
            int parameter1 = Integer.parseInt(fromJson.get("numberOfSides").toString());

            //JSON parsed the array into an Arraylist
            ArrayList list =(ArrayList) fromJson.get("lengthsOfSides");

            //Convert each item into a String then parse to double for use in the proper constructor
            //HashMap["lengthsOfSides"]->ArrayList->String[]->double[]
            String[] stringArray = new String[list.size()];
            double[] parameter2 = new double[list.size()];
            for (int i =0;i<stringArray.length;i++) {
                stringArray[i] = list.get(i).toString();
                parameter2[i] = Double.parseDouble(stringArray[i]);
            }

            //create a new Polygon from the data gotten from the JSON string
            square = new Polygon(parameter1,parameter2);


            //parse can throw either of these exceptions and so they should be handled
        }catch(JSONException e){
            System.out.println(e.toString());
        }catch(ParseException e){
            System.out.println(e.toString());
        }
    }

    public void fileInOutSandbox(){
        try {
            //declaring file out and in streams
            FileOutputStream fout = new FileOutputStream("jsonExample.json");
            FileInputStream fin = new FileInputStream("jsonExample.json");

            //putting those file out and in streams into JSON out and in streams
            JSONOutputStream jsonOut = new JSONOutputStream(fout);
            JSONInputStream jsonIn = new JSONInputStream(fin);

            Polygon octagon = new Polygon(8,new double[]{1,1,1,1,1,1,1,1});
            jsonOut.writeObject(octagon);

            HashMap parsedJSONMap = (HashMap) jsonIn.readObject();

            System.out.println(parsedJSONMap.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}

