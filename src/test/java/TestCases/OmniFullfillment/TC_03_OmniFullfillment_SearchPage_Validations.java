package TestCases.OmniFullfillment;

//import ExtendReports.ExtendReportManager;
import PageObjects.OmniFullfillmentSearchPage;
import com.jacob.com.LibraryLoader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.LogStatus;

import java.io.File;

public class TC_03_OmniFullfillment_SearchPage_Validations {

   // ExtendReportManager extendReportManager=new ExtendReportManager();
    OmniFullfillmentSearchPage search;

    @BeforeTest
    public void Initialise() {
        search = new OmniFullfillmentSearchPage();
        String jacobDllVersionToUse;
        if (System.getProperty("sun.arch.data.model").contains("32")) {
            jacobDllVersionToUse = "jacob-1.18-x86.dll";
        } else {
            jacobDllVersionToUse = "jacob-1.18-x64.dll";
        }

        File file = new File("src\\main\\resources\\Lib", jacobDllVersionToUse);
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

//        extendReportManager.extent=new ExtentReports(System.getProperty("user.dir")+"MyExtendReport.html",true);
//        extendReportManager.extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
//        extendReportManager.logger=extendReportManager.extent.startTest(("Validate Search Page of OmniFullfillment"));
//        // logger=extent.startTest((this.getClass().getSimpleName()+"::"+method.getName()),method.getName());
    }

    @Test
    public void Validate_SearchPage() throws Exception {
        try {
            search.waitTillPageLoad();
            search.LaunchOmniFullfillment();
            search.Validate_SearchPage_Contents();
           // extendReportManager.logger.log(LogStatus.PASS,"Test Case Passed");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
           // extendReportManager.logger.log(LogStatus.FAIL,"Test Case Failed");
        }
    }

    @AfterTest
    public void closeApp() throws Exception {
        search.CloseOmniFullfillment();
    }
}
