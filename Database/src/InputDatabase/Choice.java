package InputDatabase;

public class Choice {
	int id;
	String option;
	String detail;
	

	public Choice(int id, String option, String detail) {
		super();
		this.id = id;
		this.option = option.trim();
		this.detail = detail;
	}

	public int getId() {
		return id;
	}

	public String getOption() {
		return option;
	}

	public String getDetail() {
		return detail;
	}
}
