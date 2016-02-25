package com.jonathan.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Jonathan on 2/23/2016.
 */
@WebServlet(name = "HTTPServletSandbox", urlPatterns="/http")
public class HTTPServletSandbox extends HttpServlet {

    int requestCount;

    @Override
    public void init() throws ServletException {
        System.out.println("Entered init");
        requestCount = 0;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entered post");
        requestCount++;

        String name = request.getParameter("name");

        //declare a writer so that we can send out text directly as a response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //print out text directly to the browser as a response, I hate this, this is really annoying
        //if you are going to do this, look at doGet for a better way to modularize it using a jsp file

        String html =
                "<!DOCTYPE html>"
                        +"<html>"
                        +"  <head>"
                        +"      <meta charset=\"UTF-8\">"
                        +"      <title>"
                        +"          Servlet Post Response"
                        +"      </title>"
                        +"  </head>"
                        +"  <body>"
                        +"      <h1>Name</h1>"
                        +"      <p>"+name+" is your name from post</p>"
                        +"      <p>"+requestCount+" Hits to the servlet</p>"
                        +"  </body>"
                        +"</html>";
        out.println(html);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entered get");
        requestCount++;

        //get parameter "name" from get
        String name = request.getParameter("name");

        //create a string message
        String message = "Is your name from get";

        //set these variables as attributes of the request
        request.setAttribute("name",name);
        request.setAttribute("message",message);
        request.setAttribute("requestCount",requestCount);

        //forward the request to the jsp file for display
        RequestDispatcher dispatcher = request.getRequestDispatcher("/catch.jsp");
        dispatcher.forward(request, response);
    }
}
