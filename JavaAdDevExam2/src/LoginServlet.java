
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		if (Utility.isNullOrEmpty(id) || Utility.isNullOrEmpty(password)) {
			if (Utility.isNullOrEmpty(id))
				request.setAttribute("idError", "IDは必須です");
			if (Utility.isNullOrEmpty(password))
				request.setAttribute("passwordError", "PASSは必須です");

			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		if ((id.equals("axiz") && password.equals("axizuser"))
				|| (id.equals("technocore") && password.equals("techno-pass"))) {
			request.setAttribute("id", id);
			request.getRequestDispatcher("/result.jsp").forward(request, response);
			return;
		}

		request.setAttribute("inputError", "IDまたはPASSが間違っています");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return;
	}

}
