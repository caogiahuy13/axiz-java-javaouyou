package jp.co.axiz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.entity.Product;
import jp.co.axiz.util.Utility;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/InputServlet")
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

		/*
		 下記のコメントを参考に必要な処理を記述してください
		 */
		request.setCharacterEncoding("UTF-8");

		// 「input.jsp」からの入力値取得
		String productName = request.getParameter("productName");
		String priceStr = request.getParameter("price");

		// 受け取った金額用の入力値を数値に変換
		// UtilityクラスのcheckAndParseIntを使用する
		// (戻り値がnullの場合は、未入力とみなす)
		if (Utility.checkAndParseInt(priceStr) == null) {
			request.setAttribute("result", "商品名か金額が未入力です。");
			request.getRequestDispatcher("input.jsp").forward(request, response);
			return;
		}

		// 入力値が未入力かどうかの判定を行う
		// (商品名はUtilityクラスのisNullOrEmptyメソッドを使い、
		// 金額は上記で変換した値がnullかどうかで判定)
		// 未入力の場合は、リクエストにメッセージをセットし、
		// 登録画面へ遷移する
		if (Utility.isNullOrEmpty(productName) || Utility.isNullOrEmpty(priceStr)) {
			request.setAttribute("result", "商品名か金額が未入力です。");
			request.getRequestDispatcher("input.jsp").forward(request, response);
			return;
		}

		// セッションを取得
		HttpSession session = request.getSession();

		// セッションより商品リストを取得
		// (警告が出るが、無視して良い)
		ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("productList");

		// 取得した商品リストが無い場合、ArrayListオブジェクトを新規作成
		if (productList == null) {
			productList = new ArrayList<Product>();
		}

		// productオブジェクトを作成し、入力値をセット
		Product product = new Product(productName, Integer.parseInt(priceStr));

		// productListに上記で作成したオブジェクトを追加
		productList.add(product);

		// セッションに商品リスト(productList)を登録
		session.setAttribute("productList", productList);

		// 結果画面へ遷移
		request.getRequestDispatcher("result.jsp").forward(request, response);

	}
}
