import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {
	private static File fi;
	private static Scanner sc;
	
	
	//Å�Ä±klarÄ± array olarak dÃ¶ndÃ¼r
	static String[] GetAnswers(String[] questions, int line) {
		sc = new Scanner(System.in);
		int count = line;
		int i = 0;
		String[] Answers = new String[count*4];
		for(int k = 0; k < questions.length; k++) 
		{		
			int a = 0;
			String[] All_Sentence = questions[k].split("#");
			for(int j = 2; j < 6; j++) 
			{
				if(a==0)
					Answers[i] = "A) " + All_Sentence[j];
				else if(a==1)
					Answers[i] = "B) " + All_Sentence[j];
				else if(a==2)
					Answers[i] = "C) " + All_Sentence[j];
				else 		
					Answers[i] = "D) " + All_Sentence[j];			
				a++;
				i++;
			}	
		}
		return Answers;
	}
	
	//Kategorileri array olarak dÃ¶ndÃ¼r
	static String[] GetCategories(String[] string, int line) 
	{	
		String[] categories = new String[line];
		for(int i = 0; i < string.length; i++)
			if(string[i]!=null)
			    categories[i] = string[i].split("#")[0];	
		return categories;
	}

	//Zorluk seviyelerini array olarak dÃ¶ndÃ¼r
	static String[] GetDifficulty(String[] string, int line) 
	{	
		String[] difficulty = new String[line];
		for(int i = 0; i < string.length; i++)
			if(string[i]!=null) 
				difficulty[i] = string[i].split("#")[7];
		return difficulty;
	}
	
	//SeÃ§enekleri array olarak dÃ¶ndÃ¼r
	static String[] GetOptions(String[] string, int line) 
	{	
		String[] options = new String[line];
		for(int i = 0; i < string.length; i++)
			if(string[i]!=null)
			    options[i] = string[i].split("#")[6];							
		return options;
	}
	
	//Oyuncu numaralarÄ±nÄ± array olarak dÃ¶ndÃ¼r
	static String[] GetPartipicantNumber(String[] string, int j) 
	{
		String[] number = new String[j];

		for(int i = 0; i < string.length; i++)
			number[i] = string[i].split("#")[2];

		return number;
	}
	
	//Oyuncu isimlerini array olarak dÃ¶ndÃ¼r
	static String[] GetPartipicantName(String[] string, int j) 
	{
		String[] names = new String[j];

		for(int i = 0; i < string.length; i++)
			names[i] = string[i].split("#")[0];
		
		return names;
	}
	
	//Oyuncu tarihlerini array olarak dÃ¶ndÃ¼r
	static String[] GetPartipicantDate(String[] string, int j) 
	{
		String[] date = new String[j];

		for(int i = 0; i < string.length; i++)
			date[i] = string[i].split("#")[1];

		return date;
	}
	
	//Oyuncu adreslerini array olarak dÃ¶ndÃ¼r
	static String[] GetPartipicantAddress(String[] string, int j) 
	{
		String[] address = new String[j];                
		for(int i = 0; i < string.length; i++)
			address[i] = string[i].split("#")[3];         
		return address;
	}
	
	//Dosyadaki satÄ±larÄ± array olarak dÃ¶ndÃ¼r
	static String[] GetString(String path) throws FileNotFoundException {   
		fi = new File(path);
		sc = new Scanner(fi);
		int i = 0;
		String[] str = new String[1];
		String[] str_old = new String[0];
		while(sc.hasNextLine()) 
		{
			str = new String[i+1];
			str[i] = sc.nextLine();
			for(int x = 0; x < str_old.length; x++) {
				str[x] = str_old[x];
			}
			str_old = str;
			i++;
			
		}
		sc.close();
		return str;
	}

}
