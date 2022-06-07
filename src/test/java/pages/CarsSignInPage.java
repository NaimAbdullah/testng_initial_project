package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarsSignInPage {
    public CarsSignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='Sign in']")
    public WebElement heading1;

    @FindBy(className = "signup-block")
    public WebElement paragraphHeader;

    @FindBy(xpath = "//label[text()='Email']")
    public WebElement emailInputBoxText;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(xpath = "//label[text()='Password']")
    public WebElement passwordInputBoxText;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(className = "sds-helper-text")
    public WebElement passwordWarning;

    @FindBy(css = ".password-help a")
    public WebElement forgotPasswordLink;

    @FindBy(className = "sds-disclaimer")
    public WebElement termsOfService;

    @FindBy(css = ".sds-field button")
    public WebElement signInButton;

    @FindBy(className = "sds-heading--3")
    public WebElement connectWithSocialHeading;

    @FindBy(css = ".column-2 ul a")
    public List<WebElement> socialLinks;

    @FindBy(className = "sds-notification__content")
    public WebElement signInErrorMessage;
}
