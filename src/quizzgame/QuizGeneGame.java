package quizzgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class QuizGeneGame
{

	private static HashMap<String, quiz> quizzes = new HashMap<>();//storing quizzes by their topic
	private static Scanner sc=new Scanner(System.in);//to give the i/p from user
	
	//start the execution of program
	public static void main(String []args)
	{
		System.out.println("WELCOME TO QUIZGENERATOR GAME");
	    
		while(true)
		{
			System.out.println("choose the below options to generate a quiz");
			System.out.println("1.Create quiz");
			System.out.println("2.Add questions");
			System.out.println("3.Take quiz");
			System.out.println("4.Exit quiz");
			
			System.out.println("Choose the above option:");
			int choose=sc.nextInt();
			sc.nextLine();
			switch(choose)
			{
			case 1:
			{
				createQuiz();
				break;
			}
			case 2:
			{
				addQuestions();
				break;
			}
			case 3:
			{
				takeQuiz();
				break;
			}
			case 4:
			{
				System.out.println("Exit...");
				return;
			}
			default:
				System.out.println("Your choose in incorrect.Please Check it and Try Again");
			}
		}
	}
	//create a new quiz
	public static void createQuiz()
	{
		System.out.println("please Enter the quiz topic");
		String topic=sc.nextLine();
		quizzes.put(topic,new quiz(topic));//new created topic as key and stored in hashmap
		System.out.println("Quiz created the topic is "+ topic);
	}
	
	//add the questions on that created quiz topic
	private static void addQuestions() {
        System.out.print("Enter quiz topic to add question: ");
        String topic = sc.nextLine();

        if (!quizzes.containsKey(topic)) {
            System.out.println("Quiz on this topic does not exist.");
            return;
        }

        System.out.print("Enter question text: ");
        String questionText = sc.nextLine();

        List<String> options = new ArrayList<>();
        for (char option = 'A'; option <= 'D'; option++) {
            System.out.print("Enter option " + option + ": ");
            options.add(sc.nextLine());
        }

        System.out.print("Enter correct answer (A/B/C/D): ");
        char correctAnswerChar = sc.next().charAt(0);
        int correctAnswer = correctAnswerChar - 'A';

        question question = new question(questionText, options, correctAnswer);
        quizzes.get(topic).addQuestions(question);
        System.out.println("Question added to quiz on " + topic);
    }
  //take a quiz on specified topic
    private static void takeQuiz() {
        System.out.print("Enter quiz topic to take: ");
        String topic = sc.nextLine();

        if (!quizzes.containsKey(topic)) {
            System.out.println("Quiz on this topic does not exist.");
            return;
        }

        quizzes.get(topic).quiz1();
    }
}

