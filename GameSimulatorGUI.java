  /*Adetokunbo Owodunni
  CS 401
  2/23/2018
  Assignment 5
  */
  
  import javafx.application.Application;
  import javafx.event.ActionEvent;
  import javafx.scene.layout.*;
  import javafx.scene.input.MouseEvent;
  import javafx.scene.Scene;
  import javafx.scene.control.Button;
  import javafx.scene.control.Label;
  import javafx.scene.control.ChoiceBox;
  import javafx.scene.control.TextField;
  import javafx.scene.control.ListView;
  import javafx.scene.text.*;
  import javafx.scene.image.Image;
  import javafx.stage.Stage;
  import javafx.scene.image.ImageView;
  import javafx.scene.control.RadioButton;
  import javafx.scene.control.ToggleGroup;
  import java.awt.event.*;
  import javafx.event.EventHandler;
  import java.net.*;
  import java.io.*;
  import javax.imageio.ImageIO;
  import javax.swing.*;
  import java.util.*;
  import javafx.geometry.*;
  import javafx.beans.value.ChangeListener;
  import javafx.beans.value.ObservableValue;
 
  public class GameSimulatorGUI extends Application
{
	private Stage stage;
	private BorderPane scenePane;
	private HBox topBox;
	private HBox bottomBox;
	
	private VBox playerBox;
	private VBox enemyBox;
	private VBox numEnemiesBox;
	private VBox numRoundsBox;
	private VBox centerBox;
	
	private Text playerText;
	private Text enemyText;
	private Text optionText;
	private Text titleText;
	
	private Label titleLabel;
	private Label numEnemies;
	private Label numRounds;
	
	private ImageView playerImageView;
	private ImageView playerWeaponImageView;
	private ImageView enemyImageView;
	private ImageView enemyWeaponImageView;
	
	private  ListView<String> playerListView;
	private  ListView<String> enemyListView;
	private  ListView<String> playerWeaponListView;
	private  ListView<String> enemyWeaponListView;
	
	private static final String PALADIN_IMG = "Paladin.png";
	private static final String JACKIE_CHAN_IMG = "JackieChan.png";
	private static final String ROGUE_IMG = "Rogue.png";
	private static final String SKELETON_IMG = "Skeleton.png";
	private static final String GOBLIN_IMG = "Goblin.png";
	private static final String MACE_IMG = "Mace.png";
	private static final String SHORT_SWORD_IMG = "ShortSword.png";
	private static final String LONG_SWORD_IMG = "LongSword.png";
	private static final String AXE_IMG = "Axe.png";
	
	private Button exitButton;
	private Button runSimulator;
	private Button enemyButton;
	private Button playerButton;
	private RadioButton four;
	private RadioButton five;
	private RadioButton six;
	private RadioButton oneR;
	private RadioButton fiveR; 
	private RadioButton tenR;
	private RadioButton twentyR;
	
	private ToggleGroup enemiesGroup;
	private ToggleGroup roundsGroup;
	
	 final int SHORT_SWORD_MIN = 1;
	 final int SHORT_SWORD_MAX = 4;
	 final int LONG_SWORD_MIN = 3;
	 final int LONG_SWORD_MAX = 7;
	 final int MACE_MIN = 2;
	 final int MACE_MAX = 6;
	 final int AXE_MIN = 2;
	 final int AXE_MAX = 6;
     final int ROGUE_INIT_HP = 55;
     final int ROGUE_INIT_STRENGTH = 8;
     final int PALADIN_INIT_HP = 35;
     final int PALADIN_INIT_STRENGTH = 14;
     final int CHAN_INIT_HP = 45;
     final int CHAN_INIT_STRENGTH = 10;
     final int MINION_INIT_HP = 25;
     final int GOBLIN_INIT_STRENGTH = 4;
     final int SKELETON_INIT_STRENGTH = 3;
     
	private boolean checked = false;
	private boolean checked1 = false;
	private boolean buttonChecker = false;
	private boolean buttonChecker1 = false;
	private boolean playerChecker = false;
	private boolean pWeaponChecker = false;
	private boolean enemyChecker = false;
	private boolean eWeaponChecker = false;
	
	
	private String pType = "";
	private String pwType = "";
	private String eType = "";
	private String ewType = "";
	private String enemyName = "";
	private String playerName = "";
	
	private int zeroRuns = 0;
	private int wins = 0;
	private int losses = 0;
	private int totalWins = 0;
	private int totalLosses = 0;
	private int character = 0;
	private int enemy = 0;
	private int enemiesFaced = 0;
	private int enemiesKilled = 0;
    private int playerHP = 0;
    private int playerStrength = 0;
    private int playerDamageMin = 0;
    private int playerDamageMax = 0;
    private int playerDamage;
    private int playerATK;
    private int enemyHP;
    private int enemyStrength = 0; 
    private int enemyDamageMin = 0;
    private int enemyDamageMax = 0;
    private int enemyDamage;
    private int enemyATK;
    private int roundsPlayed = 0;
    private int numOfEnemies = 0;
    

	//initializations and declarations
	
	
	
	
	@Override
	public void start(Stage primaryStage)
	{
		stage = primaryStage;
		stage.setWidth(900);
		stage.setHeight(950);
		stage.setResizable(false);
		//stage
		
		titleText = new Text("Adventure Game Battle Simulator");
		titleText.setFont(new Font(25));
			topBox = new HBox(titleText);
			topBox.setAlignment(Pos.CENTER);
			topBox.setPadding(new Insets(30,30,30,30));
		//top box
			
		playerText = new Text("\t-----PLAYER-----");
		playerText.setFont(new Font(17));
			playerListView = new ListView<String>();
				playerListView.getItems().addAll("Paladin", "Rogue", "Jackie Chan");
			playerWeaponListView = new ListView<String>();
				playerWeaponListView.getItems().addAll("Mace", "Short Sword", "Long Sword", "Axe");
			playerImageView = new ImageView();
				playerImageView.setFitHeight(100);
				playerImageView.setFitWidth(100);
				playerImageView.setTranslateX(75);
			playerWeaponImageView = new ImageView();
				playerWeaponImageView.setFitHeight(100);
				playerWeaponImageView.setFitWidth(100);
				playerWeaponImageView.setTranslateX(75);
			playerButton = new Button("CHOOSE YOUR PLAYER");
			playerButton.setOnAction(e -> choosePlayer());
			playerButton.setTranslateX(64);
			playerBox = new VBox(40, playerText, playerListView, playerImageView, playerWeaponListView, playerWeaponImageView, playerButton); 		
			playerBox.setPadding(new Insets(30,30,30,30));
		//left box
		
		
		optionText = new Text("-----OPTION-----");
		optionText.setFont(new Font(17));
			 four = new RadioButton("4 Enemies");
			 five = new RadioButton("5 Enemies");
			 six = new RadioButton("6 Enemies");
			 oneR = new RadioButton("1 Round");
			 fiveR = new RadioButton("5 Rounds");
			 tenR = new RadioButton("10 Rounds");
			 twentyR = new RadioButton("20 Rounds");
		roundsGroup = new ToggleGroup();
			oneR.setToggleGroup(roundsGroup);
			fiveR.setToggleGroup(roundsGroup);
			tenR.setToggleGroup(roundsGroup);
			twentyR.setToggleGroup(roundsGroup);
		enemiesGroup = new ToggleGroup();
			four.setToggleGroup(enemiesGroup);
			five.setToggleGroup(enemiesGroup);
			six.setToggleGroup(enemiesGroup);
		four.setSelected(true);
		oneR.setSelected(true);
		numRounds = new Label("Number Of Rounds");
		numEnemies = new Label("Number Of Enemies");
		numEnemiesBox = new VBox(20, numEnemies, four, five, six, numRounds, oneR, fiveR, tenR, twentyR);
		centerBox = new VBox(40, optionText, numEnemiesBox);
		centerBox.setPadding(new Insets(0,0,0,110));
		//center box
		
		
		enemyText = new Text("\t-----ENEMY-----");
		enemyText.setFont(new Font(17));
		enemyListView = new ListView<String>();
				enemyListView.getItems().addAll("Skeleton", "Goblin");
			enemyWeaponListView = new ListView<String>();
				enemyWeaponListView.getItems().addAll("Mace", "Short Sword", "Long Sword", "Axe");
			enemyImageView = new ImageView();
				enemyImageView.setFitHeight(100);
				enemyImageView.setFitWidth(100);
				enemyImageView.setTranslateX(75);
			enemyWeaponImageView = new ImageView();
				enemyWeaponImageView.setFitHeight(100);
				enemyWeaponImageView.setFitWidth(100);
				enemyWeaponImageView.setTranslateX(75);
			enemyButton = new Button("CHOOSE YOUR OPPONENT");
			enemyButton.setOnAction(e -> chooseEnemy());
			enemyButton.setTranslateX(65);
			enemyBox = new VBox(40, enemyText, enemyListView, enemyImageView, enemyWeaponListView, enemyWeaponImageView, enemyButton); 		
			enemyBox.setPadding(new Insets(30,30,30,30));
		//right box
		
		
		runSimulator = new Button("RUN SIMULATOR");
		runSimulator.setOnAction(e -> runSim());
		runSimulator.setDisable(true);
			exitButton = new Button("EXIT");
			exitButton.setOnAction(e -> close());
				bottomBox = new HBox(50, runSimulator, exitButton);
				bottomBox.setAlignment(Pos.CENTER);
				bottomBox.setPadding(new Insets(30,30,30,30));
		//bottom box
		
		
		scenePane = new BorderPane();
			Scene scene = new Scene(scenePane, 600, 600);
			primaryStage.setScene(scene);
			primaryStage.show();
		scenePane.setTop(topBox);
		scenePane.setBottom(bottomBox);
		scenePane.setLeft(playerBox);
		scenePane.setRight(enemyBox);
		scenePane.setCenter(centerBox);
		//scene Pane
		
		 playerButton.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent t)
                    {
                        buttonChecker = true;
                        if(playerChecker && pWeaponChecker && enemyChecker && eWeaponChecker && buttonChecker && buttonChecker1)
                            runSimulator.setDisable(false);
                    }
                });
         enemyButton.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent t)
                    {
                        buttonChecker1 = true;
                        if(playerChecker && pWeaponChecker && enemyChecker && eWeaponChecker && buttonChecker && buttonChecker1)
                            runSimulator.setDisable(false);
                    }
                });
		playerListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
                    {
                            playerChecker = true;
                            if(playerChecker && pWeaponChecker && enemyChecker && eWeaponChecker && buttonChecker && buttonChecker1)
                                runSimulator.setDisable(false);
                    }
                });
        playerWeaponListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
                    {
                            pWeaponChecker = true;
                            if(playerChecker && pWeaponChecker && enemyChecker && eWeaponChecker && buttonChecker && buttonChecker1)
                                runSimulator.setDisable(false);
                    }
                });
        enemyListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
                    {
                            enemyChecker = true;
                            if(playerChecker && pWeaponChecker && enemyChecker && eWeaponChecker && buttonChecker && buttonChecker1)
                                runSimulator.setDisable(false);
                    }
                });
        enemyWeaponListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
                    {
                            eWeaponChecker = true;
                            if(playerChecker && pWeaponChecker && enemyChecker && eWeaponChecker && buttonChecker && buttonChecker1)
                                runSimulator.setDisable(false);
                    }
                });        
		runSim();
	}
	public void choosePlayer()
	{
		Image playerImage = null;
		Image playerWeaponImage = null;
		checked = true;
		String pType = playerListView.getSelectionModel().getSelectedItem();
		String pwType = playerWeaponListView.getSelectionModel().getSelectedItem();
		
		if(pType == null && pwType == null)
		{
			MessageBox.show("You must select a player and weapon!", "ERROR");
			return;
		}
		else if(pType == null)
		{
			MessageBox.show("You must select a player!", "ERROR");
			return;
		}
		else if(pwType == null)
		{
			MessageBox.show("You must select a weapon!", "ERROR");
			return;
		}
		
		
		if(pType == "Paladin")
		{
			playerImage = new Image(PALADIN_IMG);
			character = 1;
		}
		else if(pType == "Rogue")
		{
			playerImage = new Image(ROGUE_IMG);
			character = 2;
		}
		else if(pType == "Jackie Chan")
		{
			playerImage = new Image(JACKIE_CHAN_IMG);
			character = 3;
		}
		
		
		if(pwType == "Mace")
		{
			playerWeaponImage = new Image(MACE_IMG);
		}
		else if(pwType == "Short Sword")
		{
			playerWeaponImage = new Image(SHORT_SWORD_IMG);
		}
		else if(pwType == "Long Sword")
		{
			playerWeaponImage = new Image(LONG_SWORD_IMG);
		}
		else if(pwType == "Axe")
		{
			playerWeaponImage = new Image(AXE_IMG);
		}
		
		playerImageView.setImage(playerImage);
		playerWeaponImageView.setImage(playerWeaponImage);
	}
	public void chooseEnemy()
	{
		Image enemyImage = null;
		Image enemyWeaponImage = null;
		checked1 = true;
		String eType = enemyListView.getSelectionModel().getSelectedItem();
		String ewType = enemyWeaponListView.getSelectionModel().getSelectedItem();
		
		if(eType == null && ewType == null)
		{
			MessageBox.show("You must select a player and weapon!", "ERROR");
			return;
		}
		else if(eType == null)
		{
			MessageBox.show("You must select a player!", "ERROR");
			return;
		}
		else if(ewType == null)
		{
			MessageBox.show("You must select a weapon!", "ERROR");
			return;
		}
		
		
		if(eType == "Skeleton")
		{
			enemyImage = new Image(SKELETON_IMG);
			enemy = 1;
		}
		else if(eType == "Goblin")
		{
			enemyImage = new Image(GOBLIN_IMG);
			enemy = 2;
		}
		
		
		if(ewType == "Mace")
		{
			enemyWeaponImage = new Image(MACE_IMG);
		}
		else if(ewType == "Short Sword")
		{
			enemyWeaponImage = new Image(SHORT_SWORD_IMG);
		}
		else if(ewType == "Long Sword")
		{
			enemyWeaponImage = new Image(LONG_SWORD_IMG);
		}
		else if(ewType == "Axe")
		{
			enemyWeaponImage = new Image(AXE_IMG);
		}
		enemyImageView.setImage(enemyImage);
		enemyWeaponImageView.setImage(enemyWeaponImage);
	}
	public void runSim()
	{
	
		Random randomNums = new Random();
		zeroRuns++;
		if(zeroRuns != 1)
		{
			wins = 0;
			totalWins = 0;
			losses = 0;
			totalLosses = 0;
			
			if(four.isSelected())
			enemiesFaced = 4;
			
			else if(five.isSelected())
			enemiesFaced = 5;
			
			else if(six.isSelected())
			enemiesFaced = 6;
			//records enemy challenged
			
			
			if(oneR.isSelected())
			roundsPlayed = 1;
			
			else if(fiveR.isSelected())
			roundsPlayed = 5;
			
			else if(tenR.isSelected())
			roundsPlayed = 10;
			
			else if(twentyR.isSelected())
			roundsPlayed = 20;
			//records rounds played
			
			for(int a=1; a<= roundsPlayed; a++)
			 switch(character)
                {
                        case 1:
                                playerName = "Rogue";
                                playerHP = ROGUE_INIT_HP;
                                playerStrength = ROGUE_INIT_STRENGTH;
                                playerDamageMin = SHORT_SWORD_MIN;
                                playerDamageMax = SHORT_SWORD_MAX;
                                break;
                        case 2:
                                playerName = "Paladin";
                                playerHP = PALADIN_INIT_HP;
                                playerStrength = PALADIN_INIT_STRENGTH;
                                playerDamageMin = LONG_SWORD_MIN;
                                playerDamageMax = LONG_SWORD_MAX;
                                break;
                        case 3:
                                playerName = "Jackie Chan";
                                playerHP = CHAN_INIT_HP;
                                playerStrength = CHAN_INIT_STRENGTH;
                                playerDamageMin = MACE_MIN;
                                playerDamageMax = MACE_MAX;
                                break;
                }
			 switch(enemy)
                {
                        case 1:
                                enemyStrength = GOBLIN_INIT_STRENGTH;
                                enemyDamageMin = AXE_MIN;
                                enemyDamageMax = AXE_MAX;
                                numOfEnemies = enemiesFaced;
                                break;
                        case 2:
                                enemyStrength = SKELETON_INIT_STRENGTH;
                                enemyDamageMin = SHORT_SWORD_MIN;
                                enemyDamageMax = SHORT_SWORD_MAX;
                                numOfEnemies = enemiesFaced;
                                break;
                }

			
                for (int i = 1; i <= numOfEnemies; i++)
                {
                        enemyHP = MINION_INIT_HP;

                        System.out.printf("***%s vs %s %d***\n", playerName, enemyName, i);

                        while(enemyHP > 0 && playerHP > 0)
                        {
                                playerDamage = randomNums.nextInt(playerDamageMax - playerDamageMin + 1) + playerDamageMin;
                                playerATK = playerStrength + playerDamage;
                                enemyHP -= playerATK;
                                //System.out.printf("%s attacks with ATK = %d + %d = %d\n", playerName, playerStrength, playerDamage, playerATK);
                                //System.out.printf("%s HP is now %d - %d = %d\n\n", enemyName, enemyHP + playerATK, playerATK, enemyHP);

                                if (enemyHP <= 0)
                                break;
                                        
                                enemyDamage = randomNums.nextInt(enemyDamageMax - enemyDamageMin + 1) + enemyDamageMin;
                                enemyATK = enemyStrength + enemyDamage;
                                playerHP -= enemyATK;
                                //System.out.printf("%s attacks with ATK = %d + %d = %d\n", enemyName, enemyStrength, enemyDamage, enemyATK);
                                //System.out.printf("%s HP is now %d - %d = %d\n\n", playerName, playerHP + enemyATK, enemyATK, playerHP);
                        } // end of while loop

                        if (playerHP > 0)
                                enemiesKilled++;
                        else
                        {
                            losses++;
                            i = numOfEnemies+1;
                        }
                } // end of for loop
                
                if (playerHP > 0)
                wins++;
                
        }
		MessageBox.show("Enemies: " +enemiesFaced+  "\nRounds: " +roundsPlayed+ "\nBattles Won: " +wins+ "\nBattles Lost: " +losses+ "\nEnemies Killed: " +enemiesKilled, "RESULTS");
		enemiesKilled = 0;3
	}
	public static void main(String []args)
	{
		Application.launch(args);
	}
	public void close()
	{
		stage.close();
	}
	
}