package com.jonathan.hibernate;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.SQLGrammarException;
import org.hibernate.hql.internal.ast.QuerySyntaxException;

import java.util.List;

/**
 * Created by Jonathan on 1/25/2016.
 */
public class Main {
    public static void main(String[] args){

        DBConnect DB = new DBConnect();
        Session session = DB.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        /********************* Hibernate Querying ***************************/

        //happy path querying using regular HQL syntax
        System.out.println("Happy path HQL syntax");
        Query query = session.createQuery("select setName from SetsEntity");
        List results = query.list();
        System.out.println(results.toString());

        //happy path querying using just the from syntax
        System.out.println("Happy path FROM syntax getting full objects");
        query = session.createQuery("from UsersEntity");
        results = query.list();
        UsersEntity resultUser = new UsersEntity();
        resultUser = (UsersEntity) results.get(0);
        System.out.println(resultUser.getUserName());

        //happy path querying multi table relationship
        System.out.println("Happy path getting cards from sets");//note that the actual join is being handled internally
        query = session.createQuery("select cards from SetsEntity s where s.setName like '%zendikar%'");
        results = query.list();
        System.out.println(results.toString());
        CardsEntity cardsBySet;
        cardsBySet = (CardsEntity) results.get(0);
        System.out.println(cardsBySet.getCardName());


        //happy path querying with named bind variables
        query = session.createQuery("select cardName from CardsEntity where cardName like :card_name");
        query.setParameter("card_name","%jace%");
        results = query.list();
        System.out.println(results.toString());

        //nasty path querying with positional bind variables - this is deprecated dont do this
        query = session.createQuery("select cardName from CardsEntity where cardName like ? and rarity = ?");
        query.setParameter(0,"%jace%");
        query.setParameter(1,"R");
        results = query.list();
        System.out.println(results.toString());

        //nasty path hql queries with bad inputs
        System.out.println("Nasty Path HQL");
        try{
            query = session.createQuery("");//a blank query string
            results = query.list();
            System.out.println(results.toString());
        }catch (QuerySyntaxException e){
            System.out.println(e.toString());
        }


        //happy path querying with native sql
        //this is safe regardless of database
        SQLQuery sqlQuery = session.createSQLQuery("select s.set_name ,count(c.card_name) from cards c inner join sets s using(set_id) group by set_id");
        List<Object[]> sqlResults = sqlQuery.list();

        //this demonstrates how to retrieve multi-column data
        for(Object[] row : sqlResults){
            System.out.println(row[0] +" "+row[1]);
        }

        //nasty path querying with native sql
        //this works because I know it is a mysql database; if this was an oracle database this would result in a syntax error
        sqlQuery = session.createSQLQuery("select set_name from sets limit 5");
        results = sqlQuery.list();
        System.out.println(results.toString());

        //nasty path querying with native sql
        //this doesnt work because the ROWNUM syntax is oracle syntax and this is a mysql database
        sqlQuery = session.createSQLQuery("select set_name from sets where ROWNUM < 5");
        try{
            results = sqlQuery.list();
            System.out.println(results.toString());
        }catch(SQLGrammarException e){
            System.out.println(e.toString());
        }


        //happy path delete by email
        deleteUserByEmail("bobBuilder@bb.com");

        //happy path inserting data
        //see method for details
        insertUser("user", "Bob", "Builder", "bobBuilder@bb.com", "BobTheBuilder", "");

        //happy path updating data
        //see method for details
        updateUserFirstname("Bobara", "bobBuilder@bb.com");

    }

    public static void insertUser(String userType,String firstName, String lastName, String email, String userName, String password){
        //happy path inserting data
        DBConnect DB = new DBConnect();
        Session session = DB.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        UsersEntity newUser = new UsersEntity();

        newUser.setUserType(userType);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setUserName(userName);
        newUser.setPassword(password);
        newUser.setNumberOfLogins(0);

        try{
            session.save(newUser);
            transaction.commit();
        }catch(ConstraintViolationException e){
            System.out.println("Unique constraint violated");
            transaction.rollback();
        }finally {
            //session.close();
        }
    }

    public static void updateUserFirstname(String newName, String email){
        DBConnect DB = new DBConnect();
        Session session = DB.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query hql = session.createQuery("from UsersEntity where email = :email");
        hql.setParameter("email",email);
        UsersEntity modifyUser = (UsersEntity) hql.uniqueResult();
        modifyUser.setFirstName(newName);
        session.merge(modifyUser);
        transaction.commit();
        //session.close();
    }

    public static void deleteUserByEmail(String email){
        DBConnect DB = new DBConnect();
        System.out.println("Entered delete with email given: "+email);
        Session session = DB.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        //first get the ID of the row based on email given

        Query query = session.createQuery("select userId from UsersEntity where email = :email");
        query.setParameter("email",email);
        List<Integer> results = query.list();
        try{
            int id = results.get(0);
            System.out.println(results.get(0));
            UsersEntity user = (UsersEntity) session.get(UsersEntity.class,id);

            session.delete(user);
            transaction.commit();
            System.out.println("User with email: "+email+" successfully deleted");
        }catch (Exception e) {
            System.out.println(e.toString());
            transaction.rollback();
        }

    }
}
