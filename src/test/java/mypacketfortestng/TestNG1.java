package mypacketfortestng;

import io.qameta.allure.AllureResultsWriter;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Random;

public class TestNG1 {

    static String testName;

//    @BeforeSuite
//    void beforeSuit() {
//        System.out.println("'Before suite'");
//    }

    @BeforeTest
    @Step("Setting name {testName}")
    void setUpTestName() {
        String[] namesList = {"Jack", "Bob", "Bill", ""};
        testName = namesList[new Random().nextInt(namesList.length)];
        System.out.println("Name is " + "[" + testName + "]");
    }


    @BeforeGroups({"nameTests"})
    void beforeGroups() {
        System.out.println("BEFORE GROUPS");
    }

    @AfterGroups({"nameTests"})
    void afterGroup() {
        System.out.println("AFTER GROUPS");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("BEFORE CLASS ANNOTATION");
    }

    @Story("Checking the name is not empty")
    @Test
    @Step("Checking the name isn't empty {testName} step")
    void checkNameNotEmpty(){
        Assert.assertTrue(testName.length() > 0);
    }

    @Test
    void checkNameNotContainsSymbols(){
        Assert.assertFalse(testName.contains("^&"));
    }


    @Test
    void nameNotEmpty() {
        System.out.println("Check name isn't empty");
        Assert.assertTrue(testName.length() > 0, "Name is empty");
    }

    @Test(dependsOnMethods = "nameNotEmpty", alwaysRun = true)
    void checkNameIsJack() {
        System.out.println("Checking name is Jack");
        Assert.assertEquals(testName, "Jack", "Name not Jack");
    }

    @Test(dependsOnMethods = "nameNotEmpty", alwaysRun = true)
    void checkNameIsBob() {
        System.out.println("Checking name is Bob");
        Assert.assertEquals(testName, "Bob", "Name not Bob");
    }


    @AfterTest
    void cleanUp() {
        testName = "";
        System.out.println("testName after tests: " + testName);
    }
}
