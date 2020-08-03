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
		  todoコメントを参考に、必要な処理を実装してください。
		  ※記載済の処理は消さないでください。
		*/

		// 入力値取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");

		// ラジオボタンの選択値を格納するための変数
		String appType = "";

		// todo:ラジオボタンの選択値を取得
		appType = request.getParameter("appType");

		if (name == null || name.isEmpty()) {
			// ユーザ名未入力の場合は何もせず、appStart.jspへ遷移
			request.getRequestDispatcher("appStart.jsp").forward(request, response);
			return;
		}

		App app = null;

		// todo:アプリの選択に応じたオブジェクトを作成
		// ("その他"を選択した場合は、オブジェクトを作成しない)

		switch (appType) {
		case "card":
			// todo：トランプを選択した場合は、CardGameAppクラスのオブジェクトを作成
			app = new CardGameApp();
			break;

		case "darts":
			// todo：ダーツを選択した場合は、DartsGameAppクラスのオブジェクトを作成
			app = new DartsGameApp();
			break;

		case "clock":
			// todo：時計を選択した場合は、ClockAppクラスのオブジェクトを作成
			app = new ClockApp();
			break;
		}

		// アプリ実行結果のメッセージを入れるための変数
		String result = "";

		// todo:作成したオブジェクトのstartメソッドを呼び、戻り値を変数resultへ代入する
		// その際、処理をtry - catchで囲み、catch内でresult変数に
		// "アプリの実行に失敗しました。"の文字列を代入する
		// ("その他"を選択した場合はオブジェクトを
		//  作成していない(変数appの値はnullのまま)ため、
		//  NullPointerExceptionという例外が発生する)
		try {
			result = app.start(name);
		} catch (NullPointerException e) {
			result = "アプリの実行に失敗しました。";
		}

		// リクエストスコープへセット
		request.setAttribute("result", result);

		request.getRequestDispatcher("appStart.jsp").forward(request, response);
	}
}
