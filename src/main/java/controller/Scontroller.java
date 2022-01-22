package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.SalleService;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import beans.Salle;

/**
 * Servlet implementation class Scontroller
 */
public class Scontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SalleService ss  = new SalleService();
 /**
  * @see HttpServlet#HttpServlet()
  */
 public Scontroller() {
     super();
     // TODO Auto-generated constructor stub
 }
 
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
 	
 	 if (request.getParameter("op") != null) {
          if (request.getParameter("op").equals("load")) {
              response.setContentType("application/json");
              List<Salle> salles = ss.findAll();
              Gson json = new Gson();
              response.getWriter().write(json.toJson(salles));
          }
          else if(request.getParameter("op").equals("update")){
              int id = Integer.parseInt(request.getParameter("id"));
              Salle salle = ss.findById(id);
              response.setContentType("application/json");
              Gson json = new Gson();
              response.getWriter().write(json.toJson(salle));               
          }
          else if(request.getParameter("op").equals("delete")){
              int id = Integer.parseInt(request.getParameter("id"));
              ss.delete(ss.findById(id));
              response.setContentType("application/json");
              List<Salle>salles = ss.findAll();
              Gson json = new Gson();
              response.getWriter().write(json.toJson(salles));  
         
 	 }
          
         
 }
 	 else {
     	 String code = request.getParameter("code");
         
          String type = request.getParameter("type");
          Salle s= ss.findById(Integer.parseInt(request.getParameter("id")));
          if(s == null){
         	 ss.create(new Salle(type, code));
              response.setContentType("application/json");
              List<Salle> salles = ss.findAll();
              Gson json = new Gson();
              response.getWriter().write(json.toJson(salles)); 
          }
          else{
              s.setCode(code);
               s.setType(type);
              
               ss.update(s);
               response.setContentType("application/json");
               List<Salle> salles = ss.findAll();
               Gson json = new Gson();
               response.getWriter().write(json.toJson(salles));
           }    
               
          
      } 
 	 
 }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
