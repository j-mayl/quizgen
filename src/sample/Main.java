package sample;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

public class Main extends Application {

    static Quiz quiz;

    @Override public void start(Stage primaryStage) throws Exception {

        // ---------------------------------------------------------- MAIN SCREEN
        // -------------------------------------
        Label titleLabel = new Label("Quiz Generator");
        titleLabel.setFont(Font.font("Denmark", 30));
        Button startButton = new Button("Start Quiz");
        startButton.setFont(Font.font("Denmark", 15));
        Button newQuestionButton = new Button("Add Question");
        newQuestionButton.setFont(Font.font("Denmark", 15));
        Button importButton = new Button("Import Questions");
        importButton.setFont(Font.font("Denmark", 15));
        Button exportButton = new Button("Export Questions");
        exportButton.setFont(Font.font("Denmark", 15));
        Button quitButton = new Button("Quit");
        quitButton.setFont(Font.font("Denmark", 15));

        // --------------------------------------------------------- ADD QUESTION
        // -------------------------------------
        Label addQuestionTitle = new Label("Add Question");
        addQuestionTitle.setFont(Font.font("Denmark", 30));
        Label questionPrompt = new Label("Enter Question: ");
        questionPrompt.setFont(Font.font("Denmark", 15));
        Label topicPrompt = new Label("Enter Topic: ");
        topicPrompt.setFont(Font.font("Denmark", 15));
        Label answer1 = new Label("Enter Correct Answer: ");
        answer1.setFont(Font.font("Denmark", 15));
        answer1.setTextFill(Paint.valueOf("Green"));
        Label answer2 = new Label("Enter Alternative Answer: ");
        answer2.setFont(Font.font("Denmark", 15));
        answer2.setTextFill(Paint.valueOf("Red"));
        Label answer3 = new Label("Enter Alternative Answer: ");
        answer3.setFont(Font.font("Denmark", 15));
        answer3.setTextFill(Paint.valueOf("Red"));
        Label answer4 = new Label("Enter Alternative Answer: ");
        answer4.setFont(Font.font("Denmark", 15));
        answer4.setTextFill(Paint.valueOf("Red"));
        Label answer5 = new Label("Enter Alternative Answer: ");
        answer5.setFont(Font.font("Denmark", 15));
        answer5.setTextFill(Paint.valueOf("Red"));
        Label questionImage = new Label("Image path: ");
        questionImage.setFont(Font.font("Denmark", 15));
        Label totalNumberOfQuestions = new Label("Number of questions loaded: " + 0);
        totalNumberOfQuestions.setAlignment(Pos.CENTER_LEFT);
        totalNumberOfQuestions.setFont(Font.font("Denmark", 15));
        Label totalNumberOfTopics = new Label("Number of different topics: " + 0);
        totalNumberOfTopics.setAlignment(Pos.CENTER_LEFT);
        totalNumberOfTopics.setFont(Font.font("Denmark", 15));

        Button back = new Button("Back");
        Button addQuestion = new Button("Add Question");

        TextField newQuestion = new TextField();
        TextField newTopic = new TextField();

        TextField a1 = new TextField();
        TextField a2 = new TextField();
        TextField a3 = new TextField();
        TextField a4 = new TextField();
        TextField a5 = new TextField();
        TextField imagePath = new TextField();

        HBox hb2 = new HBox(10);
        hb2.setAlignment(Pos.CENTER);
        hb2.getChildren().addAll(questionPrompt, newQuestion);
        HBox hb3 = new HBox(10);
        hb3.getChildren().addAll(topicPrompt, newTopic);
        hb3.setAlignment(Pos.CENTER);
        HBox hb4 = new HBox(10);
        hb4.getChildren().addAll(answer1, a1);
        hb4.setAlignment(Pos.CENTER);
        HBox hb5 = new HBox(10);
        hb5.getChildren().addAll(answer2, a2);
        hb5.setAlignment(Pos.CENTER);
        HBox hb6 = new HBox(10);
        hb6.getChildren().addAll(answer3, a3);
        hb6.setAlignment(Pos.CENTER);
        HBox hb7 = new HBox(10);
        hb7.getChildren().addAll(answer4, a4);
        hb7.setAlignment(Pos.CENTER);
        HBox hb8 = new HBox(10);
        hb8.getChildren().addAll(answer5, a5);
        hb8.setAlignment(Pos.CENTER);
        HBox hb9 = new HBox(10);
        hb9.getChildren().addAll(questionImage, imagePath);
        hb9.setAlignment(Pos.CENTER);
        HBox hb10 = new HBox(10);
        hb10.getChildren().addAll(back, addQuestion);
        hb10.setAlignment(Pos.CENTER);
        HBox hb11 = new HBox(10);
        hb11.getChildren().addAll(totalNumberOfQuestions, totalNumberOfTopics);
        hb11.setAlignment(Pos.BASELINE_CENTER);

        // ------------------------------------------------------------------------ QUIT SCREEN
        // -----------------------
        Label goodByeMessage = new Label("Thanks for playing :)");
        goodByeMessage.setFont(Font.font("Denmark", 30));
        goodByeMessage.setAlignment(Pos.TOP_CENTER);
        Button quit = new Button("Quit");
        quit.setFont(Font.font("Denmark", 15));
        quit.setAlignment(Pos.CENTER);
        Button saveAndQuit = new Button("Save and quit");
        saveAndQuit.setFont(Font.font("Denmark", 15));
        saveAndQuit.setAlignment(Pos.CENTER);
        Button backToMain = new Button("Back");
        backToMain.setFont(Font.font("Denmark", 15));
        backToMain.setAlignment(Pos.CENTER);

        // ------------------------------------------------------------------------ START QUIZ SCREEN
        // -----------------
        Label startQuiz = new Label("Start Quiz");
        startQuiz.setFont(Font.font("Denmark", 30));
        startQuiz.setAlignment(Pos.TOP_CENTER);
        Label topicLabel = new Label("Select Topic: ");
        topicLabel.setFont(Font.font("Denmark", 15));
        Label desiredNumQuestions = new Label("Number of questions: ");
        desiredNumQuestions.setFont(Font.font("Denmark", 15));
        Button backToMain2 = new Button("Back");
        backToMain2.setFont(Font.font("Denmark", 15));
        Button startQuizBtn = new Button("Start");
        startQuizBtn.setFont(Font.font("Denmark", 15));
        TextField numQuestions = new TextField();
        numQuestions.setFont(Font.font("Denmark", 15));

        ObservableList<String> options =
            FXCollections.observableArrayList("Math", "Science", "Smash Ultimate");
        ComboBox<String> topicBox = new ComboBox<String>(options);
        HBox hbsq1 = new HBox(10);
        HBox hbsq2 = new HBox(10);
        HBox hbsq3 = new HBox(10);
        hbsq1.getChildren().addAll(topicLabel, topicBox);
        hbsq1.setAlignment(Pos.CENTER);
        hbsq2.getChildren().addAll(desiredNumQuestions, numQuestions);
        hbsq2.setAlignment(Pos.CENTER);
        hbsq3.getChildren().addAll(backToMain2, startQuizBtn);
        hbsq3.setAlignment(Pos.CENTER);

        // ------------------------------------------------------------------------- Question Screen
        // -----------------
        Label questionNum = new Label("Question Number: " + 1);
        questionNum.setFont(Font.font("Denmark", 30));
        Label currentTopic = new Label("Topic: " + "Topic here");
        currentTopic.setFont(Font.font("Denmark", 15));
        Label questionLabel = new Label("Question: " + "What is the BEST CS class?");
        questionLabel.setFont(Font.font("Denmark", 15));

        Label answerList = new Label("Answers: ");
        answerList.setFont(Font.font("Denmark", 15));

        ObservableList<String> answers = FXCollections
            .observableArrayList("Answer 1", "Answer 2", "Answer 3", "Answer 4", "Answer 5");

        ComboBox<String> answersBox = new ComboBox<String>(answers);

        Button nextQuestion = new Button("Next");
        nextQuestion.setFont(Font.font("Denmark", 15));

        Image image =
            new Image("https://static.thisisinsider.com/image/5c59e77ceb3ce80d46564023.jpg");
        ImageView viewImage = new ImageView(image);
        viewImage.setPreserveRatio(true);
        viewImage.setFitHeight(150);

        HBox answerSelect = new HBox(10);
        answerSelect.getChildren().addAll(answerList, answersBox);
        answerSelect.setAlignment(Pos.CENTER);

        // --------------------------------------------------------------- IMPORT SCREEN ----------
        Label importQuestions = new Label("Import Questions");
        importQuestions.setFont(Font.font("Denmark", 30));
        Label enterFileName = new Label("Enter filename: ");
        enterFileName.setFont(Font.font("Denmark", 15));
        TextField fileNameHere = new TextField();
        Button backToMain3 = new Button("Back");
        backToMain3.setFont(Font.font("Denmark", 15));
        Button submitImport = new Button("Submit");
        submitImport.setFont(Font.font("Denmark", 15));
        HBox importBox1 = new HBox(10);
        importBox1.getChildren().addAll(enterFileName, fileNameHere);
        importBox1.setAlignment(Pos.CENTER);
        HBox importBox2 = new HBox(10);
        importBox2.getChildren().addAll(backToMain3, submitImport);
        importBox2.setAlignment(Pos.CENTER);



        // ------------------------------------------------------------------------- SCENES
        // ---------------------------
        // main screen is a vbox
        VBox mainVbox = new VBox();
        mainVbox.getChildren()
            .addAll(titleLabel, startButton, newQuestionButton, importButton, exportButton,
                quitButton);
        mainVbox.setAlignment(Pos.TOP_CENTER);
        mainVbox.setSpacing(10);

        // add question is a vbox holding hboxes
        VBox addQuestionVbox = new VBox();
        addQuestionVbox.getChildren()
            .addAll(addQuestionTitle, hb2, hb3, hb4, hb5, hb6, hb7, hb8, hb9, hb10, hb11);
        addQuestionVbox.setAlignment(Pos.TOP_CENTER);
        addQuestionVbox.setSpacing(10);

        // quit screen is a vbox
        VBox quitScreen = new VBox(10, goodByeMessage, quit, saveAndQuit, backToMain);
        quitScreen.setAlignment(Pos.TOP_CENTER);

        // start game screen is a vbox
        VBox startScreen = new VBox(10, startQuiz, hbsq2, hbsq1, hbsq3);
        startScreen.setAlignment(Pos.TOP_CENTER);

        // current question is a vbox of hbox
        VBox currQuestion =
            new VBox(10, questionNum, viewImage, questionLabel, currentTopic, answerSelect,
                nextQuestion);
        currQuestion.setAlignment(Pos.TOP_CENTER);

        // import questions is a vbox of hbox
        VBox importScreen = new VBox(10, importQuestions, importBox1, importBox2);
        importScreen.setAlignment(Pos.TOP_CENTER);

        // ----------------------------------------------------------------------------- CREATING SCENES
        // --------------
        // Creating a scene object
        Scene mainPage = new Scene(mainVbox, 300, 275);
        Scene addQuestionPage = new Scene(addQuestionVbox, 450, 400);
        Scene quitPage = new Scene(quitScreen, 300, 190);
        Scene startPage = new Scene(startScreen, 375, 175);
        Scene quizPage = new Scene(currQuestion, 450, 340);
        Scene importPage = new Scene(importScreen, 300, 120);

        // ----------------------------------------------------------------------------- STAGE STUFF
        // ------------------
        primaryStage.setTitle("Quiz Generator");
        primaryStage.setScene(mainPage);
        primaryStage.show();

        // ------------------------------------------------------------------------------ BUTTON ACTIONS
        // --------------
        // main screen actions
        importButton.setOnAction(event -> primaryStage.setScene(importPage));
        backToMain3.setOnAction(event -> primaryStage.setScene(mainPage));
        submitImport.setOnAction(event -> {
            try {
                JsonParser jsonParser = new JsonParser();
                String filename = fileNameHere.getText();
                System.out.println(filename);
                jsonParser.getQuestions(filename, quiz);
                primaryStage.setScene(mainPage);
            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (FileNotFoundException e1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Sorry your file could not be found");
                alert.setContentText("I can't believe you've done this");
                alert.showAndWait();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        newQuestionButton.setOnAction(event -> {
            totalNumberOfQuestions.setText("Number of questions loaded: " + quiz.questionNum);
            totalNumberOfTopics.setText("Number of different topics: " + quiz.topicList.size());
            primaryStage.setScene(addQuestionPage);
        });

        // start quiz actions
        startButton.setOnAction(event -> {
            ObservableList<String> tempOptions = FXCollections.observableArrayList(quiz.topicNames);
            topicBox.setItems(tempOptions);
            ;
            primaryStage.setScene(startPage);
        });

        startQuizBtn.setOnAction(event -> {
            boolean success = true;
            int number = 0;

            try {
                number = Integer.parseInt(numQuestions.getText());
                if (number < 1) {
                    numQuestions.setText("");
                    numQuestions.setPromptText("Enter a number > 1");
                    success = false;
                }
            } catch (NumberFormatException e) {
                numQuestions.setText("");
                numQuestions.setPromptText("Enter a valid response");
                success = false;
            }

            String topic = topicBox.getValue();
            if (topic == null || topic.equals("")) {
                topicBox.setPromptText("Choose a valid response");
                success = false;
            }

            if (success) {
                quiz.getQuestions(topic, number);
                transitionToNextQuestion(currentTopic, questionLabel, answersBox, viewImage);
                primaryStage.setScene(quizPage);
            }
        });

        nextQuestion.setOnAction(event -> {
            if (quiz.questionList.get(0).correctAnswer.equals(answersBox.getValue().toString())) {
                quiz.questionList.remove(0);
                if (quiz.questionList.size() == 0) {
                    primaryStage.setScene(mainPage);
                } else {
                    transitionToNextQuestion(currentTopic, questionLabel, answersBox, viewImage);
                }
            } else {
                answersBox.setValue("Try Again");
            }
        });

        // add question actions
        back.setOnAction(event -> primaryStage.setScene(mainPage));
        backToMain.setOnAction(event -> primaryStage.setScene(mainPage));
        quitButton.setOnAction(event -> primaryStage.setScene(quitPage));
        quit.setOnAction(event -> primaryStage.close());
        backToMain2.setOnAction(event -> primaryStage.setScene(mainPage));



        addQuestion.setOnAction(event -> {
            boolean success = true;

            success = (checkTextField(newQuestion)) ? success : false;
            success = (checkTextField(newTopic)) ? success : false;
            success = (checkTextField(a1)) ? success : false;
            success = (checkTextField(a2)) ? success : false;
            success = (checkTextField(a3)) ? success : false;
            success = (checkTextField(a4)) ? success : false;
            success = (checkTextField(a5)) ? success : false;
            success = (checkTextField(imagePath)) ? success : false;

            if (success) {
                ArrayList<String> allAnswers = new ArrayList<String>();
                allAnswers.add(a1.getText());
                allAnswers.add(a2.getText());
                allAnswers.add(a3.getText());
                allAnswers.add(a4.getText());
                allAnswers.add(a5.getText());

                Question question =
                    new Question("", newQuestion.getText(), newTopic.getText(), imagePath.getText(),
                        a1.getText(), allAnswers);
                quiz.addQuestion(question);
            }

            totalNumberOfQuestions.setText("Number of questions loaded: " + quiz.questionNum);
            totalNumberOfTopics.setText("Number of different topics: " + quiz.topicList.size());
        });
    }

    private boolean checkTextField(TextField textField) {
        if (textField.getText() == null || textField.getText().equals("")) {
            textField.setPromptText("Enter a valid response");
            return false;
        }
        return true;
    }

    private void transitionToNextQuestion(Label topicLabel, Label questionLabel,
        ComboBox<String> answersBox, ImageView viewImage) {
        Question question = quiz.questionList.get(0);
        topicLabel.setText("Current topic: " + question.topic);
        questionLabel.setText("Question: " + question.questionText);

        ObservableList<String> answers = FXCollections.observableArrayList(question.allAnswers);
        answersBox.setItems(answers);
        answersBox.setValue("");

        try {
            Image image = new Image(question.imageName);
            viewImage.setImage(image);
        } catch (IllegalArgumentException e) {
            viewImage.setImage(null);
        }
    }

    public static void main(String[] args) {
        quiz = new Quiz();
        launch(args);
    }
}
