package jp.co.axiz.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.pet.Pet;
import jp.co.axiz.util.PetUtil;

/**
 * Servlet implementation class PetInfoServlet
 */
@WebServlet({ "/PetInfoServlet", "/petInfoServlet" })
public class PetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PetInfoServlet() {
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
		HttpSession session = request.getSession();

		String pet = request.getParameter("pet");
		String name = request.getParameter("name");
		String weightStr = request.getParameter("weight");

		PetSessionInfo petSessionInfo = (PetSessionInfo) session.getAttribute("petSessionInfo");
		HashMap<String, Pet> petList = petSessionInfo.getPetList();

		if (!PetUtil.isNullOrEmpty(weightStr) && PetUtil.isNumber(weightStr)) {
			int weight = PetUtil.checkAndParseInt(weightStr);
			petList.get(pet).setWeight(weight);
		}

		if (!PetUtil.isNullOrEmpty(name)) {
			petList.get(pet).setName(name);
		}

		petSessionInfo.setPetList(petList);

		session.setAttribute("petSessionInfo", petSessionInfo);

		request.setAttribute("msg", "ペット情報を変更しました。");
		request.getRequestDispatcher("petList.jsp").forward(request, response);
	}

}
