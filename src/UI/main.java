package UI;

import static UI.global.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Connect to database
        database.DBconnect();

        //Initiliaza screens
        screenContainer = new BorderPane();

        mainMenuContainer = new mainMenu().initialize();
        screenContainer.setCenter(mainMenuContainer);
        
        
        gamePlayContainer = new gamePlay().initialize();
        scorePageContainer = new scoreBoard().initialize();

        //Main stage property
        primaryStage.setTitle("Sudoku Game!");
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(700);

        Scene windowScene = new Scene(screenContainer, 1000, 650);
        //Connecting the stylesheet
        windowScene.getStylesheets().add("/stylesheets/mainMenuSceneStyle.css");
        windowScene.getStylesheets().add("/stylesheets/gameSceneStyle.css");
        windowScene.getStylesheets().add("/stylesheets/scoreSceneStyle.css");
        windowScene.getStylesheets().add("/stylesheets/global.css");
        primaryStage.setScene(windowScene);
        primaryStage.show();
    }

    public static void main(String[] args) throws InterruptedException {
        launch(args);
    }
}
