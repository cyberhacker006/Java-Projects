import java.util.Arrays;
import enigma.core.Enigma;
public class PrintQueAndDiff {
	static void NumberOfCategories(String[] string) 
	{	
		enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard"); // this class for getting number of each categories
		System.out.println("\n=== Categories ===\n");   // and number of each difficulty
		int count = 0;
		String[] Category = string;
		Arrays.sort(Category);
		for(int i = 0; i < Category.length - 1; i++) {
			if(Category[i].equals(Category[i + 1])) {
				count++;
			}
			else if(i == Category.length - 2) {
				System.out.println(Category[i] + " ==> " + (count + 1));
			}
			else{
				System.out.println(Category[i] + " ==> " + (count + 1));
				count = 0;
			}
			
		}
		
	}
	static void NumberOfDifficulties(String[] string) 
	{	
		enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard");
		System.out.println("\n= Number of questions per difficulity =\n");
		int count = 0;
		String[] Difficulty = string;
		Arrays.sort(Difficulty);
		for(int i = 0; i < Difficulty.length - 1; i++) {
			if(Difficulty[i].equals(Difficulty[i + 1])) {
				count++;
			}
			else if(i == Difficulty.length - 2) {
				System.out.println(Difficulty[i] + " --> " + (count + 1));
			}
			else{
				System.out.println(Difficulty[i] + " --> " + (count + 1));
				count = 0;
			}
			
		}
		System.out.print("\n");
	}

}
