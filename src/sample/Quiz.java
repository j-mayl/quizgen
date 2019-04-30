package application;

import java.util.ArrayList;

public class Quiz {

  int questionNum;
  ArrayList<String> topicNames;
  ArrayList<Topic> topicList;

  Quiz() {
    questionNum = 0;
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
}
