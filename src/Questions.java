
public class Questions {

	static String[] GetQuestions(String[] string, int line, String[] difficulties, int question_checker)              
	{	                 
		
		String[] Questions1 = new String[line];               // stores questions in different arrays according to difficulty
		String[] Questions2 = new String[line];
		String[] Questions3 = new String[line];
		String[] Questions4 = new String[line];
		String[] Questions5 = new String[line];
		for(int i = 0; i < string.length; i++) {
			 String a =  difficulties[i];
			 for(int j = 0; j < Millionarie_game.UsedQuestionIndex + 1; j++) { // if the question is used it won't be in array
				 if(Millionarie_game.UsedQuestion[j] != null && Millionarie_game.UsedQuestion[j].equals(string[i].split("#")[1])) {
					 if(a.equals("1"))
					     Questions1[i] = null;	
					 else if(a.equals("2"))
						 Questions2[i] = null;
					 else if(a.equals("3"))
						 Questions3[i] = null;
					 else if(a.equals("4"))
						 Questions4[i] = null;
					 else if(a.equals("5"))
						 Questions5[i] = null;
					 break;
				 }
				 else if(j == Millionarie_game.UsedQuestionIndex){
					 if(a.equals("1"))
					     Questions1[i] = string[i].split("#")[1];	
					 else if(a.equals("2"))
						 Questions2[i] = string[i].split("#")[1];
					 else if(a.equals("3"))
						 Questions3[i] = string[i].split("#")[1];
					 else if(a.equals("4"))
						 Questions4[i] = string[i].split("#")[1];
					 else if(a.equals("5"))
						 Questions5[i] = string[i].split("#")[1];
					 break;
				 } 
				 
			}
		}
		   		
		if(question_checker==0)
		    return Questions1;
		else if(question_checker==1)
			return Questions2;
		else if(question_checker==2)
			return Questions3;
		else if(question_checker==3)
			return Questions4;
		else if(question_checker==4)
			return Questions5;
		return Questions1;
	}
}
