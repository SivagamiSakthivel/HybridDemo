package PageObjects;

import TestCases.OmniFullfillment.BaseClass;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.testng.Assert;
import TestCases.OmniFullfillment.BaseClass;

import static TestCases.OmniFullfillment.BaseClass.*;

public class OmniFullfillmentSearchPage extends BaseClass
{
   // BaseClass base=new BaseClass();

    Pattern imageOmniFullfillmentIcon = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\OmniFullfillmentLogo.png");
    Pattern imageDetailsIcon = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\SearchPage\\DetailsIcon.png");
    Pattern imagePrinterSettings = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\SearchPage\\PrinterSettings.png");
    Pattern imageVersionNumber = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\SearchPage\\VersionNumber.png");
    Pattern imageReportIssue = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\SearchPage\\ReportIssue.png");
    Pattern imageStartDiagnostics = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\SearchPage\\StartDiagnostics.png");


    public void waitTillPageLoad() throws FindFailed
    {
        try
        {
            waitScreen();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void LaunchOmniFullfillment() throws Exception
    {
        try{

            LaunchApplication(imageOmniFullfillmentIcon);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void CloseOmniFullfillment() throws Exception
    {
        try
        {
            CloseApp();
            CloseApp_AutoIT();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public void Validate_SearchPage_Contents() throws FindFailed,Exception
    {
        try
        {
            Thread.sleep(10000);
            clickUsingAutoIT();
            VerifyImagePresence(imagePrinterSettings);
            VerifyImagePresence(imageVersionNumber);
            VerifyImagePresence(imageReportIssue);
            VerifyImagePresence(imageStartDiagnostics);
        }
//        catch (Exception ex)
//        {
//            System.out.println(ex.getMessage());
//            throw new Exception("xxxxxx");
//        }
        catch (FindFailed findFailed)
        {
            System.out.println(findFailed.getMessage());
            throw new Exception("xxxxxx");
        }
    }
}

