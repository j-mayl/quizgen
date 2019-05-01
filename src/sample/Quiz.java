package sample;

import java.util.ArrayList;

public class Quiz {

    int questionNum;
    ArrayList<Question> questionList;
    ArrayList<String> topicNames;
    ArrayList<Topic> topicList;
    private int correct = 0;
    private int incorrect = 0;


    Quiz() {
        questionNum = 0;
        questionList = new ArrayList<Question>();
        topicNames = new ArrayList<String>();
        topicList = new ArrayList<Topic>();
    }

    public void addQuestion(Question question) {
        if (question == null)
            return;

        if (!topicNames.contains(question.topic)) {
            topicNames.add(question.topic);
            topicList.add(new Topic(question.topic));
            topicList.get(topicList.size() - 1).addQuestion(question);
            questionNum++;
        } else {
            for (Topic topic : topicList) {
                if (topic.getName().equals(question.topic)) {
                    topic.addQuestion(question);
                    questionNum++;
                    break;
                }
            }
        }
    }

    public void getQuestions(String topicName, int numQuestions) {
        questionList = new ArrayList<Question>();
        if (topicNames.contains(topicName)) {
            for (Topic topic : topicList) {
                if (topicName.equals(topic.getName())) {
                    questionList = topic.getQuestions(numQuestions);
                    //System.out.println();
                }
            }
        } else {
            questionList = new ArrayList<Question>();
        }
    }

    public int getCorrect() {
        return correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public double getPercentage() {
        return ((double)correct / (((double)incorrect + (double)correct)) * 100);
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }
}
