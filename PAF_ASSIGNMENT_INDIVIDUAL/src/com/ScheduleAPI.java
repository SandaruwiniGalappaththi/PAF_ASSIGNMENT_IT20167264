package com;
import com.Schedule;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScheduleAPI
 */
@WebServlet("/ScheduleAPI")
public class ScheduleAPI extends HttpServlet {
	Schedule s = new Schedule();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String output = s.insertschedule(request.getParameter("location"),
				request.getParameter("start"),
				request.getParameter("end"),
				request.getParameter("date"),
				request.getParameter("date"));
				response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		 String output = s.updateSchedule(paras.get("hidItemIDSave").toString(),
		 paras.get("location").toString(),
		paras.get("start").toString(),
		paras.get("end").toString(),
		paras.get("date").toString(),
		paras.get("date").toString());
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		 String output = s.deleteSchedule(paras.get("ID").toString());
		response.getWriter().write(output);
	}

	
	
	// Convert request parameters to a Map
		private static Map getParasMap(HttpServletRequest request)
		{
		 Map<String, String> map = new HashMap<String, String>();
		try
		 {
		 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
		 String queryString = scanner.hasNext() ?
		 scanner.useDelimiter("\\A").next() : "";
		 scanner.close();
		 String[] params = queryString.split("&");
		 for (String param : params)
		 { 
			 String[] p = param.split("=");
			 map.put(p[0], p[1]);
			 }
			 }
			catch (Exception e)
			 {
			 }
			return map;
			}

		 
}