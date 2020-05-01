package Steps;

import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public  void InitializeTest(){
        System.out.println("Opening the browser : MOCK ");
        base.steepInfo = "FireFox Webdriver";
    }

    @After
    public void TearDownTest(){
        System.out.println("Closing the browser : MOCK");
        System.out.println();
    }
}
