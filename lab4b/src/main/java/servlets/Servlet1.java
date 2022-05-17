package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbs.Connect;
import jdbs.SqlCRUD;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import file.FileIO;
import insect.Insect;
import insect.Mock;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1/*")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//List<Insect> insectList = new Mock().getInsectList();
	//List<Insect> insectList = FileIO.loadFromFile();
	
	LabCRUDInterface<Insect> crud = new SqlCRUD();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub	
		crud = new SqlCRUD();
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			((SqlCRUD) crud).getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setContentType("application/json");
		//FileIO.saveToFile(insectList);
//		insectList.clear();
//		insectList = FileIO.loadFromFile();
		response.getWriter().println(crud.read());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Insect insect = Helpers.insectParse(request);
//		insect.setId(Helpers.getNextId(insectList));
//		insectList.add(insect);
//		FileIO.saveToFile(insectList);
		crud.create(insect);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Insect insect = Helpers.insectParse(request);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		response.setContentType("application/json");
//		int index = Helpers.getIndexByInsectId(id, insectList);
//		insectList.set(index,insect);
//		FileIO.saveToFile(insectList);
		crud.update(id, insect);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		
		response.setContentType("application/json");
//		int index = Helpers.getIndexByInsectId(id, insectList);
//		insectList.remove(index);
//		FileIO.saveToFile(insectList);
		crud.delete(id);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		setAccessControlHeaders(response);
		response.setStatus(HttpServletResponse.SC_OK);
		
	}
	
	 private void setAccessControlHeaders(HttpServletResponse resp) {
		 resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		  resp.setHeader("Access-Control-Allow-Origin", "*");
	      resp.setHeader("Access-Control-Allow-Methods", "*");
	      resp.setHeader("Access-Control-Allow-Headers", "*");
	  }

}
