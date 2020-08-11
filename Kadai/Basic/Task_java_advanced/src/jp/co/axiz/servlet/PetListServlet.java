package jp.co.axiz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.pet.Animal;
import jp.co.axiz.util.PetUtil;

/**
 * Servlet implementation class PetListServlet
 */
@WebServlet({ "/PetListServlet", "/petListServlet" })
public class PetListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PetListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String animalType = request.getParameter("btn");
		PetSessionInfo petSessionInfo = (PetSessionInfo) request.getSession().getAttribute("petSessionInfo");
		Animal animal = null;

		if (animalType.equals("dog")) {
			animal = (Animal) petSessionInfo.getPetList().get("dog");
		} else if (animalType.equals("cat")) {
			animal = (Animal) petSessionInfo.getPetList().get("cat");
		}

		request.setAttribute("name", animal.getName());
		request.setAttribute("age", animal.getAge());
		request.setAttribute("height", animal.getHeight());
		request.setAttribute("weight", animal.getWeight());
		request.setAttribute("isFat", animal.isFat());
		request.setAttribute("type", animal.getType());
		request.setAttribute("optionTitle", PetUtil.getOptionTitleStr(animal));
		request.setAttribute("option", PetUtil.getOptionStr(animal));
		request.getRequestDispatcher("petInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
