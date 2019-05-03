package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ticTacToeHomePage {

    private final WebDriver driver = new ChromeDriver();

    WebElement topLeft = driver.findElement(By.cssSelector(".square.top.left"));
    WebElement topCenter = driver.findElement(By.cssSelector(".square.top"));
    WebElement topRight = driver.findElement(By.cssSelector(".square.top.right"));
    WebElement middleLeft = driver.findElement(By.cssSelector(".square.left"));
    WebElement middleCenter = driver.findElement(By.cssSelector(".square"));
    WebElement middleRight = driver.findElement(By.cssSelector(".square.right"));
    WebElement bottomLeft = driver.findElement(By.cssSelector(".square.bottom.left"));
    WebElement bottomCenter = driver.findElement(By.cssSelector(".square.bottom"));
    WebElement bottomRight = driver.findElement(By.cssSelector(".square.bottom.right"));

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
        String isOccupiedbyX = " .x";
        int turn = 0;
        try {
            if(turn == 0){
                driver.findElement(By.cssSelector(position + isOccupiedbyX));
                System.out.println("Position: " + position + isOccupiedbyX + " is taken by X. Turn: " + turn);
                turn++;
            }
            else if(turn == 1){
                driver.findElement(By.cssSelector(position + isOccupiedbyO));
                System.out.println("Position: " + position + isOccupiedbyO + " is taken by O.");
                //fail("The spot has been used");
            }
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

}
