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



    //happy path stringify an object
    public void stringifySandbox(){
        Polygon polygon = new Polygon();
        String jsonString;

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

    public void nastyPaths(){

        //nasty path parsing bad input
        try{
            System.out.println("Nasty Path Parsing");

            //malformed JSON throws ParseException
            //JSONUtilities.parse("{\"numberOfSides\":,\"lengthsOfSides\":[2.0,2.0,2.0,2.0}");

            //parsing null
            System.out.println(JSONUtilities.parse(null));//returns null

            //parsing empty string
            //System.out.println(JSONUtilities.parse(""));//throws ParseException

        }catch(JSONException e){
            System.out.println("JSONException");
            System.out.println(e.toString());
        }catch(ParseException e){
            System.out.println("ParseException");
            System.out.println(e.toString());
        }

        //nasty path stringify with bad inputs
        try{
            System.out.println("Nasty Path Stringify");

            //stringify an integer
            System.out.println(JSONUtilities.stringify(1));

            //stringify a null
            System.out.println(JSONUtilities.stringify(null));

            //stringify a string
            System.out.println(JSONUtilities.stringify("Words here"));

            //stringify and array
            System.out.println(JSONUtilities.stringify(new int[]{1,2,3,4}));



        }catch(JSONException e){
            System.out.println(e.toString());
        }


        //nasty path bad file names
        try{
            FileOutputStream fout = new FileOutputStream(""); //breaks things
            FileInputStream fin = new FileInputStream("doesntexist.json");//FileNotFoundException

            //putting those file out and in streams into JSON out and in streams
            JSONOutputStream jsonOut = new JSONOutputStream(fout);
            JSONInputStream jsonIn = new JSONInputStream(fin);
        }catch (Exception e){
            System.out.println(e.toString());
        }

        //nasty path passing null to streams
        try{

            //putting those file out and in streams into JSON out and in streams
//            JSONOutputStream jsonOut = new JSONOutputStream(null);
            JSONInputStream jsonIn = new JSONInputStream(null);//NullPointerException
            //try passing nulls
        }catch (NullPointerException e){
            System.out.println(e.toString());
        }

        //writing a string
        try{
            System.out.println("Bad Write input");

            FileOutputStream fout = new FileOutputStream("nastypath.json"); //breaks things
            FileInputStream fin = new FileInputStream("nastypath.json");

            //putting those file out and in streams into JSON out and in streams
            JSONOutputStream jsonOut = new JSONOutputStream(fout);
            JSONInputStream jsonIn = new JSONInputStream(fin);

            //jsonOut.writeObject("String words");// no problem
            jsonOut.writeObject(null);// no problem
            jsonOut.writeObject(1); // no problem

            System.out.println(jsonIn.readObject());//no problem with the string
                                                    //throws error if file only contains null

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }



        //nasty path file io
        try {
            System.out.println("file io");
            //declaring file out and in streams
            FileOutputStream fout = new FileOutputStream("nastypath2.json"); //breaks things
            FileInputStream fin = new FileInputStream("nastypath2.json");

            //putting those file out and in streams into JSON out and in streams
            JSONOutputStream jsonOut = new JSONOutputStream(fout);
            JSONInputStream jsonIn = new JSONInputStream(fin);
            //try passing nulls

            Polygon octagon = new Polygon(8,new double[]{1,1,1,1,1,1,1,1});
            jsonOut.writeObject(octagon);


            HashMap parsedJSONMap = (HashMap) jsonIn.readObject();
            //read object on fiel you dont have priveledges
            //what if file isnt json

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

        //reading / writing to file that doesnt have permissions
        try{
            System.out.println("Bad permissions");

            FileOutputStream fout = new FileOutputStream("nopermission.json"); //breaks things
            FileInputStream fin = new FileInputStream("nopermission.json");

            //putting those file out and in streams into JSON out and in streams
            JSONOutputStream jsonOut = new JSONOutputStream(fout);
            JSONInputStream jsonIn = new JSONInputStream(fin);

            Polygon octagon = new Polygon(8,new double[]{1,1,1,1,1,1,1,1});
            jsonOut.writeObject(octagon);// java.io.FileNotFoundException: nopermission.json (Access is denied)

            jsonIn.readObject();// java.io.FileNotFoundException: nopermission.json (Access is denied)


        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}

