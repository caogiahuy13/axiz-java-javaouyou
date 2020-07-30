
public class American extends Human {
	public American() {
		super();
		language = "英語";
	}

	public American(String name, String language) {
		super(name, language);
	}

	@Override
	public String returnBirthPlaceInfo() {
		return "出身地:アメリカ";
	}

	@Override
	public String returnHumanInfo() {
		return super.returnHumanInfo() + "。アメリカの公用語は「英語」です";
	}
}
