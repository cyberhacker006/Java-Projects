import java.util.Random;
import enigma.console.Console;

public class Lifeline_50 {

	static void lifeline_50(Console cn, String[] option, int b, String[] answers) {
		cn.getTextWindow().setCursorPosition(0, 5);
		System.out.println("%50 Used.");
		String a = option[b];
		int lastline = 0;
		if(a.equals("A")) {                         // if the question answer equals A 
			for(int i = 0; i < 2; i++) {            
				Random random = new Random();
				int line = random.nextInt(5);
				if(line == lastline)                // it stores the last cursor 
					line++;                         // it prevents to delete same option
				lastline = line;
				if(line == 0)                        // the cursor position will pass the first coordinates 
					line++;
				if(line == 1)
					line++;
				for(int x = 0; x < 50; x++) {
					cn.getTextWindow().setCursorPosition(x, line);
					cn.getTextWindow().output(" ");
				}
			}
		}
		else if(a.equals("B")) {
			for(int i = 0; i < 2; i++) {
				Random random = new Random();
				int line = random.nextInt(5);
				if(line == lastline)
					line++;
				lastline = line;
				if(line == 0)
					line++;
				if(line == 2)
					line++;
				for(int x = 0; x < 50; x++) {
					cn.getTextWindow().setCursorPosition(x, line);
					cn.getTextWindow().output(" ");
				}
			}
		}
		else if(a.equals("C")) {
			for(int i = 0; i < 2; i++) {
				Random random = new Random();
				int line = random.nextInt(5);
				if(line == lastline)
					line++;
				lastline = line;
				if(line == 0)
					line++;
				if(line == 3)
					line++;
				for(int x = 0; x < 50; x++) {
					cn.getTextWindow().setCursorPosition(x, line);
					cn.getTextWindow().output(" ");
				}
			}
		}
		else if(a.equals("D")) {
			for(int i = 0; i < 2; i++) {
				Random random = new Random();
				int line = random.nextInt(5);
				if(line == lastline)
					line++;
				lastline = line;
				if(line == 0)
					line++;
				if(line == 4)
					line--;
				for(int x = 0; x < 50; x++) {
					cn.getTextWindow().setCursorPosition(x, line);
					cn.getTextWindow().output(" ");
				}
			}
		}
		cn.getTextWindow().setCursorPosition(0,6);
	}	
	
}
