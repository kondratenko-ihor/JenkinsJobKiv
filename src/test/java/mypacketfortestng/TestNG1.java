package mypacketfortestng;

import io.qameta.allure.AllureResultsWriter;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;
import io.qameta.allure.testng.Tags;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Locale;
import java.util.Random;

import static io.qameta.allure.Allure.step;

public class TestNG1 {

    static String testName;

    @BeforeSuite
    void setUpTestName() {
        String[] namesList = {"Jack", "Bob", "Bill", ""};
        testName = namesList[new Random().nextInt(namesList.length)];
        step("Launch from test branch " + "[ "+ testName + " ] ");
    }

//    @BeforeTest
//    void setUpTestName() {
//        String[] namesList = {"Jack", "Bob", "Bill", ""};
//        testName = namesList[new Random().nextInt(namesList.length)];
//        step("Step 1: the name is: " + "[ "+ testName + " ] ");
//    }


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
    void checkNameNotEmpty(){
        step("Step 1: Checking the name not empty ", () ->
                Assert.assertTrue(testName.length() > 0, "Name is empty"));
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
