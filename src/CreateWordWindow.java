import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateWordWindow extends Application {

    Stage primaryStage;
    Scene mainScene;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        VBox mainBox = new VBox();
        mainBox.setPadding(new Insets(10,10,10,10));
        mainBox.setSpacing(13);

        Text mainText = new Text("find word online");//"Create New Word");
        mainText.setFont((new FontFetcher()).getFont(40));

        TextField word = new TextField("enter word here");
        String wordString;

        Button submitWord = new Button("Get Word");
        submitWord.setOnAction(e -> fetchDefinition(word.getText()));

        Button backToMainMenu= new Button("Back");
        backToMainMenu.setOnAction(e-> returnToMainMenu());

        mainBox.getChildren().addAll(mainText,word, submitWord,backToMainMenu);

        mainScene = new Scene(mainBox);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Kelly's Word Bank");
        primaryStage.show();
    }

    private void returnToMainMenu() {
        Stage newStage = new Stage();
        MenuWindow menuWindow = new MenuWindow();
        menuWindow.start(newStage);
        primaryStage.close();

    }

    private void fetchDefinition(String word){
//        System.out.println(word);
//        DefinitionFetcher df = new DefinitionFetcher(word);
//        try {
//            df.fetch();
//        } catch (IOException e) {
//            System.out.println("definition/word not found.");
//        }

        DefinitionDisplayWindow defw = new DefinitionDisplayWindow(word);

    }
}
