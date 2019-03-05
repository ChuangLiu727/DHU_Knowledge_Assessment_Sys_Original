package InputDatabase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StupidMethod {
	public static String questionFileAddress = "db_question.sql";
	public static String choiceFileAddress = "db_choice.sql";
	public static String chapterFileAddress = "db_chapter.sql";
	
	public void writeFile(String path, String str) throws IOException{
		File f = new File(path);
		if(!f.exists())
			f.createNewFile();
		
		FileInputStream fis = new FileInputStream(path);
		if(fis.available() != 0)
			clearFile(path);
		
		FileWriter fw = new FileWriter(f.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		String sb = new String(str);
		bw.write(sb);
		bw.close();
	}
	
	public void execute() throws IOException{
    	ArrayList<Question> questions = Database.questions;
    	String questionStr = "";
    	String choiceStr = "";
    	for(Question q: questions){
    		String questionSql = "insert into question values("
    				+ q.getId() + ","
    				+ q.getChapter() + ","
    				+ q.getIdInChapter() + ","
    				+ "'" + q.getQuestion() + "'" + ","
    				+ "'" + q.getAnswer() + "'" + ","
    				+ q.getChoiceType() 
    				+ ");" ;
    		questionStr = questionStr + questionSql + "\r\n";
    		
    		ArrayList<Choice> choices = q.getChoice();
    		for(Choice c: choices){
    			String choiceSql = "insert into `choice` values("
    				+ c.getId() + ","
    				+ "'" + c.getOption() + "'" + ","
    				+ "'" + c.getDetail() + "'" + ");" ;
    			choiceStr = choiceStr + choiceSql + "\r\n";
    		}
    	}
    	//chapters
    	String chapterStr = "";
    	for(Chapter c : Chapter.chapters){
    		String chapterSql = "insert into chapter values("
    				+ c.getChapter() + ","
    				+ c.getRadio() + ","
    				+ c.getMultiple() + ");" ;
    		chapterStr = chapterStr + chapterSql + "\r\n";
    	}
    	
		writeFile(questionFileAddress, questionStr);
		writeFile(choiceFileAddress, choiceStr);
		writeFile(chapterFileAddress, chapterStr);
    }
	
	public void clearFile(String path) throws IOException{
		File f = new File(path);
		FileWriter fw = new FileWriter(f.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("");
		bw.close();
	}
	
	
}
