package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/StartAppServlet")
public class StartAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StartAppServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("appStart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		   todoコメントを参考に、必要な処理を実装してください。
		   ※記載済の処理は消さないでください。
		 */

		// 入力値取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");

		// todo:ラジオボタンの選択値を取得
		String appName = request.getParameter("appName");

		if (name != null && !name.isEmpty()) {
			GameApp app = null;

			// todo:
			// ラジオボタンの選択値に応じて、下記の通りオブジェクトを作成する
			// トランプを選択した場合：CardGameAppのオブジェクトを作成し、変数appに代入
			// ゲームを選択した場合：GameAppのオブジェクトを作成し、変数appに代入

			if (appName.equals("trump")) {
				app = new CardGameApp("トランプ");
			} else if (appName.equals("game")) {
				app = new GameApp("何か");
			}

			// アプリ実行結果のメッセージを入れるための変数
			String result = "";

			// todo:作成したオブジェクトのstartメソッドを呼び、戻り値を変数resultへ代入する
			result = app.start(name);

			// リクエストスコープへセット
			request.setAttribute("result", result);
		}

		request.getRequestDispatcher("appStart.jsp").forward(request, response);
	}
}
