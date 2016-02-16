package com.jonathan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DBConnectNasty {

    private SessionFactory sessionFactory;

    public DBConnectNasty() {
        Configuration config = new Configuration();

//        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");//this didnt seem to break anything

        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        //change the next line of code to match your MySQL URL and port

        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/haronez1_magic");
//        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3308/haronez1_magic");//changing port - database not found
//        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/theWrongDatabase");//bad database name
//        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");//database exists, wrong tables - this only breaks some things, not all



        //change the next two lines of code to match your MySQL user name and password.

        config.setProperty("hibernate.connection.username", "haronez1_admin");
//        config.setProperty("hibernate.connection.username", "justSomeUser");//bad username - breaks everything
//        config.setProperty("hibernate.connection.username", "");//blank username - breaks everything


        config.setProperty("hibernate.connection.password", "penguin1");
//        config.setProperty("hibernate.connection.password", "penguin2");//bad password - breaks everything
//        config.setProperty("hibernate.connection.password", null);//null password - breaks everything even sooner

        //change the pool size to reflect how many users you expect your application to have initially

        config.setProperty("hibernate.connection.pool_size", "1");

        config.setProperty("hibernate.connection.autocommit", "true");

        config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");

		/*
		 * un-comment the next line of code if you want to be able to drop and recreate tables for your data classes listed below.  This is generally a bad idea for security reasons.
		 */

        //config.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        config.setProperty("hibernate.show_sql", "true");

        config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");

        config.setProperty("hibernate.current_session_context_class", "thread");

		/*
		 *  Add your classes here that you want to match your database tables
		 */

        config.addAnnotatedClass(SetsEntity.class);
        config.addAnnotatedClass(CardsEntity.class);
        //config.addAnnotatedClass(UsersEntity.class); // leave an entity out - works until I try to reference it
        config.addAnnotatedClass(Main.class);//pass a non entity class - doesnt break anything





        //config.addAnnotatedClass(PhoneNumber.class);
/*
 * There have been several changes to the Hibernate libraries.
 * Please uncomment the source code for the version of Hibernate you are using.
*/
         /*Hibernate 4.3 - 5.x */ //ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        /*Hibernate 3.x - 4.2*/ ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();

        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }


    public  Session getCurrentSession() {

        return sessionFactory.getCurrentSession();

    }

}