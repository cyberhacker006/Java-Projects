import java.io.FileNotFoundException;
import java.util.Scanner;

import enigma.console.Console;
import enigma.core.Enigma;

public class Milllionarie_competition {
	static void start_competition(Scanner scanner, String Questionpath, String[] Question, String[] Answers, boolean choice3, String[] options, 
			boolean wrong_answer, int answer_checker, Console cn, boolean lifeline_50, boolean double_dip) throws Exception {
		
		System.out.println("Word Cloud:                                          Question: " + (answer_checker + 1) + "        " + "Difficulty: " + (answer_checker + 1));
		System.out.println();
		String[] Word_Clouds = Word_Cloud.word_cloud(Questionpath, Question); // getting word cloud
		 
		for(int i = 0; i < 100; i++)                              // printing word cloud
			if(Word_Clouds[i]!=null)
				System.out.print(Word_Clouds[i] + "        ");
			else if(Word_Clouds[i]!=null && i % 5 == 0) {
				System.out.print(Word_Clouds[i]);
			    System.out.println();
			}
		System.out.println();
		
		int b= -1;
		System.out.print("Please enter a word: ");  // getting a word from word cloud
		String word = scanner.next();
		word = word.toLowerCase();
		boolean flag = true;
		while(flag)                                // controling word if its in word cloud 
		{	
			for(int x = 0; x < Word_Clouds.length; x++) {
				if(word.equals(Word_Clouds[x])) {
					b = x;
					flag = false;
					break;
				}
			}
													
			if(b== -1){
				System.out.print("Please enter a valid word: ");
				word = scanner.next();
				word = word.toLowerCase();
			}				
		}
		
		int k = -1;
		do {
			k++;
			if(Question[k] != null) {
				b--;
			}
		}while(b != -1);
		b = k;
		Clear_screen.clear(cn);
		System.out.println("Q" + (answer_checker + 1) + ") " + Question[b]); // getting question according to word
		Millionarie_game.UsedQuestion[Millionarie_game.UsedQuestionIndex] = Question[b]; // stores the asked questions
		Millionarie_game.UsedQuestionIndex++;                                            // used question index
		for(int g=0; g < 4; g++) 
			System.out.println(Answers[b*4 + g]);                                // getting answers
		cn.getTextWindow().setCursorPosition(80, 2);
		System.out.println("Money: ");
		cn.getTextWindow().setCursorPosition(87, 2);
		System.out.println(Money.money);
		cn.getTextWindow().setCursorPosition(80, 3);
		System.out.print("Time: ");
	
		if(Millionarie_game.double_dip == true) {
			cn.getTextWindow().setCursorPosition(80, 4);            // printing money, lifelines, and timer to player
			System.out.println("DoubleDip");
		}	
		else if(Millionarie_game.double_dip == false) {
			cn.getTextWindow().setCursorPosition(80, 4);
			System.out.println("-");
		}	
		if(Millionarie_game.lifeline_50 == true) {
			cn.getTextWindow().setCursorPosition(80, 5);
			System.out.println("%50");
		}
		else if(Millionarie_game.lifeline_50 == false) {
			cn.getTextWindow().setCursorPosition(80, 5);
			System.out.println("-");
		}
			
		
		while(wrong_answer==false) {
			cn.getTextWindow().setCursorPosition(0, 6);
			System.out.print("PLease enter your choice (E:Exit): ");
			Mouse_listener.timer = 20;
			Mouse_listener.Game();                                // getting answer from player
			String choice = Mouse_listener.choice;
			if(Mouse_listener.choice == null)
				choice = " ";
			choice = choice.toUpperCase();
			
			if(options[b].equals(choice)) {
				cn.getTextWindow().setCursorPosition(0, 5);
				System.out.println("Answer is true.");
				Millionarie_game.name_count= Millionarie_game.name_count + Millionarie_game.Name[Millionarie_game.participant]+"@"; // storing information for statistic
				Millionarie_game.won_categories_count = Millionarie_game.won_categories_count+Millionarie_game.Categories1[b]+ "@";
				Millionarie_game.date_count = Millionarie_game.date_count+ Millionarie_game.Date[Millionarie_game.participant]+"@";
				break;
			}	
			else if(choice.equals("1") && double_dip==true) {    // if player wants to use double dip
				Lifeline_doubledip.doubledip(scanner,options, wrong_answer, b, cn, Answers);
				Millionarie_game.double_dip=false;
				double_dip = false;
				break;
			}
			else if(choice.equals("2") && lifeline_50==true) {   // if player wants to use %50
				Lifeline_50.lifeline_50(cn, options, b, Answers);
				Millionarie_game.lifeline_50=false;
				lifeline_50 = false;
			}
			else if(choice.equals("1") && double_dip==false) {  // if double dip used
				cn.getTextWindow().setCursorPosition(0, 5);
				System.out.println("You have already used DoubleDip.");
				}
			else if(choice.equals("2") && lifeline_50==false) {   // if %50 used
				cn.getTextWindow().setCursorPosition(0, 5);
				System.out.println("You have already used %50.");
			}
			else if(Mouse_listener.timer == 0) {                  // controling timer
				Clear_screen.clear(cn);
				cn.getTextWindow().setCursorPosition(35,8);
				System.out.println("Time is over");
				cn.getTextWindow().setCursorPosition(35,9);
				System.out.println("You won: " + Money.money);
				wrong_answer = true;
				Millionarie_game.wrong_answer = true;
			}
			else if(choice.equals("E")) {                        // if the player wants to quit
				Clear_screen.clear(cn);
				cn.getTextWindow().setCursorPosition(30,8);
				System.out.println("Thanks for playing.");
				cn.getTextWindow().setCursorPosition(30,9);
				System.out.println("You won: " + Money.money);
				return;
			}
				
			else {
				cn.getTextWindow().setCursorPosition(0, 5);       // controls correct answers
				System.out.println("Answer is false.");
				cn.getTextWindow().setCursorPosition(0, 6);
				System.out.println("True answer was: " + options[b]);
				cn.getTextWindow().setCursorPosition(0, 7);
				System.out.println("You won: " + Money.money);
				wrong_answer = true;
				Millionarie_game.lost_categories_count=Millionarie_game.lost_categories_count+Millionarie_game.Categories1[b]+"@";
				Millionarie_game.wrong_answer = true;
			}		
		}	
		if(wrong_answer==true)
			return;
	}
}
