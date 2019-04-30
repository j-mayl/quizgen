import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParser {
    ArrayList<Question> QuestionList = new ArrayList<>();
    public void getQuestions(String jsonFileName)
        throws FileNotFoundException, IOException, org.json.simple.parser.ParseException {
        String correctAnswer = null;
        String answer = null;
        ArrayList<String> choices = new ArrayList();
        Object obj = new JSONParser().parse(new FileReader(jsonFileName));
        JSONObject jo = (JSONObject) obj;
        JSONArray jsonQuestions = (JSONArray) jo.get("questionArray");
        //Loop through the questions
        for (int i = 0; i < jsonQuestions.size(); i++) {
            JSONObject jsonQuestion = (JSONObject) jsonQuestions.get(i);
            String metadata = (String) jsonQuestion.get("meta-data");
            String  tempquestionText = (String) jsonQuestion.get("questionText");
            String questionText = tempquestionText.replaceAll("\\$","");
            String topic = (String) jsonQuestion.get("topic");
            String imageName = (String) jsonQuestion.get("image");
            JSONArray jsonChoices = (JSONArray) jsonQuestion.get("choiceArray");
            //Loop through the choices
            for (int j = 0; j < jsonChoices.size(); j++) {
                JSONObject jsonChoice = (JSONObject) jsonChoices.get(j);
                String isCorrect = (String) jsonChoice.get("isCorrect");

                if (isCorrect.equals("T")) {
                    String tempAnswer = (String) jsonChoice.get("choice");
                    answer = tempAnswer.replaceAll("\\$", "");
                    String tempCorrect = (String) jsonChoice.get("choice");
                    correctAnswer = tempCorrect.replaceAll("\\$", "");

                }
                else{
                    String tempAnswer = (String) jsonChoice.get("choice");
                    answer = tempAnswer.replaceAll("\\$", "");
                }
                choices.add(answer);
            }
                    Question question =
                        new Question(metadata, questionText, topic, imageName,
                            correctAnswer,choices);
                    QuestionList.add(question);
                    //TODO Quiz.addQuestion();




        }
    }
    public ArrayList<Question> getQuestionList(){
        return this.QuestionList;
    }

}
