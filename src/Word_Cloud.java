import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
public class Word_Cloud {
	static Random rand = new Random();
	static Scanner sw;           
	static File sw_fi;          // its for stop words file
	static File Que;            // it gets question files
	
	static String[] GetQuestionWords(String[] questions, File sw_fi) throws FileNotFoundException                  
	{	
		int count = 1000;
		int i = 0;
		int counts = 0;
		String[] QuestionWords = new String[count];
		for(int j = 0; j < questions.length; j++) {
			if(questions[j]!=null) {
				String sentence = "";
				sentence = questions[j];         
				sentence = sentence.replace("?","");       // clears punctuations from words 
				sentence = sentence.replace(".","");
				sentence = sentence.replace("_","");
				sentence = sentence.replace(",","");
				sentence = sentence.replace("\"","");
				sentence = sentence.toLowerCase();
				String[] asd = DeleteStopWords(sw_fi, sentence.split(" ")); // deletes stop words function
				asd = DellNull(asd);                                        // calls del null function
				if(asd.length != 0)
					QuestionWords[counts] = asd[rand.nextInt(asd.length)];      // it gets random word from each question for word cloud
				counts++;
			}	
		}
		
		return QuestionWords;
	}
	static String[] DeleteStopWords(File sw_fi, String[] strings) throws FileNotFoundException  
	{	
		Scanner sc = new Scanner(sw_fi); // reads stop words txt
		while(sc.hasNextLine()) 
		{			
			String s = sc.nextLine();
			
			for(int i = 0; i < strings.length; i++) 
			{
				if(strings[i] != null && strings[i].equals(s))    // clears stop words
				{
					strings[i] = null;
				}						
			}	
		}		
		sc.close();
		return strings;
	}
	static String[] SpeelCheck(String[] strings) throws FileNotFoundException
	{	
		String[] words = new String[strings.length];
		for(int i = 0; i < strings.length; i++)
		     words[i] = Speel_Checker.main(strings[i]);     // calling spell checker class
		return words;
	}
	static String[] word_cloud(String path, String[] Questions) throws FileNotFoundException { 
		Que = new File(path);                                   // creates word cloud
		Scanner sc = new Scanner(Que);
		sw_fi = new File("stop_words.txt");
		Scanner sw = new Scanner(sw_fi);
		String[] WordCloud = SpeelCheck(GetQuestionWords(Questions, sw_fi));
		return WordCloud;
	}
	
	static String[] DellNull(String[] str) {              // clears null from words array
		int l = 0;
		for(int x = 0; x < str.length; x++) {
			if(str[x] != null && str[x] != "") {
				l++;
			}
		}	
		String[] str_n = new String[l];
		l = 0;
		
		for(int x = 0; x < str.length; x++) {
			if(str[x] != null && str[x] != "") {
				str_n[l] = str[x];
				l++;
			}
		}
		return str_n;
	}
}
