package TestCases.OmniFullfillment;

import org.testng.annotations.Test;

public class TC_01_OmniFullfillmentHomePage_Validations extends BaseClass {

    @Test
    public void TC_01_ValidateHomeScreen() throws Exception {
        try {
            omniFulfillmentPageInstance().waitScreen();
            omniFulfillmentPageInstance().LaunchApplication();
            omniFulfillmentPageInstance().Validate();

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            omniFulfillmentPageInstance().CloseApp();
            omniFulfillmentPageInstance().CloseApp_AutoIT();

        }
    }
}
