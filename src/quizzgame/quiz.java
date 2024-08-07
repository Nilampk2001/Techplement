package quizzgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class quiz 
{
    String qtopic;//topic of quiz
    List<question> questions;//list of question in the quiz
	
    public quiz(String qtopic) {
		this.qtopic = qtopic;
		this.questions = new ArrayList<>();
	}
    
    //add question to the quiz
    public void addQuestions(question que)
    {
    	questions.add(que);
    }
    
    //to give the permission to the user to take the quiz
    public void quiz1()
    {
       Scanner sc=new Scanner(System.in);
       int quizscore=0;
       
       for(int i=0;i<questions.size();i++)
       {
    	   question que=questions.get(i);
    	   System.out.println((i+1)+" = "+ que.text);
    	   
    	   for(int j=0;j<que.options.size();j++)
    	   {
    		   System.out.println((char)('A'+j)+";"+que.options.get(j));
    	   }
    	   
    	   System.out.println("Your Answer is..");
    	   char uanswer=sc.next().charAt(0);
    	   int aindex=uanswer - 'A';
    	   
    	   if(aindex==que.correctanswer)
    	   {
    		   quizscore++;
    		   System.out.println("Your Answer is Correct......");
    	   }
    	   else
    	   {
    		   System.out.println("Your Answer is Incorrect..The correct one is"+(char)('A'+que.correctanswer)+":"+que.options.get(que.correctanswer));
    	   }
       }
       
       System.out.println("Your Quiz is Completed.Your Score is:"+quizscore+"/"+questions.size());
    }
}
