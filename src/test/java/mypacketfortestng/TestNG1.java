package mypacketfortestng;

import io.qameta.allure.AllureResultsWriter;
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
    void setUpTestName() {
        String[] namesList = {"Jack", "Bob", ""};
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