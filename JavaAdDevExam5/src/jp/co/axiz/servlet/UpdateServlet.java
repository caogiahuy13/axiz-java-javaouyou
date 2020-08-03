package jp.co.axiz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.entity.Car;
import jp.co.axiz.util.Utility;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*
		 * 下記のコメントを参考に必要な処理を実装してください
		 */

		// todo:入力値取得
		String speedStr = request.getParameter("speed");
		String btn = request.getParameter("btn");

		// todo:戻るボタンクリック時、「input.jsp」へ遷移
		if (btn.equals("back")) {
			request.getRequestDispatcher("input.jsp").forward(request, response);
			return;
		}

		// todo:数値項目の入力値を数値に変換
		int speed = Utility.checkAndParseInt(speedStr);

		// セッションを取得
		HttpSession session = request.getSession();

		// セッションからinput.jspで作成したCarオブジェクトを取得
		Car car = (Car) session.getAttribute("car");

		// todo:セッターを使って、現在の速度(入力値)をセット
		car.setSpeed(speed);

		// todo:メッセージをセット
		request.setAttribute("result", "現在速度を変更しました");

		// 結果画面へ遷移
		request.getRequestDispatcher("update.jsp").forward(request, response);

	}
}
