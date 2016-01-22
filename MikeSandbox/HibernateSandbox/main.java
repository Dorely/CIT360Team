import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Mike on 1/18/2016.
 */
public class main {

  private conDb theHibernateUtility;
  List<employeeinfo> employees;

  public main(){

    theHibernateUtility = new conDb();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    main tester = new main();

    //tester.insertEmployee();
    //tester.showAllEmployee();
   // tester.modifyEmployee();
    tester.deleteEmployee();
  }

  private void menu(){
    System.out.println("Hello, World!");
    main test = new main();

    test.insertEmployee();

  }

  private void insertEmployee(){
    Session session = theHibernateUtility.getCurrentSession();
    Transaction transaction = session.beginTransaction();

    employeeinfo adding = new employeeinfo();
    adding.setEmployeeId(5);
    adding.setLname("Obray");
    adding.setFname("Mike");
    adding.setphone(000);

    employeeinfo adding2 = new employeeinfo();
    adding2.setEmployeeId(5);
    adding2.setLname("Obray");
    adding2.setFname("Mike");
    adding2.setphone(000);

    session.save(adding);
    session.save(adding2);
    transaction.commit();

    System.out.println("Employee generated ID is: " + adding.getEmployeeId());
    System.out.println("Employee2 generated ID is: " + adding2.getEmployeeId());
  }

  private void showAllEmployee() {
    Session session = theHibernateUtility.getCurrentSession();
    Transaction transaction = session.beginTransaction();

    Query EmployeesQuery = session.createQuery("select e from employeeinfo as e order by e.Lname");

    employees = EmployeesQuery.list();
    System.out.println("num users: "+employees.size());

    for (employeeinfo theEmployee: employees
         ) {
      System.out.println(theEmployee);

    }

    }
   // transaction.commit();

  private void modifyEmployee() {

    Session session = theHibernateUtility.getCurrentSession();
    Transaction transaction = session.beginTransaction();

    Query singleUserQuery = session.createQuery("select e from employeeinfo as e where e.EmployeeId=7");
    employeeinfo modUser = (employeeinfo)singleUserQuery.uniqueResult();

    modUser.setLname("ObrayLL");

    session.merge(modUser);

    transaction.commit();

    showAllEmployee();
  }

  private void deleteEmployee() {
    Session session = theHibernateUtility.getCurrentSession();
    Transaction transaction = session.beginTransaction();
    int numEmployees = 6;

    Query employeeList = session.createQuery("SELECT e FROM employeeinfo AS e WHERE EmployeeId is NOT NULL");

    employees = employeeList.list();
    System.out.println("How many are to be deleted: " + employees.size());


    Iterator<employeeinfo> employeeListed = employees.iterator();
    while(employeeListed.hasNext()) {
      employeeinfo element = employeeListed.next();
      System.out.println(element.getLname() + " will be deleted.");
    }

    Query deleteEmployee = session.createQuery("DELETE employeeinfo WHERE EmployeeId= 8");
    employeeListed = employees.iterator();
    while(employeeListed.hasNext()) {
      numEmployees++;
      employeeinfo element = employeeListed.next();
      System.out.println(element.getLname() + " has been deleted.");
      session.delete(employees.get(element.getEmployeeId() - numEmployees));
    }

    transaction.commit();
  }
//
}


