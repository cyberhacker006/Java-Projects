
public class Money {
	static int money = 0;
	public static void main(String[] args ,int answer_checker, boolean wrong_answer) {
		
		
		if (answer_checker == 0)        // the money will increase in each correct answer
		{
			money = 0;
		}
		else if (answer_checker == 1)
		{
			money = 20000;
		}
		else if (answer_checker == 2)
		{
			money = 100000;
		}
		else if (answer_checker == 3)
		{
			money = 250000;
		}
		else if (answer_checker == 4)
		{
			money = 500000;
		}
	
		
		if (wrong_answer == true && answer_checker == 2)     // if the answer was incorrect player earns saved money 
		{
			money = 100000;
		}
		else if (wrong_answer == true && answer_checker == 3)
		{
			money = 100000;
		}
		else if (wrong_answer == true && answer_checker == 4)
		{
			money = 500000;
		}
		else if (wrong_answer == true && answer_checker == 5)
		{
			money = 500000;
		}
	}

}
