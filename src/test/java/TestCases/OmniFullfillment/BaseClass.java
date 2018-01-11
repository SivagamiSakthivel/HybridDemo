package TestCases.OmniFullfillment;

import java.io.File;
import java.io.IOException;

import PageObjects.OmniFullfillmenHomePage;
import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;
import org.sikuli.script.*;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

    private static OmniFullfillmenHomePage omniFullfillmentPage;
    Screen screen;


    Pattern imageProjectscreen = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\ItemInquiry\\Images\\Projectmyscreen.png");
    Pattern imageprojectmyscreenmax = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\ItemInquiry\\Images\\Projectmyscreenmax.png");
    Pattern imageOmniFullfillmentIcon = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\OmniFullfillmentLogo.png");
    Pattern imagebackArrow = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\backButton.png");


    public static OmniFullfillmenHomePage omniFulfillmentPageInstance() {
        if (omniFullfillmentPage == null)
            omniFullfillmentPage = new OmniFullfillmenHomePage();
        return omniFullfillmentPage;
    }

    @BeforeSuite(alwaysRun = true)
    public void InitBeforeSuite() {
        String jacobDllVersionToUse;
        if (System.getProperty("sun.arch.data.model").contains("32")) {
            jacobDllVersionToUse = "jacob-1.18-x86.dll";
        } else {
            jacobDllVersionToUse = "jacob-1.18-x64.dll";
        }
        File file = new File("src\\main\\resources\\Lib", jacobDllVersionToUse);
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
        screen = new Screen();
    }

    //Reusable Methods
    public void waitScreen() throws FindFailed {
        screen.wait(imageProjectscreen, 10);
    }

    /*Method to Launch the application
     */
    public void LaunchApplication(Pattern iconToBeLaunched) throws FindFailed {
        screen.click(imageProjectscreen);
        //screen.doubleClick(imageprojectmyscreenmax);
        ScreenImage file = screen.capture(screen.getBounds());
        screen.click(iconToBeLaunched);
    }

    /*
    Method to click an object(image)
     */
    public void click(Pattern imgToClick) throws FindFailed {
        Match val = screen.exists(imgToClick);
        Assert.assertTrue(val.isValid());
        screen.click(imgToClick);
    }

    /*
    Click Element using AutoIT
     */
    public void clickUsingAutoIT() {

    }

    /*Method to verify image presence in screen
    **Input: Image to be verified
     */
    public void VerifyImagePresence(Pattern img) throws Exception {
        Match val = screen.exists(img);
        assert val.isValid();
        if (val.isValid()) {
            System.out.println(val);
            System.out.println(img.getFilename() + "Image present");
        } else {
            System.out.println("Image not loaded");
            throw new Exception("Image not loaded");
        }
    }


    /*Sikuli Functions*/
    public void CloseApp() throws FindFailed, InterruptedException {

        screen.click(imagebackArrow);
        screen.mouseDown(Button.LEFT);
        Thread.sleep(5000);
        //screen.aSwipeDown();

    }

    /* Close App With Auto It Script  **/
    public void CloseApp_AutoIT() throws IOException {
        AutoItX x= new AutoItX();
        x.winWaitActive("Project My Screen App");
        x.mouseClick("left", 753, 228, 1, 1);
        x.mouseUp("left");
    }
}
