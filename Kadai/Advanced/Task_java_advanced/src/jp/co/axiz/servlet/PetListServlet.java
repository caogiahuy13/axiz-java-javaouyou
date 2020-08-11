package jp.co.axiz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.pet.Animal;
import jp.co.axiz.pet.Pet;
import jp.co.axiz.pet.Reptile;
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

		String petType = request.getParameter("btn");
		PetSessionInfo petSessionInfo = (PetSessionInfo) request.getSession().getAttribute("petSessionInfo");
		Pet pet = null;

		if (petType.equals("dog")) {
			pet = petSessionInfo.getPetList().get("dog");
		} else if (petType.equals("cat")) {
			pet = petSessionInfo.getPetList().get("cat");
		} else if (petType.equals("lizard")) {
			pet = petSessionInfo.getPetList().get("lizard");
		}

		request.setAttribute("pet", petType);
		request.setAttribute("name", pet.getName());
		request.setAttribute("age", pet.getAge());
		request.setAttribute("height", pet.getHeight());
		request.setAttribute("weight", pet.getWeight());

		if (PetUtil.isAnimal(pet)) {
			request.setAttribute("isAnimal", PetUtil.isAnimal(pet));
			request.setAttribute("isFat", ((Animal) pet).isFat());
			request.setAttribute("type", ((Animal) pet).getType());
			request.setAttribute("optionTitle", PetUtil.getOptionTitleStr(pet));
			request.setAttribute("option", PetUtil.getOptionStr(pet));
		} else if (PetUtil.isReptile(pet)) {
			request.setAttribute("isReptile", PetUtil.isReptile(pet));
			request.setAttribute("isDangerous", ((Reptile) pet).isDangerous());
		}

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
