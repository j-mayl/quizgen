package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

 static Quiz quiz;

  @Override
  public void start(Stage primaryStage) throws Exception {

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
    Button startGame = new Button("Start");
    startGame.setFont(Font.font("Denmark", 15));
    TextField numQuestions = new TextField();
    numQuestions.setFont(Font.font("Denmark", 15));

    ObservableList<String> options =
        FXCollections.observableArrayList("Math", "Science", "Smash Ultimate");
    ComboBox topicBox = new ComboBox(options);
    HBox hbsq1 = new HBox(10);
    HBox hbsq2 = new HBox(10);
    HBox hbsq3 = new HBox(10);
    hbsq1.getChildren().addAll(topicLabel, topicBox);
    hbsq1.setAlignment(Pos.CENTER);
    hbsq2.getChildren().addAll(desiredNumQuestions, numQuestions);
    hbsq2.setAlignment(Pos.CENTER);
    hbsq3.getChildren().addAll(backToMain2, startGame);
    hbsq3.setAlignment(Pos.CENTER);

    // ------------------------------------------------------------------------- SCENES
    // ---------------------------
    // main screen is a vbox
    VBox mainVbox = new VBox();
    mainVbox.getChildren().addAll(titleLabel, startButton, newQuestionButton, importButton,
        exportButton, quitButton);
    mainVbox.setAlignment(Pos.TOP_CENTER);
    mainVbox.setSpacing(10);

    // add question is a vbox holding hboxes
    VBox addQuestionVbox = new VBox();
    addQuestionVbox.getChildren().addAll(addQuestionTitle, hb2, hb3, hb4, hb5, hb6, hb7, hb8, hb9,
        hb10, hb11);
    addQuestionVbox.setAlignment(Pos.TOP_CENTER);
    addQuestionVbox.setSpacing(10);

    // quit screen is a vbox
    VBox quitScreen = new VBox(10, goodByeMessage, quit, saveAndQuit, backToMain);
    quitScreen.setAlignment(Pos.TOP_CENTER);

    // start game screen is a vbox
    VBox startScreen = new VBox(10, startQuiz, hbsq2, hbsq1, hbsq3);
    startScreen.setAlignment(Pos.TOP_CENTER);

    // ----------------------------------------------------------------------------- CREATING SCENES
    // --------------
    // Creating a scene object
    Scene mainPage = new Scene(mainVbox, 300, 275);
    Scene addQuestionPage = new Scene(addQuestionVbox, 450, 400);
    Scene quitPage = new Scene(quitScreen, 300, 190);
    Scene startPage = new Scene(startScreen, 375, 175);

    // ----------------------------------------------------------------------------- STAGE STUFF
    // ------------------
    primaryStage.setTitle("Quiz Generator");
    primaryStage.setScene(mainPage);
    primaryStage.show();

    // ------------------------------------------------------------------------------ BUTTON ACTIONS
    // --------------
    // main screen actions
    newQuestionButton.setOnAction(event -> primaryStage.setScene(addQuestionPage));

    // add question actions
    back.setOnAction(event -> primaryStage.setScene(mainPage));
    backToMain.setOnAction(event -> primaryStage.setScene(mainPage));
    quitButton.setOnAction(event -> primaryStage.setScene(quitPage));
    quit.setOnAction(event -> primaryStage.close());
    startButton.setOnAction(event -> primaryStage.setScene(startPage));
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
        Question question = new Question("", newQuestion.getText(), newTopic.getText(),
            imagePath.getText(), a1.getText());
        question.addAnswerChoice(a2.getText());
        question.addAnswerChoice(a3.getText());
        question.addAnswerChoice(a4.getText());
        question.addAnswerChoice(a5.getText());
        quiz.addQuestion(question);
      }
      
      totalNumberOfQuestions.setText("Number of questions loaded: " + quiz.questionNum);
      totalNumberOfTopics.setText("Number of different topics: " + quiz.topicList.size());
    });


  }

  private boolean checkTextField(TextField textField) {
    if (textField.getText() == null || textField.getText().equals("")) {
      textField.setPromptText("Please enter a response");
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    quiz = new Quiz();
    launch(args);
  }
}
