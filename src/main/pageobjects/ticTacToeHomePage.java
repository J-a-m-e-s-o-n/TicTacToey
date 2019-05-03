package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class ticTacToeHomePage {

    public static String[] populateBoardPositions(){
        String topLeft = ".board >div:nth-child(1)";
        String topCenter = ".board >div:nth-child(2)";
        String topRight = ".board >div:nth-child(3)";
        String middleLeft = ".board >div:nth-child(4)";
        String middleCenter = ".board >div:nth-child(5)";
        String middleRight = ".board >div:nth-child(6)";
        String bottomLeft = ".board >div:nth-child(7)";
        String bottomCenter = ".board >div:nth-child(8)";
        String bottomRight = ".board >div:nth-child(9)";
        String[] boardPositions = {topLeft, topCenter, topRight, middleLeft, middleCenter,
                middleRight, bottomLeft, bottomCenter, bottomRight};
        return boardPositions;
    }

    public static void assertSpaceEmptyAndClick(WebDriver driver, String position) {
        String isOccupiedbyO = " .o";
        try {
            driver.findElement(By.cssSelector(position + isOccupiedbyO));
            System.out.println("Position - " + position + " is already occupied by O.");
        } catch (NoSuchElementException ex) {
            driver.findElement(By.cssSelector(position)).click();
        }
    }

    public static boolean checkIfPlayerHasWon(WebDriver driver){
        WebElement player1Score = driver.findElement(By.cssSelector(".player1 .score"));
        WebElement player2Score = driver.findElement(By.cssSelector(".player2 .score"));
        WebElement ties = driver.findElement(By.cssSelector(".ties .score"));
        if(Integer.parseInt(player1Score.getText()) >= 1){
            System.out.println("Game over: You win");
            return false;
        }
        else if(Integer.parseInt(player2Score.getText()) >= 1){
            System.out.println("Game over: Computer wins");
            return false;
        }
        else if(Integer.parseInt(ties.getText()) >= 1){
            System.out.println("Game ended in a tie!");
            return false;
        }
        else return true;
    }

    public static int[] getArrayOfRandomIndexes(int length) {
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

}
