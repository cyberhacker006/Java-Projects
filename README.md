# Java-Projects

Project:  Who Wants to Be a Millionaire
The aim of the project is to develop a software application for the "Who Wants to Be a Millionaire" competition. 

General Information
It is a quiz competition with contestants attempting to win a top prize of $1,000,000, by answering a series of five multiple-choice questions with increasing difficulty. 

Competition Start & Input File Initialization
Input File Initialization

The questions are loaded from a text file that has the following format: 
Category#Text#Choice1#Choice2#Choice3#Choice4#CorrectAnswer#Difficulty

An automated spell-checking mechanism will provide by the software. It can check each word in the question text by using the dictionary. The correction of the words will be suggested by the spell-checking mechanism; if there is a letter spelling error, or if two letters are reversed.

After loading the file, the program will give the following information:
- How many questions belong to each category?
- How many questions belong to each difficulty level?

The information about the participants is loaded from a text file that has the following format:
Name#Birthdate#Phone#Address

Start of the Competition

A number of participants are sitting in a particular place to be a contestant. The next contestant is randomly selected among the waiting participants, until the show is over. 
 
A word cloud of topics related to the questions are presented to the contestant. The contestant selects one of the topics. The first and the following questions are determined according to this chosen topic, by considering the question’s difficulty level. The word cloud should not include stop words such as “the”, “as”, “my”, “again”, “at”, “its”, “next”, etc. 

Playing the Competition 

The competition has the following characteristics:

•	Contestants try to correctly answer all the five consecutive multiple-choice questions and win the top prize.
•	The questions are of increasing difficulty, from 1 to 5.
•	There is a 20 second time limit on each question. The timer begins to run as soon as the four answer options are revealed. The contestant has to give a final answer before time runs out. If time rans out, the game ends and the contestant has to leave with the money won up to that point.

•	Each question is set to have a specific money prize; the amounts are not cumulative.
Upon correctly answering questions two and four, contestants are guaranteed to have the amount of prize money associated with that tier level. If at any time the contestant gives a wrong answer, the game is over and the contestant's winnings are reduced to zero for tier-1 questions, €100,000 for tier-2 questions, and $500,000 for tier-3 question.
 
 Question 1 -     $20,000	 tier-one
 Question 2 -    $100,000	
 Question 3 -    $250,000	 tier-two
 Question 4 -    $500,000	
 Question 5 -  $1,000,000	 tier-three

•	The correct answer of each question is revealed only after the contestant answers it.
•	In the case of a correct answer, the contestant’s money in the bank is updated.
•	The program should store all the answers’ history in a text file as:
         (QuestionID, ContestantID, IsAnsweredCorrectly). 

Lifelines

Forms of assistance known as "lifelines" are available for a contestant to use if a question proves difficult. Multiple lifelines may be used on a single question, but each one can only be used once per game. The time taken to use lifelines does not pause the clock. Two lifelines are available from the start of the game.

50%: Two incorrect answers are eliminated, leaving the contestant with a choice between the correct answer and one remaining incorrect answer.

Double Dip: This lifeline allows a contestant to give a second answer, if the first one was wrong. The contestant has to invoke the lifeline before giving the answer. 

Game Over Conditions

The competition of a contestant is over when one of the following happens: 

•	If the contestant correctly answers all the five consecutive multiple-choice questions, the game is over, and he/she has won the top prize.
•	If at any time the contestant gives a wrong answer, the game is over. Contestants giving an incorrect answer see their winnings drop down to the last tier milestone achieved. 
•	The contestant may choose to stop playing after being presented with a question, allowing them to keep all the money they have won up to that point. In other words, choosing to stop allows the contestants to keep their money in the bank. 

The next contestant is randomly selected among the participants until the show is over. At the end of each game, the user is asked if he/she would like to play again.


Statistics

At the end of the show, the software should display the following statistics: 
•	The most successful contestant 
•	The category with the most correctly answered
The category with the most badly answered
•	On average, how many questions did contestants in each age group answer correctly?
Age<=30, 30<Age<= 50, Age>50 
•	The city with the highest number of participants
























