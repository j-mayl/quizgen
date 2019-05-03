package sample;
import java.util.ArrayList;

public interface TopicInterface {
    /**
     * Gets a number of questions to add to the quiz, if the passed in number
     * is less than the number of questions in the topic, then they are chosen randomly
     * @param numQuestions the number of questions
     * @return list of chosen questions
     */
    public ArrayList<Question> getQuestions (int numQuestions);

    /**
     * Adds a question to this current topic
     * @param question the question
     */
    public void addQuestion(Question question);
}

