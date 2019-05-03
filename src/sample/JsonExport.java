package sample;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import org.json.simple.parser.JSONParser;


public class JsonExport {

    public JsonExport() {

    }

    public static void exportToJson(String filename, Quiz quiz) {
        ArrayList<Question> questionList = quiz.questionList;
        String isCorrect;
        JSONObject finalQuestionObject = new JSONObject();
        JSONArray questionArray = new JSONArray();
        JSONObject questionDetails = new JSONObject();
        for(int i = 0; i < questionList.size() ; i++) {
            System.out.println("BEEG YOSHI \n");
            String metadata = questionList.get(i).metadata;
            String questionText = questionList.get(i).questionText;
            String topic = questionList.get(i).topic;
            String image = questionList.get(i).imageName;
            String correctAnswer = questionList.get(i).correctAnswer;
            ArrayList<String> answerList = questionList.get(i).allAnswers;
            questionDetails.put("image", image);
            questionDetails.put("topic", topic);
            questionDetails.put("questionText", questionText);
            questionDetails.put("meta-data", metadata);
            JSONArray answerChoicesArray = new JSONArray();
            //Now add the choices to the questionDetails object
            for(int j = 0; j < answerList.size();j++) {

                //Check if the answer is correct and assign the correct json tag
                if (answerList.get(j).equals(correctAnswer)) {
                    isCorrect = "T";
                } else {
                    isCorrect = "F";
                }
                //Add to the answer choice object
                JSONObject answerChoiceObject = new JSONObject();
                answerChoiceObject.put("isCorrect", isCorrect);
                answerChoiceObject.put("choice", answerList.get(j));
                if (!answerChoicesArray.contains(answerChoiceObject)) {
                    answerChoicesArray.add(answerChoiceObject);
                }
                System.out.println("answerChoicesArray Contents: ");
                System.out.println(answerChoicesArray);



                questionDetails.put("choiceArray", answerChoicesArray);
                System.out.println("questionDetails Contents: ");
                System.out.println(questionDetails);
            }
            questionArray.add(questionDetails);
            finalQuestionObject.put("questionArray",questionArray);
        }

        try {
            FileWriter file = new FileWriter(filename + ".json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String prettyJson = gson.toJson(finalQuestionObject);
            file.write(prettyJson);
            file.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}