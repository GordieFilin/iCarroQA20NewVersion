package tests;

import dto.UserDTO;
import manager.ApplicationManager;
import manager.TestNGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.RandomUtils;

import java.lang.reflect.Method;

@Listeners(TestNGListener.class)
public class BaseTest {

    Logger logger = LoggerFactory.getLogger(BaseTest.class);
    static ApplicationManager app = new ApplicationManager();

    RandomUtils randomUtils = new RandomUtils();

    @BeforeSuite(alwaysRun = true)

    public void setup(){
        app.init();
    }

    @AfterSuite(alwaysRun = true)

    public void stop(){
        app.tearDown();
    }

    public void logoutIfLogin(){
        if(app.getUserHelper().btnLogoutExist()){
            app.getUserHelper().logout();
        }
    }

    public void alwaysLogin(){
        UserDTO userDTO = new UserDTO("gordie@gmail.com", "123456Aa!");
        app.getUserHelper().login(userDTO);
    }

    @BeforeMethod
    public void loggerBe4Method(Method method){
        logger.info("start method: " + method.getName());
    }

    @BeforeMethod
    public void loggerAfterMethod(Method method){
        logger.info("stop method: " + method.getName());
    }

}
