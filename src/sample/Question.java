import java.util.ArrayList;

public class Question{
    //Field for the QuestionNode
    String metadata;
    String questionText;
    String topic;
    String imageName;
    String correctAnswer;
    ArrayList<String> allAnswers;

    public Question(String metadata, String questionText, String topic, String imageName, String correctAnswer, ArrayList<String> allAnswers){
        this.metadata = metadata;
        this.questionText = questionText;
        this.topic = topic;
        this.imageName = imageName;
        this.correctAnswer = correctAnswer;
        this.allAnswers = allAnswers;
    }

    public String getMetadata() {
        return this.metadata;
    }
    public String questionText() {
        return this.questionText;
    }
    public String getTopic() {
        return this.topic;
    }
    public String imageName() {
        return this.imageName;
    }
    public String getCorrectAnswer() {
        return this.correctAnswer;
    }
    public ArrayList<String> getallAnswers() {
        return this.allAnswers;
    }
    }

