package amazonPages;
import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MainWeighPage {

    public MainWeighPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id ="left_0" )
    public WebElement left0;

    @FindBy(id = "left_1")
    public WebElement left1;

    @FindBy(id ="left_2" )
    public WebElement left2;

    @FindBy(id ="left_3" )
    public WebElement left3;

    @FindBy(id ="left_4" )
    public WebElement left4;

    @FindBy(id ="right_0" )
    public WebElement right0;

    @FindBy(id = "right_1")
    public WebElement right1;

    @FindBy(id ="right_2" )
    public WebElement right2;

    @FindBy(id ="right_3" )
    public WebElement right3;

    @FindBy(id ="right_4" )
    public WebElement right4;

    @FindBy(id ="weigh" )
    public WebElement weigh;

    @FindBy(xpath ="//div/button[@id='weigh']/preceding-sibling::button" )
    public WebElement reset;

    @FindBy(xpath ="//div[@class='game-info']/ol/li" )
    public List<WebElement> listOfResults;

    @FindBy(id = "coin_0")
    public WebElement coin0;

    @FindBy(id = "coin_1")
    public WebElement coin1;

    @FindBy(id = "coin_2")
    public WebElement coin2;

    @FindBy(id = "coin_3")
    public WebElement coin3;

    @FindBy(id = "coin_4")
    public WebElement coin4;

    @FindBy(id = "coin_5")
    public WebElement coin5;

    @FindBy(id = "coin_6")
    public WebElement coin6;

    @FindBy(id = "coin_7")
    public WebElement coin7;

    @FindBy(id = "coin_8")
    public WebElement coin8;

}
