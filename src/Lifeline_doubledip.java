import java.util.Scanner;

import enigma.console.Console;

public class Lifeline_doubledip {

	static void doubledip(Scanner scanner, String[] options, boolean wrong_answer, int b, Console cn, String[] answers) throws Exception {
		cn.getTextWindow().setCursorPosition(0, 5);
		System.out.println("Double Dip Used.");
		for(int i = 0; i < 2; i++) {
			cn.getTextWindow().setCursorPosition(0, 5);
			System.out.print("PLease enter your choice: ");
			Mouse_listener.Game();
			String choice = Mouse_listener.choice;                        // it gets the choice from mouse listener
			choice = choice.toUpperCase();
			if(options[b].equals(choice)) {
				cn.getTextWindow().setCursorPosition(0, 5);
				System.out.println("Answer is true.");
				Millionarie_game.wrong_answer = false;                         // it controls the worng answer
				wrong_answer = false;
				break;
			}
			else if(choice.equals("2") && Millionarie_game.lifeline_50==true) {// if player wants to use %50 lifeline  
				Lifeline_50.lifeline_50(cn, options, b, answers);
				Millionarie_game.lifeline_50 = false;
				i--;
			}
			else if(choice.equals("2") && Millionarie_game.lifeline_50==false) {
				cn.getTextWindow().setCursorPosition(0, 5);
				System.out.println("You have already used %50.");
				i--;
			}
			else if(choice.equals("1") && Millionarie_game.double_dip==false) {
				cn.getTextWindow().setCursorPosition(0, 5);
				System.out.println("You have already used DoubleDip.");
				i--;
			}
			else if(i==0) {
				cn.getTextWindow().setCursorPosition(0, 5);
				System.out.println("Answer is false. Enter your second choice: ");// its for second choice
			}
			else if(i==1) {                                                        // if second choice is wrong
				cn.getTextWindow().setCursorPosition(0, 5);
				System.out.println("Answer is false.");
				cn.getTextWindow().setCursorPosition(0, 6);
				System.out.println("True answer was: " + options[b]);
				cn.getTextWindow().setCursorPosition(0, 7);
				System.out.println("You earned: " + Money.money); 
				Millionarie_game.wrong_answer = true;
				wrong_answer = true;
		    }
		}
	}
}
