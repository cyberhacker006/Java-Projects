import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import enigma.core.Enigma;

public class Millionarie_game {
	public static boolean wrong_answer = false;
	public static boolean lifeline_50 = true;
	public static boolean double_dip = true;
	public static String[] Categories = new String[176];                   
	public static String[] Difficulties = new String[176]; 
	public static String[] UsedQuestion = new String[176];       // stores asked questions
	public static int UsedQuestionIndex = 0;
	public static String[] PlayedPariticpant = new String[176];  // stores played participants
	public static int PlayedPariticpantIndex = 0;
	public static int questionLineNum; 
	public static int participantLineNum;
	public static int participant;
	public static String[] Date = new String[participantLineNum];
	public static String[] Name = new String[participantLineNum];
	public static String[] Categories1 = new String[questionLineNum];
	public static String[] Address = new String[participantLineNum];
	public static String name_count ="";
	public static String lost_categories_count="";
	public static String won_categories_count="";
	public static String date_count ="";
	public static String city_count ="";
	public static int lower_than_thirty_participants; //to calculate the amount of participant
	public static int between_thirty_and_fifty_participants;
	public static int above_fifty_participants;
	public static int name_counter;
	public static int name_counter_max;
	public static int won_category_counter;
	public static int won_category_counter_max;
	public static int lost_category_counter;
	public static int lost_category_counter_max;
	public static int city_counter;
	public static int city_counter_max;
	public static int lower_than_thirty_counter; //to calculate the correct answers of them
	public static int between_thirty_and_fifty_counter;
	public static int above_fifty_counter;
	public static void main(String[] args) throws Exception {
		enigma.console.Console cn = Enigma.getConsole("Who Wants To Be A Millionarie ?", 100, 20, 20);
		Scanner scanner = new Scanner(System.in);
		Menu.main(args);      
		int answer_checker = 0;  
		String Questionpath = "questions.txt";                                        
		String Participantpath = "participants.txt";
		String[] QuestionString = FileInput.GetString(Questionpath);
		String[] ParticipantString = FileInput.GetString(Participantpath);
		questionLineNum = QuestionString.length;          
		participantLineNum = ParticipantString.length;
		String[] Question = new String[questionLineNum];                      
		String[] Answers = new String[questionLineNum*4];                                       
		String[] Difficulties = new String[questionLineNum];             
		String[] Options = new String[questionLineNum];                                                                             
		String[] Number = new String[participantLineNum];   
		boolean choice1 = true;    // controls menu options
		boolean choice2 = true; 
		boolean choice3 = true;
		boolean participantover = true;  // controls participants
		while(true){
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			if(choice == 1 && choice1 == true) {             // if player choose 1st option, load questions.   
				Answers = FileInput.GetAnswers(QuestionString, questionLineNum);
				Millionarie_game.Categories1 = FileInput.GetCategories( QuestionString, questionLineNum);
				String[] Cat_Copy = new String[Millionarie_game.Categories1.length];
				for(int x = 0; x < Millionarie_game.Categories1.length; x++) {
					Cat_Copy[x] = Millionarie_game.Categories1[x];
				}
				Millionarie_game.Difficulties = FileInput.GetDifficulty( QuestionString, questionLineNum);
				String[] Diff_Copy = new String[Millionarie_game.Difficulties.length];
				for(int x = 0; x < Millionarie_game.Difficulties.length; x++) {
					Diff_Copy[x] = Millionarie_game.Difficulties[x];
				}
				Options = FileInput.GetOptions(QuestionString, questionLineNum);			 
				PrintQueAndDiff.NumberOfCategories(Cat_Copy); 
				PrintQueAndDiff.NumberOfDifficulties(Diff_Copy);
				choice1 = false;			
			}
			 
			else if(choice == 1 && choice1 == false) {        // if player choose 1st option before, show a information message for the file already loaded.  
				System.out.println("!!The file is already loaded");
			}
			
			else if(choice == 2 && choice2 == true) {        // if player choose 2nd option, load participants.          
				Address = FileInput.GetPartipicantAddress(ParticipantString,participantLineNum);
				Date = FileInput.GetPartipicantDate(ParticipantString,participantLineNum);
				Name = FileInput.GetPartipicantName(ParticipantString,participantLineNum);
				Number = FileInput.GetPartipicantNumber(ParticipantString,participantLineNum);
				System.out.println("The file is loaded.");
				choice2 = false;
			}
			
			else if(choice == 2 && choice2 == false) {           // if player choose 2nd option before, show a information message for the file already loaded.   
				System.out.println("!!The file is already loaded");
			}
			else if(choice == 3 && participantover == false) {   // if player choose 3rd option and there is no participants, show a information message.  
				System.out.println("Participants are over. The game can't be started.");
			}
			else if(choice == 3 && choice1 == false && choice2 == false && participantover == true) {  // if player choose 3rd option, the game will be started. 
				Money.money = 0;
				answer_checker = 0;
				Clear_screen.clear(cn);
				Random random = new Random();
				participant = random.nextInt(21);
				int participantcontrol = 0;    // controls participants who is played
				while(participantcontrol < Millionarie_game.PlayedPariticpantIndex + 1) { // this loop controls all possibilites
					if(Millionarie_game.PlayedPariticpant[participantcontrol]!=null && Millionarie_game.PlayedPariticpant[participantcontrol].equals(Name[participant])) {
						participant = random.nextInt(21);
						participantcontrol = 0;
					}
					
					else if(Millionarie_game.PlayedPariticpantIndex == Name.length && participantcontrol==Millionarie_game.PlayedPariticpantIndex) {
						System.out.println("Participants are over.");
						participantover = false;                          // if there is no pariticpants who never played the game will ended
					}
					else if((participantcontrol==Millionarie_game.PlayedPariticpantIndex)){
						Millionarie_game.PlayedPariticpant[Millionarie_game.PlayedPariticpantIndex] =  Name[participant];
						break;
					}
					 participantcontrol++;
				}
				if(participantover == true) {                // Gets the informations of Competitor.
					Millionarie_game.PlayedPariticpant[Millionarie_game.PlayedPariticpantIndex] =  Name[participant]; 
					Millionarie_game.PlayedPariticpantIndex++;
					cn.getTextWindow().setCursorPosition(35,8);
					System.out.println("Competitor: " + Name[participant]);
					city_count=city_count+ Address[participant]+"@";
					if(Integer.parseInt((Date[participant].replace(".", "@")).split("@")[2])>=1992)
					{
						lower_than_thirty_participants++;
					}
					else if(Integer.parseInt((Date[participant].replace(".", "@")).split("@")[2])<1992&&Integer.parseInt((Date[participant].replace(".", "@")).split("@")[2])>=1972)
					{
						between_thirty_and_fifty_participants++;
					}
					else 
					{
						above_fifty_participants++;
					}
					Thread.sleep(4000);
					Clear_screen.clear(cn);
					for(int i = 0; i < 5; i++) {
						Money.main(args, answer_checker, Millionarie_game.wrong_answer);
						Question = Questions.GetQuestions( QuestionString, questionLineNum, Millionarie_game.Difficulties, answer_checker);
						Milllionarie_competition.start_competition(scanner, Questionpath, Question, Answers, choice3, Options, Millionarie_game.wrong_answer, answer_checker, cn, Millionarie_game.lifeline_50, Millionarie_game.double_dip);
						answer_checker++;
						Thread.sleep(2000);
						Clear_screen.clear(cn);
						if(Millionarie_game.wrong_answer == true) {             // When competitor is lost, this part show a text message "you lost" and how many money competitor won.
							Millionarie_game.lifeline_50 = true;
							Millionarie_game.double_dip = true;
							Millionarie_game.wrong_answer = false;
							cn.getTextWindow().setCursorPosition(40,8);
							System.out.println("You lost.");
							cn.getTextWindow().setCursorPosition(40,9);
							System.out.println("You won: " + Money.money);
							Thread.sleep(4000);
							Clear_screen.clear(cn);
							Menu.main(args); 
							break;
						}
						if(answer_checker == 5) {                               // When competitor is knows every question. This part show a text message "YOU WON".
							Clear_screen.clear(cn);
							cn.getTextWindow().setCursorPosition(30,8);
							System.out.println("Congratulations!! All your answers was correct.");
							cn.getTextWindow().setCursorPosition(30,9);
							System.out.println("You won: " + Money.money);
							Menu.main(args);
							break;
						}
						else if(Mouse_listener.choice.equals("E")) {
							Menu.main(args);
							break;
						}
						choice3 = false;
					}
				}
			}
			else if(choice == 4 && choice3 == false) {                // If user select 4th option, this part show a text message a statistics of competitors informations.
				System.out.println("Statisctic");
				Statistics.main(args, cn);
			}
			else if(choice == 5) {
				System.out.println("Thanks for playing.");			  // If user select 5th option, show a text message and user quit the game.
				break;
			}
		}

	}

}
