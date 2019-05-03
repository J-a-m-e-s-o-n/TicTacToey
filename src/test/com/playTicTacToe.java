package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.ticTacToeHomePage;

public class playTicTacToe {

    public static void main(String[] args) throws InterruptedException {
        String TARGET_URL ="https://playtictactoe.org/";
        boolean gameStillOn = true;
        int movesTaken = 0;
        String[] board = ticTacToeHomePage.populateBoardPositions();
        int[] randomBoardPositions = ticTacToeHomePage.getArrayOfRandomIndexes(board.length + 1);

        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TARGET_URL);

        while(gameStillOn != false){
            ticTacToeHomePage.assertSpaceEmptyAndClick(driver, board[randomBoardPositions[movesTaken]]);
            movesTaken++;
            Thread.sleep(300);
            if(movesTaken >= 3){
                Thread.sleep(700);
                gameStillOn = ticTacToeHomePage.checkIfPlayerHasWon(driver);
            }
        }
        //driver.quit();
    }

}
