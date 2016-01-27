package com.qc.json;

import com.qc.json.org.quickconnectfamily.json.JSONException;
import com.qc.json.org.quickconnectfamily.json.JSONInputStream;
import com.qc.json.org.quickconnectfamily.json.JSONOutputStream;
import com.qc.json.org.quickconnectfamily.json.JSONUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

/**
 * Created by Mike on 1/23/2016.
 */


public class Json {


  public static void main(String[] args) {

    try {
      FileOutputStream fout = new FileOutputStream("SomeFileName.someExtension");
      FileInputStream fin = new FileInputStream("SomeFileName.someExtension");

      JSONOutputStream jsonOut = new JSONOutputStream(fout);
      JSONInputStream jsonIn = new JSONInputStream(fin);

      Employee employees = new Employee("Mike", "Obray", 7, 1243551);
      jsonOut.writeObject(employees);

      HashMap parsedJSONMap = (HashMap) jsonIn.readObject();
      Employee readObject = new Employee(parsedJSONMap);
      System.out.println("stream same? "+readObject.equals(employees));

      String jsonString = JSONUtilities.stringify(employees);
      System.out.println("JSON: "+jsonString);

      parsedJSONMap = (HashMap) JSONUtilities.parse(jsonString);
      readObject = new Employee(parsedJSONMap);
      System.out.println("stringify same? "+readObject.equals(employees));

      /*String json = "{\"First Name\":\"Mike\"}";
      HashMap employeeMap = (HashMap)JSONUtilities.parse(json);
      String employeestring = (String) employeeMap.get("string");
      employees.setFname(employeestring);
      System.out.println("HashMap JSON content: "+ json + "\nWhat is pulled from the Map: "
        + employeestring + "\nWhat is now set as Employee name: " + employees.getFname());
      file.writeFile(employees);
      file.readFile(employees);
*/
//      System.out.println("Bad Example:");
//      employees.setFname(null);
//      file.writeFile(employees);
//      System.out.println("Won't write the file.");
//      file.readFile(employees);
//      System.out.println("Won't read it though.");

    } catch (JSONException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}



