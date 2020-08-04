package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		  ※登録ボタンを押したときに必要な処理を実装してください。
		*/
		request.setCharacterEncoding("UTF-8");

		String english = request.getParameter("english");
		String japanese = request.getParameter("japanese");

		if (Utility.isNullOrEmpty(english) || Utility.isNullOrEmpty(japanese)) {
			request.getRequestDispatcher("dictionary.jsp").forward(request, response);
			return;
		}

		Dictionary.dictionary.put(english, japanese);

		request.setAttribute("result", "登録しました");
		request.getRequestDispatcher("dictionary.jsp").forward(request, response);
	}
}
