package quizzgame;

import java.util.List;

public class question
{
  String text;//text of the question
  List<String> options;//list of multiple choice options
  int correctanswer;//index of the correct answer in the option list
  
  //initialize the above value
  public question(String text, List<String> options, int correctanswer) {
	super();
	this.text = text;
	this.options = options;
	this.correctanswer = correctanswer;
}
  
  
}
