package scripts;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _01_CarsTest extends Base{

    @Test(priority = 1, description = "TASK-1 - Sign in Page Form")
    public void testSignInPageForm(){
        driver.get("https://www.cars.com/");
        carsHomePage.signInButton.click();
        // Added a waiter here because the source code was running too fast and could not get the right URL in the Assert
        Waiter.pause(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F");

        Assert.assertEquals(carsSignInPage.heading1.getText(), "Sign in");

        Assert.assertEquals(carsSignInPage.paragraphHeader.getText(), "New to Cars.com? Sign up. Are you a dealer?");

        Assert.assertEquals(carsSignInPage.emailInputBoxText.getText(), "Email");
        Assert.assertTrue(carsSignInPage.emailInputBox.isEnabled());

        Assert.assertEquals(carsSignInPage.passwordInputBoxText.getText(), "Password");
        Assert.assertTrue(carsSignInPage.passwordInputBox.isEnabled());

        Assert.assertEquals(carsSignInPage.passwordWarning.getText(), "Minimum of eight characters");

        Assert.assertEquals(carsSignInPage.forgotPasswordLink.getText(), "Forgot password?");

        Assert.assertEquals(carsSignInPage.termsOfService.getText(), "By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.");

        Assert.assertEquals(carsSignInPage.signInButton.getText(), "Sign in");
        Assert.assertTrue(carsSignInPage.signInButton.isDisplayed());
        Assert.assertTrue(carsSignInPage.signInButton.isEnabled());
    }

    @Test(priority = 2, description = "TASK-2 - Social Media Section")
    public void testMediaSection(){
        driver.get("https://www.cars.com/");
        carsHomePage.signInButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F");

        Assert.assertEquals(carsSignInPage.connectWithSocialHeading.getText(), "Connect with social");

        for (int i = 0; i < carsSignInPage.socialLinks.size(); i++) {
            Assert.assertTrue(carsSignInPage.socialLinks.get(i).isDisplayed());
            Assert.assertTrue(carsSignInPage.socialLinks.get(i).isEnabled());

            switch (i){
                case 0:
                    Assert.assertEquals(carsSignInPage.socialLinks.get(i).getText(), "Sign in with Facebook");
                    break;
                case 1:
                    Assert.assertEquals(carsSignInPage.socialLinks.get(i).getText(), "Sign in with Google");
                    break;
                case 2:
                    Assert.assertEquals(carsSignInPage.socialLinks.get(i).getText(), "Sign in with Apple");
                    break;
                default:
                    throw new NoSuchElementException("This element was not found!!");
            }
        }
    }

    @Test(priority = 3, description = "TASK-3 - Invalid Credentials")
    public void testInvalidCredentials(){
        driver.get("https://www.cars.com/");
        carsHomePage.signInButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cars.com/signin/?redirect_path=%2F");

        carsSignInPage.emailInputBox.sendKeys("johndoe@gmail.com");
        carsSignInPage.passwordInputBox.sendKeys("abcd1234");
        carsSignInPage.signInButton.click();

        Assert.assertEquals(carsSignInPage.signInErrorMessage.getText(), "We were unable to sign you in.\n" +
                "Your email or password was not recognized. Try again soon.");
    }
}
