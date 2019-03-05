package InputDatabase;

import java.util.ArrayList;

public class Chapter {
	public static ArrayList<Chapter> chapters = new ArrayList<>(); //第一个用来记录总数
	int chapter;
	int radio;
	int multiple;
	
	static{
		chapters.add(new Chapter(-1, 0, 0));
	}
	
	public Chapter(int chapter, int radio, int multiple) {
		super();
		this.chapter = chapter;
		this.radio = radio;
		this.multiple = multiple;
	}
	
	public static int getNumberOfOneChapter(int chapter){
		Chapter ch = chapters.get(chapter+1);
		return ch.radio + ch.multiple;
		
	}

	public static void addToChapter(int ch){
		if(ch+1 < chapters.size())
			return;
		chapters.add(new Chapter(ch, 0, 0));
	}

	public static void addQuestion(int chapter, boolean isRadio){
		Chapter total = chapters.get(0);
		Chapter ch = chapters.get(chapter + 1);
		if(isRadio){
			ch.radio++ ;
			total.radio++;
		}
		else{
			ch.multiple++ ;
			total.multiple++;
		}
	}

	public static ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public int getChapter() {
		return chapter;
	}

	public int getRadio() {
		return radio;
	}

	public int getMultiple() {
		return multiple;
	}
	
	
	
	
}
