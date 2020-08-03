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
@WebServlet("/inputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InputServlet() {
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
		String carName = request.getParameter("carName");
		String bodyColor = request.getParameter("bodyColor");
		String maxSpeedStr = request.getParameter("maxSpeed");

		// todo:未入力チェック
		// (入力値の3つのうち、どれか一つでも未入力なら「input.jsp」へ戻る
		//  未入力かどうかの判定は、UtilityクラスのisNullOrEmptyメソッドを使用)
		if (Utility.isNullOrEmpty(carName) || Utility.isNullOrEmpty(bodyColor) || Utility.isNullOrEmpty(maxSpeedStr)) {
			request.setAttribute("result", "未入力の項目があります");
			request.getRequestDispatcher("input.jsp").forward(request, response);
			return;
		}

		// todo:数値に変換
		// (数値項目[最高速度]の入力値の値を数値に変換)
		int maxSpeed = Utility.checkAndParseInt(maxSpeedStr);

		// todo:Carオブジェクト作成
		// 現在はnullをセットしている。Carオブジェクトを作成し、
		// フィールドに入力値をセットする。
		Car car = new Car();
		car.setCarName(carName);
		car.setBodyColor(bodyColor);
		car.setMaxSpeed(maxSpeed);

		// セッションを取得
		HttpSession session = request.getSession();

		// セッションにCarオブジェクトをセット
		session.setAttribute("car", car);

		// 結果画面へ遷移
		request.getRequestDispatcher("update.jsp").forward(request, response);

	}
}
