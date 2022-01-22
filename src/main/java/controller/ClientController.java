package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ClientService;

import java.io.IOException;
import java.util.List;



import com.google.gson.Gson;

import beans.Client;



/**
 * Servlet implementation class ClientController
 */

public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientService ss =new ClientService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	 if (request.getParameter("op") != null) {
             if (request.getParameter("op").equals("load")) {
                 response.setContentType("application/json");
                 List<Client> clients = ss.findAll();
                 Gson json = new Gson();
                 response.getWriter().write(json.toJson(clients));
             }
             else if(request.getParameter("op").equals("update")){
                 int id = Integer.parseInt(request.getParameter("id"));
                 Client client = ss.findById(id);
                 response.setContentType("application/json");
                 Gson json = new Gson();
                 response.getWriter().write(json.toJson(client));               
             }
             else if(request.getParameter("op").equals("delete")){
                 int id = Integer.parseInt(request.getParameter("id"));
                 ss.delete(ss.findById(id));
                 response.setContentType("application/json");
                 List<Client>clients = ss.findAll();
                 Gson json = new Gson();
                 response.getWriter().write(json.toJson(clients));  
            
    	 }
             
            
    }
    	 else {
        	 String nom = request.getParameter("nom");
            
             String prenom = request.getParameter("prenom");
             Client s= ss.findById(Integer.parseInt(request.getParameter("id")));
             if(s == null){
            	 ss.create(new Client(nom, prenom));
                 response.setContentType("application/json");
                 List<Client> clients = ss.findAll();
                 Gson json = new Gson();
                 response.getWriter().write(json.toJson(clients)); 
             }
             else{
                 s.setNom(nom);
                  s.setPrenom(prenom);
                 
                  ss.update(s);
                  response.setContentType("application/json");
                  List<Client> clients = ss.findAll();
                  Gson json = new Gson();
                  response.getWriter().write(json.toJson(clients));
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
