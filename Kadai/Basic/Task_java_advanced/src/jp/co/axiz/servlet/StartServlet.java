package jp.co.axiz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.util.PetUtil;

/**
 * Servlet implementation class StartServlet
 */
@WebServlet({ "/StartServlet", "/startServlet" })
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StartServlet() {
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
		request.setCharacterEncoding("UTF-8");

		String rightPass = "1234";

		String userPass = request.getParameter("pass");

		if (!PetUtil.isNumber(userPass)) {
			request.setAttribute("error", "暗証番号には数値を入力してください。");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		if (!userPass.equals(rightPass)) {
			request.setAttribute("error", "暗証番号が違います。");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		PetSessionInfo petSessionInfo = new PetSessionInfo();

		HttpSession session = request.getSession();
		session.setAttribute("petSessionInfo", petSessionInfo);

		request.getRequestDispatcher("petList.jsp").forward(request, response);

	}

}
