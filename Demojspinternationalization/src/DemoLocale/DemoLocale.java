package DemoLocale;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.*;

@WebServlet("/DemoLocale")
public class DemoLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DemoLocale() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String[] planguage = request.getParameter("language").split("_");
		String language = planguage[0];
		String country = planguage[1];
		Locale locale = new Locale(language, country);
		request.setAttribute("country", locale.getDisplayCountry());
		
		//
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		request.setAttribute("fnumber", numberFormat.format(1234567));
		
		//
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.conten", locale);
		request.setAttribute("fstring", resourceBundle.getString("message"));
		
		request.getRequestDispatcher("locale1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
