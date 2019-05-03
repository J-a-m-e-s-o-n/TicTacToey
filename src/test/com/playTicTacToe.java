package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.ticTacToeHomePage;

import java.util.Random;


public class playTicTacToe {

    private static int[] getRandomNumberInRange(int length) {
        Random random = new Random();
        int rIndex;
        int rValue;
        int[] nums = new int[length-1];
        for (int i = 0; i < nums.length; ++i) { nums[i] = i; }
        for(int i = 0; i < nums.length; ++i)
        {
            rIndex = random.nextInt(nums.length);
            rValue = nums[rIndex];
            nums[rIndex] = nums[i];
            nums[i] = rValue;
        }
        return nums;
    }

    private static int getRandomNumberInRangeRandomly() {
        Random random = new Random();
        return random.nextInt((8 - 0) + 1);
    }

    public static void main(String[] args) throws InterruptedException {
        String TARGET_URL ="https://playtictactoe.org/";
        boolean gameStillOn = true;
        int movesTaken = 0;
        String[] board = ticTacToeHomePage.populateBoardPositions();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TARGET_URL);

        while(gameStillOn != false){
            System.out.println("Testing - Random number selected: " + getRandomNumberInRangeRandomly() + " Moves Taken: " + movesTaken);
            ticTacToeHomePage.assertSpaceEmptyAndClick(driver, board[getRandomNumberInRangeRandomly()]);
            movesTaken++;
            //Thread.sleep(300);
            if(movesTaken >= 3){
                Thread.sleep(700);
                gameStillOn = ticTacToeHomePage.checkIfPlayerHasWon(driver);
            }
        }

        //driver.quit();
    }

}
