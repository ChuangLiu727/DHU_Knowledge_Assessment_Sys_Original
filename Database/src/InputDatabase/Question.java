package InputDatabase;

import java.util.ArrayList;

public class Question {
	int id;
	int chapter;
	int idInChapter;
	String question;
	String answer;
	int choiceType;  //radio is 1, multiple is 2
	ArrayList<Choice> choice;
	
	public static int count = 0;
	
	public Question(int chapter, int idInChapter, String question,
			String answer, int choiceType) {
		super();
		this.id = count;
		this.chapter = chapter;
		this.idInChapter = idInChapter;
		this.question = question;
		this.answer = answer;
		this.choiceType = choiceType;
		this.choice = new ArrayList<Choice>();
		count++;
	}
	
	public void addToChoice(Choice c){
		choice.add(c);
	}	
	
	public String toString(){
		String s = this.id + " " + this.chapter + " " + this.idInChapter+ " " + 
						this.question + " " + this.answer + "\n";
		for(Choice c: choice)
			s += (c.option + " " + c.detail + "\n");
		return s;
	}

	public int getId() {
		return id;
	}

	public int getChapter() {
		return chapter;
	}

	public int getIdInChapter() {
		return idInChapter;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public int getChoiceType() {
		return choiceType;
	}

	public ArrayList<Choice> getChoice() {
		return choice;
	}

	public static int getCount() {
		return count;
	}
	
	
	
}
