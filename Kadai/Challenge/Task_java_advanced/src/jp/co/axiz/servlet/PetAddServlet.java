package jp.co.axiz.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.pet.Cat;
import jp.co.axiz.pet.Dog;
import jp.co.axiz.pet.Lizard;
import jp.co.axiz.pet.Pet;
import jp.co.axiz.util.PetUtil;

/**
 * Servlet implementation class PetAddServlet
 */
@WebServlet({ "/PetAddServlet", "/petAddServlet" })
public class PetAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PetAddServlet() {
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

		String btn = request.getParameter("btn");

		request.setAttribute("petType", btn);
		if (btn.equals("cat") || btn.equals("dog")) {
			request.setAttribute("isAnimal", true);
		}
		request.getRequestDispatcher("petAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String petType = request.getParameter("petType");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		String heightStr = request.getParameter("height");
		String weightStr = request.getParameter("weight");
		String type = request.getParameter("type");

		int age = PetUtil.isNumber(ageStr) ? Integer.parseInt(ageStr) : 0;
		int height = PetUtil.isNumber(heightStr) ? Integer.parseInt(heightStr) : 0;
		int weight = PetUtil.isNumber(weightStr) ? Integer.parseInt(weightStr) : 0;

		Pet pet = null;

		if (petType.equals("cat")) {
			String favoriteItem = request.getParameter("favoriteItem");
			pet = new Cat(name, age, height, weight, type, favoriteItem);
		} else if (petType.equals("dog")) {
			String walkingPlace = request.getParameter("walkingPlace");
			pet = new Dog(name, age, height, weight, type, walkingPlace);
		} else if (petType.equals("lizard")) {
			pet = new Lizard(name, age, height, weight);
		}

		HttpSession session = request.getSession();
		PetSessionInfo petSessionInfo = (PetSessionInfo) session.getAttribute("petSessionInfo");
		HashMap<String, Pet> petList = petSessionInfo.getPetList();
		long samePetTypeQuantity = petList
				.entrySet()
				.stream()
				.filter(map -> map.getKey().contains(petType))
				.count();

		petList.put(petType + samePetTypeQuantity, pet);

		petSessionInfo.setPetList(petList);
		session.setAttribute("petSessionInfo", petSessionInfo);

		request.setAttribute("msg", "ペット情報を追加しました。");
		request.getRequestDispatcher("petList.jsp").forward(request, response);
	}

}
