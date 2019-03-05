package InputDatabase;

import java.util.ArrayList;

public class Database {
	public static ArrayList<Question> questions = new ArrayList<>();
	
	public static void addToQuestions(Question q){
		questions.add(q);
	}
	
	public static Question getQuestionById(int id){
		return questions.get(id);
	}
	
	public static void printQuestions(){
		for(Question q: questions)
			System.out.println(q);
	}
	
}
