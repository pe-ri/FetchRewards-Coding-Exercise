package amazonTests;

import Utils.Driver;
import Utils.UtilityMethods;
import amazonPages.MainWeighPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AmazonWeighTest {

    WebDriver driver = Driver.getDriver();
    MainWeighPage mainWeighPage = new MainWeighPage();
    public static String leftBowl;
    public static String rightBowl;
    public static String weighResult;




    @Test
    public void validateFunctionalities(){
        driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/");
                                //1                  //2
        WebElement[] coins = {mainWeighPage.coin1,mainWeighPage.coin2,mainWeighPage.coin3,
                mainWeighPage.coin4,mainWeighPage.coin5,mainWeighPage.coin6, mainWeighPage.coin7,mainWeighPage.coin8};

        WebElement [] squares = {mainWeighPage.left0,mainWeighPage.left1,mainWeighPage.left2,
                mainWeighPage.left3,mainWeighPage.right0,mainWeighPage.right1,mainWeighPage.right2,mainWeighPage.right3};

        for(int i=0;i<coins.length;i++){
            squares[i].sendKeys(coins[i].getText());
        }
        mainWeighPage.weigh.click();

        for(int i = 0;i<coins.length/2;i++) {
            weighResult = mainWeighPage.listOfResults.get(mainWeighPage.listOfResults.size()-1).getText().replaceAll("[\\[,\\] .]","");
            String sign = weighResult.substring(weighResult.length()/2,weighResult.length()/2+1);
            if (!sign.equals("=")) {
                weighResult = (sign.equals("<")) ? weighResult.substring(0,weighResult.length()/2) : weighResult.substring(weighResult.length()/2+1);

                if(weighResult.length()==1){
                    System.out.println(weighResult+" is fake Gold");
                    break;
                }

                leftBowl = weighResult.substring(0,weighResult.length()/2);
                rightBowl = weighResult.substring(weighResult.length()/2);
                mainWeighPage.reset.click();
                mainWeighPage.left0.sendKeys(leftBowl.substring(0,1));
                mainWeighPage.left1.sendKeys(leftBowl.substring(1));
                mainWeighPage.right0.sendKeys(rightBowl.substring(0,1));
                mainWeighPage.right1.sendKeys(rightBowl.substring(1));
                mainWeighPage.weigh.click();
            } else {
                System.out.println(0 +" is fake Gold");
                mainWeighPage.coin0.click();
                break;
            }
        }
        UtilityMethods.clickOnEmptyGold(coins,weighResult);
        String actualAlertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertMessage,"Yay! You find it!");
        }
    }

