package InputDatabase;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException{
		FileHelper fh = new FileHelper();
		fh.readFile("source/single");
		fh.readFile("source/multiple");
//		DBHelper db = new DBHelper();
//		db.execute();
//		for(Question q: Database.questions)
//			System.out.println(q);
		
		StupidMethod sm = new StupidMethod();
		sm.execute();
		
	}
}
