package org.example.threedice;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;
import java.util.Random;

public class HelloController {
    /*Game:
    * user clicks button
    * Add dice totals together ex
    * 3 dice
    * two threes
    * one four
    * score is 6 in this case, only keep track of same numbers*/

    //fxml links
    @FXML
    ImageView diceOneImage;
    @FXML
    ImageView diceTwoImage;
    @FXML
    ImageView diceThreeImage;
    @FXML
    Button gambleButton;
    @FXML
    Label scoreRollOneLabel;
    @FXML
    Label scoreNumberLabel;

    int diceOne;
    int diceTwo;
    int diceThree;
    int score;

    Random random = new Random(5);
    int scoreTotal;
    String appendDiceName;

    String appendDiceNameOne;
    String appendDiceNameTwo;
    String appendDiceNameThree;

    String imageName;

    String diceImageOnePath;
    String diceImageTwoPath;
    String diceImageThreePath;


    Image diceImageOne;
    Image diceImageTwo;
    Image diceImageThree;

    //begin methods n stuff
    public void buttonHandler(Event event) throws InterruptedException {
        Button clickedButton = (Button) event.getSource();
        if(gambleButton.equals(clickedButton)) {
            onStartHandler();
        }
    }
    public void onStartHandler() {
        diceOne = random.nextInt(6) + 1;
        switch (diceOne) {
            case 1:
                appendDiceNameOne = "one";
                break;
            case 2:
                appendDiceNameOne = "two";
                break;
            case 3:
                appendDiceNameOne = "three";
                break;
            case 4:
                appendDiceNameOne = "four";
                break;
            case 5:
                appendDiceNameOne = "five";
                break;
            case 6:
                appendDiceNameOne = "six";
                break;
        }

        diceImageOnePath = appendDiceNameOne.concat(".png");
        String imagePath = "/images/".concat(diceImageOnePath);
        diceImageOne = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        diceOneImage.setImage(diceImageOne);

        diceTwo = random.nextInt(6) + 1;
        switch(diceTwo) {
            case 1:
                appendDiceNameTwo = "one";
                break;
            case 2:
                appendDiceNameTwo = "two";
                break;
            case 3:
                appendDiceNameTwo = "three";
                break;
            case 4:
                appendDiceNameTwo = "four";
                break;
            case 5:
                appendDiceNameTwo = "five";
                break;
            case 6:
                appendDiceNameTwo = "six";
                break;
        }

        diceImageTwoPath = appendDiceNameTwo.concat(".png");
        String imageTwoPath = "/images/".concat(diceImageTwoPath);
        diceImageTwo = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imageTwoPath)));
        diceTwoImage.setImage(diceImageTwo);

        diceThree = random.nextInt(6) + 1;
        switch (diceThree) {
            case 1:
                appendDiceNameThree = "one";
                break;
            case 2:
                appendDiceNameThree = "two";
                break;
            case 3:
                appendDiceNameThree = "three";
                break;
            case 4:
                appendDiceNameThree = "four";
                break;
            case 5:
                appendDiceNameThree = "five";
                break;
            case 6:
                appendDiceNameThree = "six";
                break;
        }
        diceImageThreePath = appendDiceNameThree.concat(".png");
        String imageThreePath = "/images/".concat(diceImageThreePath);
        diceImageThree = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imageThreePath)));
        diceThreeImage.setImage(diceImageThree);


        //game logic for one roll
        if (diceOne == diceTwo && diceOne == diceThree) {
            System.out.println(diceOne + " + " + diceTwo + " + " + diceThree + "\n TRIPLE");
            score = diceOne + diceTwo + diceThree;
            scoreNumberLabel.setText(String.valueOf(score));
        } else if (diceOne == diceTwo || diceOne == diceThree) {
            System.out.println(diceOne + " + " + diceTwo + " + " + diceThree);
            if (diceOne == diceThree) {
                System.out.println("SNAKE EYES");
                score = diceOne + diceThree;
                scoreNumberLabel.setText(String.valueOf(score));
            } else {
                System.out.println("SNAKE EYES");
                score = diceOne + diceTwo;
                scoreNumberLabel.setText(String.valueOf(score));
            }
            System.out.println(score);
        } else {
            System.out.println(diceOne + " + " + diceTwo + " + " + diceThree);
            System.out.println("NON MATCH!");
            score = diceOne;
            scoreNumberLabel.setText(String.valueOf(score));
        }

        //set images
        scoreTotal += score;
        scoreRollOneLabel.setText(String.valueOf(scoreTotal));
    }

    /*public String getDiceNumber(int diceNumber) {

        switch (diceNumber) {
            case 1:
                appendDiceName = "one";
                break;
                case 2:
                    appendDiceName = "two";
                    break;
                    case 3:
                        appendDiceName = "three";
                        break;
                        case 4:
                            appendDiceName = "four";
                            break;
                            case 5:
                                appendDiceName = "five";
                                break;
                                case 6:
                                    appendDiceName = "six";
                                    break;
        }
        return null;*/
    }


