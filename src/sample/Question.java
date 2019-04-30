import java.util.ArrayList;

public class Question{
    //Field for the QuestionNode
    String metadata;
    String questionText;
    String topic;
    String imageName;
    String correctAnswer;
    ArrayList<String> otherAnswers;

    public Question(String metadata, String questionText, String topic, String imageName, String correctAnswer){
        this.metadata = metadata;
        this.questionText = questionText;
        this.topic = topic;
        this.imageName = imageName;
        this.correctAnswer = correctAnswer;
    }
    public void addAnswerChoice(String answerChoice){
        otherAnswers.add(answerChoice);
    }


}
