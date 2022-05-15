package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import crud.Lab2Crud;
import insect.Insect;

/**
 * Servlet implementation class InsectServlet
 */
@WebServlet("/Servlet1")
public class InsectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletConfigInterface sevletConfig;
	Lab2Crud lab2Crud;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsectServlet() {
        super();
        
        this.sevletConfig = new ServletConfig();
        this.lab2Crud = sevletConfig.getCrud();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out = response.getWriter();
		
		out.println("[" + lab2Crud.readInsect() + "]");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		int age = Integer.parseInt(request.getParameter("age"));		
		String desc = request.getParameter("description");

		
		lab2Crud.updateInsect(new Insect(title, age, desc));
		
	}

}
