package web.test;

import org.testng.annotations.Test;

import static pages.DouMainPage.*;

public class DouMainTest {

    @Test
    public void testHeaderElements(){
        openDou();
        assertHeaderElements();
    }
}
