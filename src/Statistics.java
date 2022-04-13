import java.util.Arrays;

import enigma.console.Console;
import enigma.core.Enigma;

public class Statistics {
	public static String most_successful_player;
	public static String most_correct_category;
	public static String most_wrong_category;
	public static String participated_cities;
	public static String most_city;

	public static void main(String[] args, Console cn) {
		
		//to count the times that each player answered correctly
		String[] name_array = Millionarie_game.name_count.split("@");
		Arrays.sort(name_array);
		for (String j: name_array)
		{
			if(j == j+1)
			{
				Millionarie_game.name_counter++;
			}
			else {
				Millionarie_game.name_counter_max=Millionarie_game.name_counter;
				most_successful_player=j;
				Millionarie_game.name_counter=0;
			}
			if(Millionarie_game.name_counter>Millionarie_game.name_counter_max)
			{
				most_successful_player=j;
			}
		}
		
		// to calculate which city has the most participants
		String participated_cities = Millionarie_game.city_count.replace(";","@");
		String[] participated_cities_array = participated_cities.split("@");
		for (int i = 0;i<participated_cities_array.length/5;i++)
		{
			if(participated_cities_array.length >(i+1)*5+3)
			{
				if(participated_cities_array[i*5+3]== participated_cities_array[(i+1)*5+3])
				{
					Millionarie_game.city_counter++;
				}
				else {
					Millionarie_game.city_counter_max= Millionarie_game.city_counter;
					most_city = participated_cities_array[i*5+3];
					Millionarie_game.city_counter =0;
				}
				if(Millionarie_game.city_counter>Millionarie_game.city_counter_max)
				{
					most_city = participated_cities_array[i*5+3];
				}
			}
			else {
				most_city =participated_cities_array[i*5+3];
			}
			
		}
		
		// to calculate the participants ages
		String dates = Millionarie_game.date_count.replace(".", "@");
		String[] date_years = dates.split("@");
		
		for(int i = 0;i<(date_years.length)/3;i++)
		{
			if(date_years.length>(i*3)+2)
			{
				if(Integer.parseInt(date_years[(i*3)+2])<=1992)
				{
					Millionarie_game.lower_than_thirty_counter++;
				}
				else if(Integer.parseInt(date_years[(i*3)+2])>1992 &&Integer.parseInt(date_years[(i*3)+2])<=1972)
				{
					Millionarie_game.between_thirty_and_fifty_counter++;
				}
				else {
					Millionarie_game.above_fifty_counter++;
				}
			}
			else {
				continue;
			}
		}
		
		// to calculate the correctly answered categories
		String[] won_categories_counter = Millionarie_game.won_categories_count.split("@");
		Arrays.sort(won_categories_counter);
		for (String k: won_categories_counter)
		{
			if(k == k+1)
			{
				Millionarie_game.won_category_counter++;
			}
			else {
				Millionarie_game.won_category_counter_max= Millionarie_game.won_category_counter;
				most_correct_category = k;
			}
			if(Millionarie_game.won_category_counter>Millionarie_game.won_category_counter_max)
			{
				most_correct_category= k;
			}
		}
		
		// to count that wrongly answered categories
		String[] lost_categories_counter = Millionarie_game.lost_categories_count.split("@");
		Arrays.sort(lost_categories_counter);
		for (String k: lost_categories_counter)
		{
			if(k == k+1)
			{
				Millionarie_game.lost_category_counter++;
			}
			else {
				Millionarie_game.lost_category_counter_max= Millionarie_game.lost_category_counter;
				most_wrong_category = k;
			}
			if(Millionarie_game.lost_category_counter>Millionarie_game.lost_category_counter_max)
			{
				most_wrong_category= k;
			}
		}
		
		System.out.println("♦ The most successful contestant : " + most_successful_player);
		System.out.println("♦ The category with most correctly answered : " + most_correct_category);
		System.out.println("♦ The category with most badly answered : " + most_wrong_category);
		System.out.println("♦ Age <=30 : "+(Millionarie_game.lower_than_thirty_counter+1)/(Millionarie_game.lower_than_thirty_participants+1)+" "+"30<Age<=50 : "+(Millionarie_game.between_thirty_and_fifty_counter+1)/(Millionarie_game.between_thirty_and_fifty_participants+1)+" "+"Age>50 : " + (Millionarie_game.above_fifty_counter+1)/(Millionarie_game.above_fifty_participants+1));
		System.out.println("♦ The city with the highest number of participants : " + most_city);
	}

}
