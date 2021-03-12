package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {  
    
    ArrayList<String> messages = new ArrayList<String>(); 
    messages.add("Hello!");
    messages.add("Yo!");
    messages.add("Whats good?");
    messages.add("Aye!");
    messages.add("My friend!");

    Random rand = new Random();
    int i = rand.nextInt(4);
    String json = convertToJson(messages.get(i));
    
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  public String convertToJson(String message){
    Gson gson = new Gson();
    String json = gson.toJson(message);
    return json;
  }
}
