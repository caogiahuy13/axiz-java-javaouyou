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
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		  ※検索ボタンを押したときに必要な処理を実装してください。
		*/
		request.setCharacterEncoding("UTF-8");

		String english = request.getParameter("english");

		if (Utility.isNullOrEmpty(english)) {
			request.getRequestDispatcher("dictionary.jsp").forward(request, response);
			return;
		}

		if (!Dictionary.dictionary.containsKey(english)) {
			request.setAttribute("result", "見つかりませんでした");
			request.getRequestDispatcher("dictionary.jsp").forward(request, response);
			return;
		}

		request.setAttribute("result", String.format("英語：%s、日本語：%s", english, Dictionary.dictionary.get(english)));

		request.getRequestDispatcher("dictionary.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
