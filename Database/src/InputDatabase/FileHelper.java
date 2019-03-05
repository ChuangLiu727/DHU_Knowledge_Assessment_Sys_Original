package InputDatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileHelper {
	int currentQId = 0;
	
	public void readFile(String filePath){
        try {
        	String encoding="GBK";
        	boolean isSingle = filePath.contains("single") ? true : false;
            File root=new File(filePath);
            File[] files = root.listFiles();
            for(File file: files){
            	String fileName = file.getName();
        		String chapter = fileName.split("\\.")[0];
        		Chapter.addToChapter(Integer.parseInt(chapter));
        		
            	InputStreamReader read = new InputStreamReader(
            			new FileInputStream(file),encoding);//考虑到编码格式
            	BufferedReader bufferedReader = new BufferedReader(read);
            	String line = null;
            	while((line = bufferedReader.readLine()) != null){
            		process(line, Integer.parseInt(chapter), isSingle);	
            	}
            	read.close();
            }
            
        } catch (Exception e) {
            	System.out.println("读取文件内容出错");
            	e.printStackTrace();
            	}
        }
	
	public void process(String line, int chapter, boolean isSingle){
		line = line.trim();
		boolean isQ = false;
		if('0' <= line.charAt(0) && line.charAt(0) <= '9')
			isQ = true;
		
		if(isQ){
			Question q = processQuestion(line, chapter, isSingle);
			Database.addToQuestions(q);
		}
		
		else if('A' <= line.charAt(0) && line.charAt(0) <= 'Z'){
			processChoice(line);
//			Question q = Database.getQuestionById(currentQId);
//			q.addToChoice(c);
		}
	}

	//analyse the line of quesion;
	public Question processQuestion(String line, int chapter, boolean isSingle){   
		currentQId = Question.count;      
		/* sometimes the index of the question does not correspond with the actual number. */
		line = line.replace(line.split("、")[0] + "、", "");
		Chapter.addQuestion(chapter, isSingle);
		int idInChapter = Chapter.getNumberOfOneChapter(chapter);
		int choiceType = isSingle? 1 : 2;
		String answer = null, question = null;
		String[] result = separateQuestionAndAnswer(line);
		question = result[0];
		answer = result[1];
		
		return new Question(chapter, idInChapter, question, answer, choiceType);
	}
	
	//first index is question without answer, second index is answer
	public String[] separateQuestionAndAnswer(String line){
		String[] result = new String[2];
		String answer = "";
		for(int i = 0; i < line.length(); i++){
			char c = line.charAt(i);
			if(c >= 'A' && c <= 'F' ){   
				answer += c;
				line = line.replace(String.valueOf(c), "");   //questions without answers
				i-- ;
				}
			}
		result[0] = line;
		result[1] = answer; 
		return result;
	}
	
	public void processChoice(String line){
		String option = line.split("、")[0];
		line = line.replace(option + "、", "");
		String detail = line;
		//whether existing other choices?
		boolean exist = false;
		for(int i = 0;i < line.length(); i++){
			char letter = line.charAt(i);
			if('A' <= letter && letter <= 'J'){
				detail = line.substring(0, i).trim();
				processChoice(line.substring(i).trim());
				break;
			}
		}
		
		Choice c = new Choice(currentQId, option, detail);
		Question q = Database.getQuestionById(currentQId);
		q.addToChoice(c);
	}
	
	private boolean isEnglishChar(char c){
		return (c >= 'A' && c<='Z') || (c >= 'a' && c <= 'z');
	}
	
}
