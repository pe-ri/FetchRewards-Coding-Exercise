package Utils;

import org.openqa.selenium.WebElement;

public class UtilityMethods {

    public static void clickOnEmptyGold( WebElement[] coins, String coin){
        for(WebElement c:coins){
            if(c.getText().equals(coin)){
                c.click();
                break;
            }
        }
    }

}
