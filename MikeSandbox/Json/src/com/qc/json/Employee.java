package com.qc.json;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Mike on 1/26/2016.
 */
public class Employee implements Serializable {
  private String theFname;
  private String theLname;
  private Number theEmployeeId;
  private Number thephone;

  public Employee(String Fname, String Lname, Number EmployeeId, Number phone){
    theFname = Fname;
    theLname = Lname;
    theEmployeeId = EmployeeId;
    thephone = phone;
  }

 public Employee(HashMap employeeMap){
    this.theFname = (String)employeeMap.get("theFname");
   this.theLname = (String)employeeMap.get("theLname");
   this.theEmployeeId =(Number)employeeMap.get("theEmployeeId");
   this.thephone =(Number)employeeMap.get("thephone");
 }

}
