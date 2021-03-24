package exercise21_11;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/*
 * Author: Jason Snow
 * Date: 03/24/2021
 * 
 * This program was edited to enable the user to enter a year, a gender, and a name and find the ranking of that name
 * for that name in the selected in the selected year among baby names.
 */
public class Exercise21_11 extends Application {
  private NameStore names = new NameStore();
  private String display = "";
  
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    for (int year = 2001; year <= 2010; year++) {
      cboYear.getItems().add(year);
    }
    cboYear.setValue(2001);
        
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");
    
    btFindRanking.setOnAction(e -> {
    	if (cboGender.getValue().equalsIgnoreCase("Male")) {
    		if (names.getBoyPlace((int)cboYear.getValue(), tfName.getText()) == null) {
    			lblResult.setText("Name not found in top 1000 boy names of " + (int)cboYear.getValue());
    		}
    		else lblResult.setText("Boy name " + tfName.getText() + " was ranked #" + names.getBoyPlace((int)cboYear.getValue(), tfName.getText()) + " in year " + (int)cboYear.getValue());
    		 
    	}
    	else {
    		if (names.getGirlPlace((int)cboYear.getValue(), tfName.getText()) == null) {
    			lblResult.setText("Name not found in top 1000 girl names of " + (int)cboYear.getValue());
    		}
    		else lblResult.setText("Girl name " + tfName.getText() + " was ranked #" + names.getGirlPlace((int)cboYear.getValue(), tfName.getText()) + " in year " + (int)cboYear.getValue());
    	}
    });
    
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}


class NameStore {
	public ArrayList<Map> boys = new ArrayList<>(10);
	public ArrayList<Map> girls = new ArrayList<>(10);
	
	NameStore() {
		compile();
	}
	
	private void compile() {
		try {
			for (int i = 1; i < 11; i++) {
				String urlString = "http://liveexample.pearsoncmg.com/data/babynamesranking200" + i + ".txt";
				if (i >= 10) urlString = "http://liveexample.pearsoncmg.com/data/babynamesranking20" + i + ".txt";
				URL url = new URL(urlString);
				Scanner input = new Scanner(url.openStream());
				
				Map<String, String> boyMap = new LinkedHashMap();
				Map<String, String> girlMap = new LinkedHashMap();
				
				while (input.hasNext()) {
					String string = input.nextLine();
					String[] words = string.split("[\\s+\\p{P}]");
					boyMap.put(words[2], words[0]);
					girlMap.put(words[5], words[0]);	
				}
				boys.add(boyMap);
				girls.add(girlMap);
			}
			
		}
		catch (MalformedURLException ex) {
			System.out.println("Invalid URL");
		}
		catch (java.io.IOException ex) {
			System.out.println("I/O Errors: no such file");
		}
	}
	public String getBoyPlace(int year, String name) {
		year -= 2001;
		return (String)boys.get(year).get(name);
	}
	public String getGirlPlace(int year, String name) {
		year -= 2001;
		return (String)girls.get(year).get(name);
	}
		

}
