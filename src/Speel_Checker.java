import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Speel_Checker {
	static File dictionary;
	static Scanner valid;
	static Scanner dic_input;
	static boolean ask = true;
	
	public static String main(String word) throws FileNotFoundException {
		dictionary = new File("dictionary.txt");
		dic_input = new Scanner(dictionary);
		valid = new Scanner(System.in);
		
		//4 harften küçükse kontrol etme, döndür
		if(word != null) {
			if(word.length() < 4) {
				return word;
			}
			
			
			String dic_text = null;
			String dicLast = null;
			String LwordLast = null;
			String wordLast = null;
			int[] arLast = {0,0};
			int unmatchedLast = -1;
			int dl, unmatchedChar;
			String wordL = word.toLowerCase();
			
			while(dic_input.hasNextLine()) {
				dic_text = dic_input.nextLine().toLowerCase();
				dl = dic_text.length();
				
				//Harf uzunluğu eşit bir kelime gelene kadar sözlükte ilerle
				if(dl != wordL.length()) {
					continue;
				}
				
				unmatchedChar = 0;
				int[] ar = {0,0};
				boolean ok = true;
				
				
				for(int x = 0; x < dl; x++) {
					if(dic_text.charAt(x) != wordL.charAt(x)) { //x konumundaki harfler uyuşmazsa...
						if(unmatchedChar == 2) { //2 den fazla harf uyuşmazsa kontrolü bırak ve ilerle
							ok = false;
							break;
						}
						ar[unmatchedChar] = x;
						unmatchedChar++;
					}
				}
				
				if(ok) {
					if(wordL.equals(dic_text)) { //Sözlükte eşleşen kelime parametredekinin aynısıysa kendisini döndür
						return word;
					}
					if(unmatchedLast != 1) { //Değilse son eşleşme olarak kaydet
					wordLast = word;
					LwordLast = wordL;
					dicLast = dic_text;
					unmatchedLast = unmatchedChar;
					arLast = ar;
					}
					
				}	
			}
			
			//Sözlük içinde eşleşme bulunduysa
			//1 Harf hatalı veya 2 harf yer değiştirmiş ise ask değişkenine göre otomatik düzelt veya kullanıcıdan onay iste
			if(dicLast != null){if((unmatchedLast == 1 || unmatchedLast == 0) || (dicLast.charAt(arLast[0]) == LwordLast.charAt(arLast[1]) && dicLast.charAt(arLast[1]) == LwordLast.charAt(arLast[0]))) {
				if(ask) {
					System.out.println("\nAuto-Correct: " + LwordLast + " --> " + dicLast + "\n(YES/pass/do not ask)?:");
					String v = valid.nextLine();
					if(v.toLowerCase().equals("do not ask")) {
						ask = false;
						dic_input.close();
						return dicLast;
					}
					if(v.toLowerCase().equals("yes") || v.equals("")) {
						dic_input.close();
						return dicLast;
					}
					else if(v.toLowerCase().equals("pass")) {
						dic_input.close();
						return wordLast;
					}
				}}
				
				//ask == false ise bulunan son düzeltmeyi döndür
				dic_input.close();
				return dicLast;
			}
					
			//Eşleşme yoksa döndür
			dic_input.close();
			return word;
		}
		//null'sa döndür
		dic_input.close();
		return word;
	}
}
