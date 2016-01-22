import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Created by Mike on 1/18/2016.
 */

@Entity
@Table(name = "employeeinfo")

public class employeeinfo {

  @Id
  @GeneratedValue
    private Integer EmployeeId;
    private String Lname;
    private String Fname;
    private Integer phone = 000;

  public employeeinfo(){

  }

  public String outputString() {

    return String.format("%-16s%-16s%-20s\n", EmployeeId, Lname, Fname, phone);

  }

  public Integer getEmployeeId(){
      return EmployeeId;
  }

  public void setEmployeeId(Integer EmployeeId){
    this.EmployeeId = EmployeeId;
  }

  public String getLname(){
    return Lname;
  }

  public void setLname(String lname){
    this.Lname = lname;
  }

  public String getFname(){
    return Fname;
  }

  public void setFname(String fname){
    this.Fname = fname;
  }

  public Integer getphone(){
    return phone;
  }

  public void setphone(Integer phone){
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "employeeinfo{" +
      "EmployeeId=" + EmployeeId +
      ", Lname='" + Lname + '\'' +
      ", Fname='" + Fname + '\'' +
      ", phone=" + phone +
      '}';
  }
}
